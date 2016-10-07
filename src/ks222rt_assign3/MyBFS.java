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
        nodeList.clear(); nodeQueue.clear(); visitedList.clear();
        root = graph.getNodeFor(root.item());
        nodeQueue.add(root);
        recursiveBFS(nodeQueue, visitedList, nodeList);

        return nodeList;
    }

    /**
     * Returns the nodes visited by a breadth first search starting from
     * an arbitrary set of nodes. All nodes are visited. Each visited node is
     * also attached with a breadth-first number.
     */
    @Override
    public List<Node<E>> bfs(DirectedGraph<E> graph) {
        nodeList.clear(); nodeQueue.clear(); visitedList.clear();
        for (E item : graph.allItems()){
            Node<E> node = graph.getNodeFor(item);
            if (!visitedList.contains(node)){
                nodeQueue.add(node);
                recursiveBFS(nodeQueue, visitedList, nodeList);
            }
        }
        return nodeList;
    }

    private void nonRecursiveBFS(Node<E> node, Set<Node<E>> visitedList, List<Node<E>> nodeList){
        Queue<Node<E>> nodeQueue = new LinkedList<>();
        nodeQueue.add(node);

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
        if (!nodeQueue.isEmpty()) {

            Iterator<Node<E>> it = nodeQueue.iterator();
            nodeQueue = new HashSet<>();
            while(it.hasNext()){
                Node<E> node = it.next();
                if (!nodeList.contains(node)) {
                    visitedList.add(node);
                    node.num = nodeList.size();
                    nodeList.add(node);
                }

                Iterator<Node<E>> nodeIT = node.succsOf();
                while(nodeIT.hasNext()){
                    Node<E> child = nodeIT.next();
                    if (!visitedList.contains(child)){
                        nodeQueue.add(child);
                    }
                }
            }

            recursiveBFS(nodeQueue, visitedList, nodeList);
        }
    }
}
