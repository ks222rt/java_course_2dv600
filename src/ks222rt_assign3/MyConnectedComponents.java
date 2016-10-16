package ks222rt_assign3;

import graphs.DirectedGraph;
import graphs.Node;

import java.util.*;

/**
 * Created by Kristoffer on 2016-09-27.
 */
public class MyConnectedComponents<E> implements graphs.ConnectedComponents<E> {
    private MyDFS dfs = new MyDFS();
    private Set<Object> visited = new HashSet<>();
    private boolean connected;
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
    public Collection<Collection<Node>> computeComponents(DirectedGraph dg){
        Collection<Collection<Node>> components = new LinkedList<>();
        visited.clear();

        // Iterate over every node in the graph
        dg.iterator().forEachRemaining(item -> { // O(n)
            connected = false;  // O(1)
            // Has node been visited yet? if not..
            if(!visited.contains(item))  // O(1)
            {
                // Create a DFS list based on the node and iterate over the nodes
                List order = dfs.dfs(dg, (Node) item);  // O(n + e) ----> N(N+E)
                Collection<Node> comp = new HashSet<>(); // O(1)

                // Loop through the dfs and add every node to a component and mark them as visited
                for (Object node : order){ // O(n)
                    comp.add((Node) node); // O(1)
                    visited.add(node); // O(1)
                }

                // Loop through components array (which in best case is not "n" but "c")
                // compare component from the array with the newly created component
                // Disjoint will be true if they do not have the same node in it
                // false will occur if there is a connection in them
                // add all nodes in comp 2 to comp 1
                components.iterator().forEachRemaining(component -> { // O(n)
                    if (!Collections.disjoint(component, comp)){  // O(n)
                        component.addAll(comp); // O(n)
                        connected = true;  // O(1)
                    }
                });

                // If there wasn´t any connection add the newly created component to the list
                if(!connected) // O(1)
                {
                    components.add(comp); // O(1)
                }
            }
        });

        // O(n(ne + n + n(n(n))))
        // O(n(ne + n + n^3))
        // O(n^2 + ne + n^2 + n^3)
        // O(2n^2 + ne + n^4)
        // O(n^2 + ne + n^4)

        return components;
    }

}
