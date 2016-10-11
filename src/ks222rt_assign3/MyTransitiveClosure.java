package ks222rt_assign3;

import graphs.DirectedGraph;
import graphs.Node;

import java.util.*;

/**
 * Created by Kristoffer on 2016-09-27.
 */
public class MyTransitiveClosure<E> implements graphs.TransitiveClosure<E> {
    /**
     * Computes the transitive closure for the graph.
     *
     */
    @Override
    public Map<Node<E>, Collection<Node<E>>> computeClosure(DirectedGraph<E> dg) {
        Map<Node<E>, Collection<Node<E>>> map = new HashMap<>();
        MyDFS dfs = new MyDFS();

        // Iterate through every node and get a DFS list for the specific node
        // Add it to the map with the node as key
        dg.iterator().forEachRemaining(item -> { // O(n)
            Collection<Node<E>> list = dfs.dfs(dg, item); // O(n + e)
            map.put(item, list);
        });

        return map;  // O(n(n + e)) = O(n^2(n + e))
    }

}
