package ks222rt_assign3;

import graphs.Node;

import java.util.*;

/**
 * Created by Kristoffer on 2016-09-27.
 */
public class MyGraph<E> implements graphs.DirectedGraph<E>{
    private Map<E, MyNode<E>> itemToNode = new HashMap<>();
    private Set<Node<E>> heads = new HashSet<>();
    private Set<Node<E>> tails = new HashSet<>();

    public MyGraph(){

    }

    /**
     * Adds a node representing <tt>item</tt> if not added before.
     * Exception is thrown if <tt>item</tt> is null. It returns the
     * node representing <tt>item</tt> (new or previously constructed).
     * @param item,
     * @return Node representing <tt>item</tt>
     */
    @Override
    public Node<E> addNodeFor(E item) {
        if (item != null){
            if (!itemToNode.containsKey(item)){
                MyNode<E> node = new MyNode<>(item);
                tails.add(node);
                heads.add(node);
                itemToNode.put(item, node);
                return node;
            }else{
                return getNodeFor(item);
            }
        }else{
            throw new IllegalArgumentException("Item is null");
        }
    }

    /**
     * Returns the node representing <tt>item</tt>.
     * Exception is thrown if <tt>item</tt> is null or if no
     * node representing <tt>item</tt> is found.
     * @param item
     * @return Node representing <tt>item</tt>
     */
    @Override
    public Node<E> getNodeFor(E item) {
        if (item == null || !itemToNode.containsKey(item))
        {
            throw new IllegalArgumentException("Item is null or wasn´t found");
        }

        return itemToNode.get(item);
    }

    /**
     * Adds an edge between the nodes represented by <tt>from</tt>
     * and <tt>to</tt>  if not added before. The nodes representing
     * <tt>from</tt> and <tt>to</tt> are added if not added before.
     * Exception is thrown if <tt>from</tt> or <tt>to</tt> is null.
     * It returns <tt>true</tt> if edge not added before, otherwise <tt>false</tt>.
     * @param from, source node
     * @param to, target node
     * @return <tt>true</tt> if edge not added before, otherwise <tt>false</tt>.
     */
    @Override
    public boolean addEdgeFor(E from, E to) {
        if (from == null || to == null){
            throw new RuntimeException("Received null as input");
        }

        MyNode<E> src = (MyNode<E>) addNodeFor(from);
        MyNode<E> tgt = (MyNode<E>) addNodeFor(to);

        if (src.hasSucc(tgt)){
            return false;
        }else{
            src.addSucc(tgt);
            tgt.addPred(src);

            tails.remove(src);
            heads.remove(tgt);
        }

        return true;
    }

    /**
     * Returns <tt>true</tt> if the node representing <tt>item</tt> is
     * contained in the graph, otherwise <tt>false</tt>.
     * Exception is thrown if <tt>item</tt> is null.
     * @param item, node to be checked.
     */
    @Override
    public boolean containsNodeFor(E item) {
        if (item == null){
            throw new RuntimeException("Received null as input");
        }
        return itemToNode.containsKey(item);
    }

    /**
     * Returns the number of nodes in the graph.
     * @return number of nodes
     */
    @Override
    public int nodeCount() {
        return itemToNode.size();
    }

    /**
     * Returns an iterator over all nodes in the graph.
     * @return graph nodes iterator
     */
    @Override
    public Iterator<Node<E>> iterator() {
        return null;
    }

    /**
     * Returns an iterator over all nodes with no in-edges.
     * @return heads iterator
     */
    @Override
    public Iterator<Node<E>> heads() {
        return null;
    }

    /**
     * The number of nodes with no in-edges.
     * @return number of head nodes.
     */
    @Override
    public int headCount() {
        return heads.size();
    }

    /**
     * Returns an iterator over all nodes with no out-edges.
     * @return tails iterator
     */
    @Override
    public Iterator<Node<E>> tails() {
        return null;
    }

    /**
     * The number of nodes with no out-edges.
     * @return number of head nodes.
     */
    @Override
    public int tailCount() {
        return tails.size();
    }

    /**
     * Returns a list over all node items currently used in the graph.
     * @return list of items
     */
    @Override
    public List<E> allItems() {
        return null;
    }

    /**
     * Returns the number of graph edges.
     * @return edge count
     */
    @Override
    public int edgeCount() {
        int count = 0;
        for (Node n : itemToNode.values()){
            count += n.outDegree();
        }
        return count;
    }

    /**
     * Removes the node represented by <tt>item</item> and
     * all its connecting edges. Exception is thrown if <tt>item</tt>
     * is null  or if no node representing <tt>item</tt> is found.
     *
     * @param item, node to be removed.
     */
    @Override
    public void removeNodeFor(E item) {

    }

    /**
     * Returns <tt>true</tt> if an edge between the nodes represented
     * by <tt>from</tt> and <tt>to</tt> is added to the graph.
     * Exception is thrown if <tt>from</tt> or <tt>to</tt> is null.
     * @param from, source node item
     * @param to, target node item
     * @return <tt>true</tt> if edge in graph, otherwise <tt>false</tt>.
     */
    @Override
    public boolean containsEdgeFor(E from, E to) {
        if (from == null || to == null){
            throw new RuntimeException("Received null as input");
        }
        if (itemToNode.containsKey(from) && itemToNode.containsKey(to)) {
            return itemToNode.get(from).hasSucc(itemToNode.get(to));
        }
        return false;
    }

    /**
     * Removes the edge between the nodes represented
     * by <tt>from</tt> and <tt>to</tt> if it exist.
     * Returns <tt>true</tt> if an edge between the nodes represented
     * by <tt>from</tt> and <tt>to</tt>  is found and successfully removed.
     * Exception is thrown if <tt>from</tt> or <tt>to</tt> is null.
     * @param from, source node item
     * @param to, target node item
     * @return <tt>true</tt> if edge in graph and successfully removed, otherwise <tt>false</tt>.
     */
    @Override
    public boolean removeEdgeFor(E from, E to) {
        return false;
    }

    /**
     * A textual representation of the graph content (nodes and edges) constructed
     * by applying <tt>toString()</tt> on the nodes.
     *
     */
    @Override
    public String toString(){


        return "";
    }
}
