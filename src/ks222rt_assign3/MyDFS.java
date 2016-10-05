package ks222rt_assign3;

import graphs.DirectedGraph;
import graphs.Node;

import java.util.*;

/**
 * Created by Kristoffer on 2016-09-27.
 */
public class MyDFS<E> implements graphs.DFS<E> {
    private List<Node<E>> nodeList = new ArrayList<>();
    private Set<Node<E>> visitedList = new HashSet<>();

    /**
     * Returns the nodes visited by a depth first search starting from
     * the given root node. Each visited node is also attached with
     * a depth-first number.
     */
    @Override
    public List<Node<E>> dfs(DirectedGraph<E> graph, Node<E> root) {
        nodeList.clear(); visitedList.clear();

        root = graph.getNodeFor(root.item());
        recursiveDFS(nodeList, root, visitedList);

        return nodeList;
    }

    /**
     * Returns the nodes visited by a depth first search starting from
     * an arbitrary set of nodes. All nodes are visited. Each visited node is
     * also attached with a depth-first number.
     */
    @Override
    public List<Node<E>> dfs(DirectedGraph<E> graph) {
        nodeList.clear(); visitedList.clear();

        for (E item : graph.allItems()){
            Node<E> root = graph.getNodeFor(item);
            if (!visitedList.contains(root)){
                recursiveDFS(nodeList, root, visitedList);
            }
        }

        return nodeList;
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
        nodeList.clear();
        visitedList.clear();
        postOrder(visitedList, nodeList, root);

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
        nodeList.clear();
        visitedList.clear();

        for (E item : g.allItems()){
            postOrder(visitedList, nodeList, g.getNodeFor(item));
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

        for (E item : graph.allItems()){
            Node<E> node = graph.getNodeFor(item);
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
        if (!isCyclic(graph)){
            nodeList.clear();
            visitedList.clear();

            for (E item : graph.allItems()){
                postOrder(visitedList, nodeList, graph.getNodeFor(item));
            }
            Collections.reverse(nodeList);

            return nodeList;
        }
        return null;
    }

    private void topologicalSort(Set<Node<E>> visitedList, List<Node<E>> nodeList, Node<E> root){
        if (!visitedList.contains(root)) {
            visitedList.add(root);
            Iterator it = root.predsOf();
            while (it.hasNext()) {
                Node<E> node = (Node<E>) it.next();
                postOrder(visitedList, nodeList, node);
            }
            root.num = nodeList.size();
            nodeList.add(root);
        }
    }

    private void recursiveDFS(List<Node<E>> nodeList, Node<E> root, Set<Node<E>> visitedList){
        if (!visitedList.contains(root)) {
            root.num = nodeList.size();
            nodeList.add(root);
            visitedList.add(root);
            Iterator<Node<E>> it = root.succsOf();
            while (it.hasNext()) {
                recursiveDFS(nodeList, it.next(), visitedList);
            }
        }
    }

    private void stackDFS(ArrayDeque<Node<E>> stack, Set<Node<E>> visitedList, List<Node<E>> nodeList, Node<E> root){
        stack.addFirst(root);

        while(!stack.isEmpty()){
            Node<E> node = stack.removeFirst();
            if (!visitedList.contains(node)){
                node.num = nodeList.size();
                nodeList.add(node);
                visitedList.add(node);

                Iterator<Node<E>> it = node.succsOf();
                while(it.hasNext()){
                    Node<E> next = it.next();
                    if (!stack.contains(next) || !visitedList.contains(next)){
                        stack.addFirst(next);
                    }
                }
            }
        }
    }


    private void postOrder(Set<Node<E>> visited, List<Node<E>> nodeList, Node<E> root){
        // Got help from http://eli.thegreenplace.net/2015/directed-graph-traversal-orderings-and-applications-to-data-flow-analysis/
        if (!visited.contains(root)) {
            visited.add(root);
            Iterator<Node<E>> it = root.succsOf();
            while (it.hasNext()) {
                postOrder(visited, nodeList, it.next());
            }
            root.num = nodeList.size();
            nodeList.add(root);
        }
    }

}
