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
        return new nodeIterator();
    }

    private class nodeIterator implements Iterator<Node<E>>{
        private int count = 0;

        @Override
        public boolean hasNext() {
            return count < itemToNode.size();
        }

        @Override
        public Node<E> next() {
            Set<E> set = itemToNode.keySet();
            Object getNode = set.toArray()[count];
            MyNode<E> node = itemToNode.get(getNode);
            count++;
            return node;
        }
    }

    /**
     * Returns an iterator over all nodes with no in-edges.
     * @return heads iterator
     */
    @Override
    public Iterator<Node<E>> heads() {
        return new headsIterator();
    }

    private class headsIterator implements Iterator<Node<E>>{
        private int count = 0;

        @Override
        public boolean hasNext() {
            return count < heads.size();
        }

        @Override
        public Node<E> next() {
            Node<E> node = (Node<E>) heads.toArray()[count];
            count++;
            return node;
        }
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
        return new tailsIterator();
    }

    private class tailsIterator implements Iterator<Node<E>>{
        private int count = 0;

        @Override
        public boolean hasNext() {
            return count < tails.size();
        }

        @Override
        public Node<E> next() {
            Node<E> node = (Node<E>) tails.toArray()[count];
            count++;
            return node;
        }
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
        List<E> nodelist = new ArrayList<>();
        Iterator it = iterator();
        while(it.hasNext()){
            Node<E> temp = (Node<E>) it.next();
            nodelist.add(temp.item());
        }
        return nodelist;
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
        if (item == null || !itemToNode.containsKey(item)){
            throw new RuntimeException("Received null as input");
        }
        MyNode<E> node = itemToNode.get(item);

        if (node.isHead()){
            heads.remove(node);
        }else if(node.isTail()){
            tails.remove(node);
        }

        node.disconnect();
        itemToNode.remove(item);
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
        if (from == null || to == null){
            throw new RuntimeException("Received null as input");
        }

        if (itemToNode.containsKey(from) && itemToNode.containsKey(to)){
            MyNode<E> src = (MyNode<E>) getNodeFor(from);
            MyNode<E> tgt = (MyNode<E>) getNodeFor(to);

            if (src.hasSucc(tgt) && tgt.hasPred(src)){
                src.removeSucc(tgt);
                tgt.removePred(src);

                if (src.isTail()){
                    if (!tails.contains(src)){
                        tails.add(src);
                    }
                }

                if (tgt.isHead()){
                    if (!heads.contains(tgt)){
                        heads.add(tgt);
                    }
                }

                return true;
            }

            return false;
        }

        return false;
    }

    /**
     * A textual representation of the graph content (nodes and edges) constructed
     * by applying <tt>toString()</tt> on the nodes.
     *
     */
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        Map<Node<E>, Integer> map = new HashMap<>();

        sb.append("graph [\n");
        Iterator it = iterator();
        int count = 0;
        while(it.hasNext()){
            MyNode<E> node = (MyNode<E>) it.next();
            map.put(node, count);
            sb.append("\n\tnode [\n");
            sb.append("\t\tid " + count);
            sb.append("\n\t\tlabel " + "\"" + node.item() + "\"");
            sb.append("\n\t]");
            count++;
        }

        Iterator newIT = iterator();

        while(newIT.hasNext()){
            MyNode<E> node = (MyNode<E>) newIT.next();
            Iterator nit = node.succsOf();
            while(nit.hasNext()){
                sb.append("\n\tedge [");
                MyNode<E> n = (MyNode<E>) nit.next();
                sb.append("\n\t\tsource " + map.get(node));
                sb.append("\n\t\ttarget " + map.get(n));
                //sb.append("\n\t\tlabel \"Edge from node " + node + " to node " + n + "\"");
                sb.append("\n\t]");
            }
        }

        sb.append("\n]");
        return sb.toString();
    }
}
