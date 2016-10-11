package ks222rt_assign3;

import graphs.DirectedGraph;
import graphs.Node;

import java.util.*;

/**
 * Created by Kristoffer on 2016-09-27.
 */
public class MyBFS<E> implements graphs.BFS<E>{
    private List<Node<E>> nodeList = new LinkedList<>();
    private Set<Node<E>> nodeQueue = new HashSet<>();
    private Set<Node<E>> visitedList = new HashSet<>();

    /**
     * Returns the nodes visited by a breadth-first search starting from
     * the given root node. Each visited node is also attached with
     * a breadth-first number.
     */
    @Override
    public List<Node<E>> bfs(DirectedGraph<E> graph, Node<E> root) {
        // Clear all the lists required
        nodeList.clear(); nodeQueue.clear(); visitedList.clear();
        // Get the root node from the graph and add it to the queue
        root = graph.getNodeFor(root.item());
        nodeQueue.add(root);
        // Call the recursive BFS method to get the nodelist full
        recursiveBFS(nodeQueue, visitedList, nodeList);

        return nodeList; // O(n + e)
    }

    /**
     * Returns the nodes visited by a breadth first search starting from
     * an arbitrary set of nodes. All nodes are visited. Each visited node is
     * also attached with a breadth-first number.
     */
    @Override
    public List<Node<E>> bfs(DirectedGraph<E> graph) {
        // Clear all the required lists
        nodeList.clear(); nodeQueue.clear(); visitedList.clear();

        // For every node in the graph call the BFS method
        for(Node<E> node : graph)  // O(n)
        {
            if (!visitedList.contains(node)){ // O(1)
                nodeQueue.add(node); // O(1)
                recursiveBFS(nodeQueue, visitedList, nodeList);  // O(n + c)
            }
        }

        return nodeList;  // O(n(n+e)) = O(n^2 + ne)
    }

    private void nonRecursiveBFS(Node<E> node, Set<Node<E>> visitedList, List<Node<E>> nodeList){
        // Non-recursive bfs method
        Queue<Node<E>> nodeQueue = new LinkedList<>();
        nodeQueue.add(node);

        // While queue aint empty go through every node and add them to the node +
        // queue theirs childrens
        while(!nodeQueue.isEmpty()){
            Node<E> next = nodeQueue.remove();
            if (!visitedList.contains(next)){
                visitedList.add(next);
                next.num = nodeList.size();
                nodeList.add(next);
                next.succsOf().forEachRemaining(childs -> nodeQueue.add(childs));
            }
        }
    }

    private void recursiveBFS(Set<Node<E>> nodeQueue, Set<Node<E>> visitedList, List<Node<E>> nodeList){
        // As long as the queue aint empty keep call the recursive method
        if (!nodeQueue.isEmpty()) {  // O(1)
            // Iterate through the queue of nodes
            Iterator<Node<E>> it = nodeQueue.iterator(); // O(1)

            // Re-initiate the queue so the iterator works
            nodeQueue = new HashSet<>(); // O(1)

            while(it.hasNext()){ // O(n)
                Node<E> node = it.next(); // O(1)

                // Check if the node already been visited
                if (!visitedList.contains(node)) { // O(1)

                    // Add it to the visit list, set the num to nodeList size and add it to nodeList
                    visitedList.add(node); // O(1)
                    node.num = nodeList.size(); // O(1)
                    nodeList.add(node); // O(1)
                }

                // Iterate through the nodes children
                Iterator<Node<E>> nodeIT = node.succsOf(); // O(1)

                while(nodeIT.hasNext()){  // O(c)
                    Node<E> child = nodeIT.next(); // O(1)

                    // Check if the child has been visited, if not add to queue
                    if (!visitedList.contains(child)){ // O(1)
                        nodeQueue.add(child); // O(1)
                    }
                }
            }

            recursiveBFS(nodeQueue, visitedList, nodeList); // O(1)
            // Time complexity O(n + c)
        }
    }
}
