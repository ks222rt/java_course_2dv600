package ks222rt_assign3;

import graphs.DirectedGraph;
import graphs.Node;

import java.util.*;

/**
 * Created by Kristoffer on 2016-09-27.
 */
public class MyDFS<E> implements graphs.DFS<E> {
    private List<Node<E>> nodeList;
    private Set<Node<E>> visitedList = new HashSet<>();
    /**
     * Returns the nodes visited by a depth first search starting from
     * the given root node. Each visited node is also attached with
     * a depth-first number.
     */
    @Override
    public List<Node<E>> dfs(DirectedGraph<E> graph, Node<E> root) {
        // Clear the required lists
        nodeList = new ArrayList<>(); visitedList.clear();

        // Get the root node from the graph and call the recursive DFS method
        root = graph.getNodeFor(root.item());
        recursiveDFS(nodeList, root, visitedList); // O(1)

        return nodeList;
    }

    /**
     * Returns the nodes visited by a depth first search starting from
     * an arbitrary set of nodes. All nodes are visited. Each visited node is
     * also attached with a depth-first number.
     */
    @Override
    public List<Node<E>> dfs(DirectedGraph<E> graph) {
        // Clear the required lists
        nodeList = new ArrayList<>(); visitedList.clear();

        // For every node in the graph call the recursive DFS method if they aint been visited yet
        for (Node<E> node : graph){ // O(n)
            if (!visitedList.contains(node)){ // O(1)
                recursiveDFS(nodeList, node, visitedList); // O(1)
            }
        }

        return nodeList;    // O(n + e)
    }

    /**
     * Returns a list of nodes ordered as
     * post-order of the depth first tree resulting from a
     * depth first search starting at the given root node.
     * Notice, it only visits nodes reachable from given
     * root node.
     * </p>
     * The algorithm also attaches a post-order number
     * to each visited node.
     */
    @Override
    public List<Node<E>> postOrder(DirectedGraph<E> g, Node<E> root) {
        // Create a new nodeList and clear the visited list
        nodeList = new LinkedList<>(); visitedList.clear();

        // call the recursive postOrder method
        postOrder(visitedList, nodeList, g.getNodeFor(root.item()));
        return nodeList;
    }

    /**
     * Returns a list of ALL nodes in the graph ordered as
     * post-order of the depth first forest resulting from
     * depth first search starting at arbitrary start nodes.
     * </p>
     * The algorithm also attaches a post-order number
     * to each visited node.
     */
    @Override
    public List<Node<E>> postOrder(DirectedGraph<E> g) {
        // Create a new nodeList and clear the visisted list
        nodeList = new LinkedList<>(); visitedList.clear();

        // Call postorder on every node in the graph
        for (Node<E> node : g){
            postOrder(visitedList, nodeList, node);
        }

        return nodeList;
    }

    @Override
    public List<Node<E>> postOrder(DirectedGraph<E> g, boolean attach_dfs_number) {
        return null;
    }

    /**
     * Returns <tt>true</tt> if the graph contains one or more cycles,
     * otherwise <tt>false</tt>
     */
    @Override
    public boolean isCyclic(DirectedGraph<E> graph) {
        // For every node in the graph check if anyone of the successors go back to the node
        for (Node<E> node : graph){
            Iterator<Node<E>> it = node.succsOf();
            while(it.hasNext()){
                if (node == it.next()){
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Returns a list of all nodes in the graph ordered topological.
     * The algorithm assumes that the graph is acyclic. The result for
     * graphs with cycles are undefined.
     */
    @Override
    public List<Node<E>> topSort(DirectedGraph<E> graph) {
        // First check if the graph is cyclic
        if (!isCyclic(graph)){
            // Then create a new nodeList and clear the visited
            nodeList = new LinkedList<>(); visitedList.clear();

            // For every node in the graph, call postOrder method
            for (Node<E> node : graph){
                postOrder(visitedList, nodeList, node);
            }
            // Before returning the list, reverse it
            Collections.reverse(nodeList);

            return nodeList;
        }
        return null;
    }

    private void topologicalSort(Set<Node<E>> visitedList, List<Node<E>> nodeList, Node<E> root){
        // check if the root node already been visited
        if (!visitedList.contains(root)) {
            // Mark the node as visisted
            visitedList.add(root);

            // Iterate through all the predecessors
            Iterator it = root.predsOf();
            while (it.hasNext()) {
                Node<E> node = (Node<E>) it.next();
                postOrder(visitedList, nodeList, node);
            }

            // Add nodelist size to node num and add it to the nodelist
            root.num = nodeList.size();
            nodeList.add(root);
        }
    }

    private void recursiveDFS(List<Node<E>> nodeList, Node<E> root, Set<Node<E>> visitedList){
        // Check if root node been visited
        if (!visitedList.contains(root)) { // O(1)
            // Give the nodes num the size of the nodelist and add it to nodelist and mark it as visited
            root.num = nodeList.size(); // O(1)
            nodeList.add(root); // O(1)
            visitedList.add(root); // O(1)

            // Iterate through the successors of the node and call the recursive method
            Iterator<Node<E>> it = root.succsOf(); // O(1)
            while (it.hasNext()) { // O(e)
                recursiveDFS(nodeList, it.next(), visitedList); // O(n)
            }
        }
        // O(n + e)
    }

    private void stackDFS(Set<Node<E>> visitedList, List<Node<E>> nodeList, Node<E> root){
        // Create a stack and add the root node to the stack
        List<Node<E>> stack = new LinkedList<>();
        stack.add(root);

        while(!stack.isEmpty()){
            // Remove the first node in the stack
            Node<E> node = stack.remove(0);
            if (!visitedList.contains(node)){
                // Give the node num a number and add it to the nodelist and mark it as visited.
                node.num = nodeList.size();
                nodeList.add(node);
                visitedList.add(node);

                // Iterate through its successors and add them first in the stack
                Iterator<Node<E>> it = node.succsOf();
                while(it.hasNext()){
                    Node<E> next = it.next();
                    if (!stack.contains(next) || !visitedList.contains(next)){
                        stack.add(0, next);
                    }
                }
            }
        }
    }

    private void postOrder(Set<Node<E>> visited, List<Node<E>> nodeList, Node<E> root){
        // Got help from http://eli.thegreenplace.net/2015/directed-graph-traversal-orderings-and-applications-to-data-flow-analysis/
        // Check if the node has not been visited
        if (!visited.contains(root)) {
            // Mark it as visited and..
            visited.add(root);

            // .. iterate through its successors
            Iterator<Node<E>> it = root.succsOf();
            while (it.hasNext()) {
                postOrder(visited, nodeList, it.next());
            }

            // Give the node a number and add it to the nodeList
            root.num = nodeList.size();
            nodeList.add(root);
        }
    }

}
