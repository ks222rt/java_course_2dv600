package ks222rt_assign3;

import graphs.DirectedGraph;
import graphs.Node;

import java.util.*;

/**
 * Created by Kristoffer on 2016-09-27.
 */
public class MyBFS<E> implements graphs.BFS<E>{

    /**
     * Returns the nodes visited by a breadth-first search starting from
     * the given root node. Each visited node is also attached with
     * a breadth-first number.
     */
    @Override
    public List<Node<E>> bfs(DirectedGraph<E> graph, Node<E> root) {
        List<Node<E>> nodeList = new ArrayList<>();
        Queue<Node<E>> nodeQueue = new LinkedList<>();
        List<Node<E>> visitedList = new ArrayList<>();

        nodeQueue.add(graph.getNodeFor(root.item()));
        visitedList.add(graph.getNodeFor(root.item()));

        while(!nodeQueue.isEmpty()){
            Node<E> node = nodeQueue.peek();

            Iterator<Node<E>> it = node.succsOf();
            while(it.hasNext()){
                Node<E> child = it.next();
                if (!visitedList.contains(child)){
                    visitedList.add(child);
                    nodeQueue.add(child);
                }
            }

            node.num = nodeList.size();
            nodeList.add(node);
            nodeQueue.remove();
        }

        return nodeList;
    }

    /**
     * Returns the nodes visited by a breadth first search starting from
     * an arbitrary set of nodes. All nodes are visited. Each visited node is
     * also attached with a breadth-first number.
     */
    @Override
    public List<Node<E>> bfs(DirectedGraph<E> graph) {
        List<Node<E>> nodeList = new ArrayList<>();
        Queue<Node<E>> nodeQueue = new LinkedList<>();
        List<Node<E>> visitedList = new ArrayList<>();
        int count = 0;

        for (E item : graph.allItems()){
            BFS(graph.getNodeFor(item), nodeQueue, visitedList, nodeList, count);
        }


        return nodeList;
    }

    private void BFS(Node<E> node, Queue<Node<E>> nodeQueue, List<Node<E>> visitedList, List<Node<E>> nodeList, int count){
        if (!nodeQueue.contains(node) || !visitedList.contains(node)){
            visitedList.add(node);
            nodeQueue.add(node);
        }

        while(!nodeQueue.isEmpty()){
            Node<E> n = nodeQueue.peek();
            Iterator<Node<E>> it = n.succsOf();

            while(it.hasNext()){
                Node<E> child = it.next();
                if (!visitedList.contains(child)){
                    visitedList.add(child);
                    nodeQueue.add(child);
                }
            }

            if (!nodeList.contains(node)){
                node.num = nodeList.size();
                nodeList.add(node);
            }
            nodeQueue.remove();
        }

    }
}
