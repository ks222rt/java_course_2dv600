package ks222rt_assign3;

import graphs.DirectedGraph;
import graphs.Node;

import java.util.*;

/**
 * Created by Kristoffer on 2016-09-27.
 */
public class MyConnectedComponents<E> implements graphs.ConnectedComponents<E> {
    MyDFS dfs = new MyDFS();
    Set<Object> visited = new HashSet<>();
    ArrayDeque<Object> stack = new ArrayDeque<>();
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
        visited.clear();
        stack.clear();

        Collection<Collection<Node>> components = new ArrayList<>();

        List order = dfs.dfs(dg);
        List reversed = dfs.postOrder(dg);

//          This approach crash with 100 in the benchmark but is so much faster than the version below
//        for (int i  = 0; i < order.size(); i++){
//            Object node = order.get(i);
//            if (!visited.contains(node)){
//                List<Node> comp = new ArrayList<>();
//                int k = reversed.indexOf(node);
//                dfs((Node) reversed.get(k), visited, comp);
//                components.add(comp);
//            }
//        }
        Iterator it = order.iterator();

        while(it.hasNext()){
            Object node = it.next();
            if (!visited.contains(node)){
                List<Node> comp = new ArrayList<>();
                int k = reversed.indexOf(node);
                stack.add(reversed.get(k));

                while(!stack.isEmpty()){
                    Node n = (Node) stack.removeFirst();
                    if (!visited.contains(n)) {
                        visited.add(n);
                        comp.add(n);

                        if (n.outDegree() != 0) {
                            Iterator<Node<E>> successors = n.succsOf();
                            while (successors.hasNext()) {
                                Node child = successors.next();
                                if (!stack.contains(child) || !visited.contains(child)) {
                                    stack.addFirst(child);
                                }
                            }
                        } else if (n.inDegree() != 0) {
                            Iterator<Node<E>> predecessors = n.predsOf();
                            while (predecessors.hasNext()) {
                                Node child = (Node) predecessors.next();
                                if (!visited.contains(child)) {
                                    if (!stack.contains(child) || !visited.contains(child)) {
                                        stack.addFirst(child);
                                    }
                                }
                            }
                        }
                    }
                }

                components.add(comp);
            }
        }

        return components;
    }

    // Can be used but with over 100 in the benchmark this crash due to stackoverflow
    private void dfs(Node n, List<Object> visited, List<Node> order){
        visited.add(n);
        if (n.outDegree() != 0) {
            Iterator<Node<E>> it = n.succsOf();
            while (it.hasNext()) {
                Node child = it.next();
                if (!visited.contains(child)) {
                    dfs(child, visited, order);
                }
            }
        }else if (n.inDegree() != 0){
            Iterator<Node<E>> it = n.predsOf();
            while (it.hasNext()) {
                Node child = (Node) it.next();
                if (!visited.contains(child)) {
                    dfs(child, visited, order);
                }
            }
        }

        order.add(n);
    }
}
