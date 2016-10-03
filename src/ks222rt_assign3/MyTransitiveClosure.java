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
        // trying to get floyd marshall algorithm working
        // http://stackoverflow.com/questions/33856058/transitive-closure-outofmemory
        // http://www.geeksforgeeks.org/dynamic-programming-set-16-floyd-warshall-algorithm/
        // http://www.sanfoundry.com/java-program-warshall-algorithm/
        // http://www.sanfoundry.com/java-program-find-transitive-closure-graph/
        // https://www.cs.rochester.edu/~nelson/courses/csc_173/graphs/tc.html

        LinkedList<Node<E>> nodeConnection = new LinkedList<>();
        Map<Node<E>, Collection<Node<E>>> map = new HashMap<>();
        List<Node<E>> tempNodeList = new ArrayList<>();

        Iterator<Node<E>> it = dg.iterator();
        while(it.hasNext()){
            tempNodeList.add(it.next());
        }

        int graphLength = dg.nodeCount();
        int dist[][] = new int[graphLength][graphLength];

        for (int i = 0; i < dist.length; i++){
            for (int k = 0; k < dist[i].length; k++){
                if ((tempNodeList.get(i).hasSucc(tempNodeList.get(k))) &&
                        tempNodeList.get(k).hasPred(tempNodeList.get(i)) ||
                        (tempNodeList.get(i) == tempNodeList.get(k))){
                    dist[i][k] = 1;
                }else{
                    dist[i][k] = 0;
                }
            }
        }

        for (int j = 0; j < dist.length; j++){
            nodeConnection.clear();
            for (int n = 0; n < dist[j].length; n++){
                if (dist[j][n] == 1){
                    nodeConnection.add(tempNodeList.get(n));
                }
            }
            map.put(tempNodeList.get(j), nodeConnection);
        }

        return map;
    }
}
