package ks222rt_assign2.Exercise_5;

import java.util.Iterator;

/**
 * Created by Kristoffer on 2016-09-20.
 */
public class HashWordSet implements WordSet{
    private int size;
    private Node[] buckets = new Node[365];

    @Override
    public void add(Word word) {
        int pos = getBucketNumber(word);
        Node node = buckets[pos];
        while(node != null){
            if (contains(word)){
                return;
            }else{
                node = node.next;
            }
        }

        node = new Node(word);
        node.next = buckets[pos];
        buckets[pos] = node;
        size++;
        if (size == buckets.length){
            rehash();
        }
    }

    private void rehash() {
        Node[] temp = buckets;
        buckets = new Node[2 * temp.length];
        size = 0;
        for (Node n: temp){
            if (n == null){
                continue;
            }

            while(n != null){
                add(n.value);
                n = n.next;
            }
        }
    }

    private int getBucketNumber(Word word) {
        int hashCode = word.hashCode();
        if (hashCode < 0){
            hashCode = -hashCode;
        }
        return hashCode % buckets.length;
    }

    @Override
    public boolean contains(Word word) {
        int pos = getBucketNumber(word);
        Node node = buckets[pos];

        while(node != null){
            if (node.value.equals(word) && node.value.hashCode() == word.hashCode()){
                return true;
            }else{
                node = node.next;
            }
        }

        return false;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Iterator iterator() {
        return new hashIterator();
    }

    private class hashIterator implements Iterator<Word>{
        private Node next;
        private Word val;
        private int pos = 0;

        public hashIterator(){
            for (Node node : buckets){
                if (node != null){
                    next = node;
                    break;
                }
            }
        }

        @Override
        public boolean hasNext() {
            return next != null;
        }

        @Override
        public Word next() {
            Node returnNode = next;

            if (next.next != null){
                next = next.next;
            }else{
                for (int i = getBucketNumber(next.value) + 1; i < buckets.length; i++){
                    if (buckets[i] != null){
                        next = buckets[i];
                        break;
                    }
                    if (i < buckets.length){
                        next = null;
                    }
                }
            }

            return returnNode.value;
        }
    }

    private class Node{
        private Word value;
        private Node next = null;

        public Node (Word val){
            value = val;
        }

    }
}
