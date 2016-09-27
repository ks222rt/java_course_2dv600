package ks222rt_assign3;

import graphs.Node;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * Created by Kristoffer on 2016-09-27.
 */
public class MyNode<E> extends graphs.Node<E>{
    private Set<Node<E>> successors = new HashSet<>();
    private Set<Node<E>> predecessors = new HashSet<>();


    /**
     * Constructs a new node using <tt>item</tt> as key.
     *
     * @param item
     */
    protected MyNode(E item) {
        super(item);
    }

    /**
     * Returns <tt>true</tt> if <tt>this</tt> node has <tt>node</tt> as successor,
     * otherwise <tt>false</tt>.
     * @param a possible successor node
     * @return boolean
     */
    @Override
    public boolean hasSucc(Node node) {
        return successors.contains(node);
    }

    /**
     * Returns the number of successors (i.e. outgoing edges)
     * of this node.
     * @return node out-degree
     */
    @Override
    public int outDegree() {
        return this.successors.size();
    }

    /**
     * Returns an iterator over all successor nodes.
     * @return successor node iterator
     */
    @Override
    public Iterator<Node<E>> succsOf() {
        return null;
    }

    /**
     * Returns <tt>true</tt> if <tt>this</tt> node has <tt>node</tt> as predecessor,
     * otherwise <tt>false</tt>.
     * @param a possible predecessor node
     * @return boolean
     */
    @Override
    public boolean hasPred(Node<E> node) {
        return predecessors.contains(node);
    }

    /**
     * Returns the number of predecessors  (i.e. incoming edges)
     * of this node.
     * @return node out-degree
     */
    @Override
    public int inDegree() {
        return this.predecessors.size();
    }

    /**
     * Returns an iterator over all predecessor nodes.
     * @return predecessor node iterator
     */
    @Override
    public Iterator<Node<E>> predsOf() {
        return null;
    }


    /**
     * Adds node <tt>succ</tt> as a successor to <tt>this</tt> node.
     */
    @Override
    protected void addSucc(Node<E> succ) {
        successors.add(succ);
    }

    /**
     * Removes node <tt>succ</tt> as a successor to <tt>this</tt> node.
     */
    @Override
    protected void removeSucc(Node<E> succ) {

    }

    /**
     * Adds node <tt>pred</tt> as a predecessor to <tt>this</tt> node.
     */
    @Override
    protected void addPred(Node<E> pred) {
        predecessors.add(pred);
    }

    /**
     * Removes node <tt>pred</tt> as a predecessor to <tt>this</tt> node.
     */
    @Override
    protected void removePred(Node<E> pred) {

    }

    /**
     * Disconnects this node from all adjacent nodes. That is, removes all successor,
     * and predecessor, nodes to <tt>this</tt> node.
     */
    @Override
    protected void disconnect() {

    }
}
