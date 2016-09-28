package ks222rt_assign3;

import graphs.DirectedGraph;

/**
 * Created by Kristoffer on 2016-09-27.
 */
public class MyGML<E> extends graphs.GML<E> {
    public MyGML(DirectedGraph<E> dg) {
        super(dg);
    }

    @Override
    public String toGML() {
        return graph.toString();
    }
}
