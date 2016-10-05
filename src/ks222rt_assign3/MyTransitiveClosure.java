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

        for (E item : dg.allItems()){
            Node<E> node = dg.getNodeFor(item);
            List l = dfs.dfs(dg, node);
            map.put(node, l);
        }

        return map;
    }

}
