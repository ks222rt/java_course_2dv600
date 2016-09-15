package ks222rt_assign2.Exercise_4;

import java.util.Iterator;

/**
 * Created by Kristoffer on 2016-09-15.
 */
public class Queue<E> implements QueueInterface<E> {
    private int size = 0;
    private Node head = null;
    private Node tail = null;

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void enqueue(E element) {
        if (head == null){
            head = new Node(element);
            tail = head;
        }else{
            tail.next = new Node(element);
            tail = tail.next;
        }
        size++;
    }

    @Override
    public E dequeue() {
        if (isEmpty()){
            throw new IndexOutOfBoundsException("Error: Queue is empty!");
        }else {
            Node returnNode = head;
            head = head.next;

            if (head == null) {
                tail = null;
            }

            size--;
            return returnNode.value;
        }
    }

    @Override
    public E first() {
        if (head != null && size > 0){
            return head.value;
        }else{
            throw new IndexOutOfBoundsException("Error: Queue is empty!");
        }
    }

    @Override
    public E last() {
        if (head != null && size > 0){
            return tail.value;
        }else{
            throw new IndexOutOfBoundsException("Error: Queue is empty!");
        }
    }

    @Override
    public Iterator iterator() {
        return new ListIterator();
    }

    private class ListIterator implements Iterator<E>{
        private Node node = head;

        // true if the iteration has more elements
        @Override
        public boolean hasNext() {
            return node != null;
        }

        // Returns the next Object in the iteration
        @Override
        public E next() {
            E val = node.value;
            node = node.next;
            return val;
        }
    }

    private class Node {
        E value;
        Node next = null;

        public Node(E e){
            value = e;
        }
    }
}
