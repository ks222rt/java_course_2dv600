package ks222rt_assign1.Exercise_14;

import java.util.Iterator;

/**
 * Created by Kristoffer on 2016-09-06.
 */
public class Queue implements QueueInterface {
    private int size = 0;
    private Node head = null;
    private Node tail = null;

    public Queue() {    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    // add element at end of queue
    @Override
    public void enqueue(Object element) {
        if (head == null){
            head = new Node(element);
            tail = head;
        }else{
            tail.next = new Node(element);
            tail = tail.next;
        }
        size++;
    }

    // return and remove first element.
    @Override
    public Object dequeue() throws IndexOutOfBoundsException {
        Node returnNode;
        if (head != null && size > 0){
            if (head.next == null){
                returnNode = head;
                head = null;
                tail = null;
            }else{
                returnNode = head;
                head = head.next;
                Node before = head;
                for (int i = 0; i < size; i++){
                    if (before != null){
                        before = before.next;
                    }
                }
            }

            size--;
            return returnNode.value;
        }else{
            throw new IndexOutOfBoundsException("Error: list is empty!");
        }
    }

    // return (without removing) first element
    @Override
    public Object first() throws IndexOutOfBoundsException {
        if (head != null && size > 0){
            return head.value;
        }else{
            throw new IndexOutOfBoundsException("Error: List is empty!");
        }
    }

    // return (without removing) last element
    @Override
    public Object last() throws IndexOutOfBoundsException {
        if (head != null &&  size > 0){
            return tail.value;
        }else{
            throw new IndexOutOfBoundsException("Error: List is empty!");
        }
    }

    // return "true" if this queue contains the specified element
    @Override
    public boolean contains(Object o) {
        Node before  = head;
        for (int i = 0; i < size; i++){
            if (before.value == o){
                return true;
            }
            before = before.next;
        }
        return false;
    }

    @Override
    public Iterator iterator() {
        return new ListIterator();
    }

    private class ListIterator implements Iterator<Object>{
        private Node node = head;

        // true if the iteration has more elements
        @Override
        public boolean hasNext() {
            return node != null;
        }

        // Returns the next Object in the iteration
        @Override
        public Object next() {
            Object val = node.value;
            node = node.next;
            return val;
        }
    }

    private class Node  {
        Object value;
        Node next = null;

        public Node(Object v){
            value = v;
        }
    }
}
