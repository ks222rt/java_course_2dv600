package ks222rt_assign3;

import graphs.DirectedGraph;
import graphs.Node;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Kristoffer on 2016-09-27.
 */
public class MyDFS<E> implements graphs.DFS<E> {

    /**
     * Returns the nodes visited by a depth first search starting from
     * the given root node. Each visited node is also attached with
     * a depth-first number.
     */
    @Override
    public List<Node<E>> dfs(DirectedGraph<E> graph, Node<E> root) {
        List<Node<E>> nodeList = new ArrayList<>();
        dfs(nodeList, graph.getNodeFor(root.item()));

        return nodeList;
    }

    /**
     * Returns the nodes visited by a depth first search starting from
     * an arbitrary set of nodes. All nodes are visited. Each visited node is
     * also attached with a depth-first number.
     */
    @Override
    public List<Node<E>> dfs(DirectedGraph<E> graph) {
        List<Node<E>> nodeList = new ArrayList<>();

        for (E item : graph.allItems()){
            dfs(nodeList, graph.getNodeFor(item));
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
        List<Node<E>> nodeList = new ArrayList<>();
        List<Node<E>> visitedList = new ArrayList<>();
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
        List<Node<E>> nodeList = new ArrayList<>();
        List<Node<E>> visitedList = new ArrayList<>();
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
            List<Node<E>> nodeList = new ArrayList<>();
            List<Node<E>> visitedList = new ArrayList<>();
//            List<Node<E>> temp = new ArrayList<>();


//            Either do this ugly method or the below
//            for (E item : graph.allItems()){
//                postOrder(visitedList, nodeList, graph.getNodeFor(item));
//            }
//
//            for (int i = 0; i < nodeList.size(); i++){
//                temp.add(nodeList.get(nodeList.size()- 1 - i));
//            }

            for (E item : graph.allItems()){
                topologicalSort(visitedList, nodeList, graph.getNodeFor(item));
            }

            return nodeList;
        }
        return null;
    }

    private void topologicalSort(List<Node<E>> visitedList, List<Node<E>> nodeList, Node<E> root){
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

    private void dfs(List<Node<E>> nodeList, Node<E> root){
        Node<E> node;

        if (!nodeList.contains(root)) {
            root.num = nodeList.size();
            nodeList.add(root);
            Iterator<Node<E>> it = root.succsOf();
            while (it.hasNext()) {
                node = it.next();
                dfs(nodeList, node);
            }
        }
    }


    private void postOrder(List<Node<E>> visited, List<Node<E>> nodeList, Node<E> root){
        // Got help from http://eli.thegreenplace.net/2015/directed-graph-traversal-orderings-and-applications-to-data-flow-analysis/
        if (!visited.contains(root)) {
            visited.add(root);
            Iterator it = root.succsOf();
            while (it.hasNext()) {
                Node<E> node = (Node<E>) it.next();
                postOrder(visited, nodeList, node);
            }
            root.num = nodeList.size();
            nodeList.add(root);
        }
    }
}
