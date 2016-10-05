package ks222rt_assign3;

import graphs.DirectedGraph;
import graphs.Node;

import java.util.Collection;

/**
 * Created by Kristoffer on 2016-09-27.
 */
public class MyConnectedComponents<E> implements graphs.ConnectedComponents<E> {

    /**
    * Two nodes a and b are directly connected if their exist an edge (a,b)
    * or an edge (b,a). Two nodes a and k are connected if there exist a sequence
    * of nodes [a,b,c,d, ... j,k] such that [a,b], [b,c], [c,d], [d,e], ..., [j,k]
    * are all directly connected.
    * <p/>
    * Problem: find a partitioning of the graph nodes such that two nodes belongs to the
    * same partitioning if and only if they are connected.
    * </p>
    * The result is a collection of node collections.
    *
    * @author jonasl
    */

    @Override
    public Collection<Collection<Node>> computeComponents(DirectedGraph dg) {
//        http://www.cs.cornell.edu/courses/cs2112/2012sp/lectures/lec24/lec24-12sp.html


        return null;
    }
}
