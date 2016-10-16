package ks222rt_assign3;

import graphs.DirectedGraph;
import graphs.Node;

import java.util.*;

/**
 * Created by Kristoffer on 2016-09-27.
 */
public class MyConnectedComponents<E> implements graphs.ConnectedComponents<E> {
    private MyDFS dfs = new MyDFS();
    private Set<Object> visited = new LinkedHashSet<>();
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
                Iterator orderIterator = order.iterator();  // O(1)

                while(orderIterator.hasNext()){  // O(n)  ---- > O(n(n+e) + n(n))
                    Object node = orderIterator.next();  // O(1)

                    // If node has been visited before. Either the same which is the root of the dfs list or..
                    // from another collection of connected components
                    if (visited.contains(node)){ // O(1)

                        // Iterate over all collections in the components collection
                        components.iterator().forEachRemaining(component -> { // O(n)  ---> O(n(n+e) + n(n(c)))

                            // if a node already exists in a component there is a connection
                            // Add the dfs list to the component and make them as visited.
                            // and set connected to true so the list wont be added again.
                            if(component.contains(node)){ // O(1)
                                component.addAll(order); // O(1)
                                visited.addAll(order); // O(1) --->  N(N+E) + N(N(C))  --> N^2 + NE + N*C
                                connected = true; // O(1)
                            }
                        });
                    }
                }

                // If there wasn´t any existing connection with the list, create a new collection and add it to the
                // Components list and mark them as visited.
                if(!connected) // O(1)
                {
                    Collection<Node> comp = new LinkedHashSet<>(); // O(1)
                    visited.addAll(order); // O(1)
                    comp.addAll(order); // O(1)
                    components.add(comp); // O(1)
                }

            }
        });

        // O(n(ne + n(c)))
        // O(n(ne + n*c))
        // O(n^2 + ne + n^2*c)
        // O(2n^2 + ne + n*c)
        // O(n^2 + ne + n*c)

        return components;
    }

}
