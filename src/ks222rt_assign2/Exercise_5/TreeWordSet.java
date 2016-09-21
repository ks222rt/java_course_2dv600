package ks222rt_assign2.Exercise_5;

import java.util.Iterator;

/**
 * Created by Kristoffer on 2016-09-20.
 */
public class TreeWordSet implements WordSet {
    private BST root = null;
    private int size = 0;

    // Add word if not already added
    @Override
    public void add(Word word) {
        if (root == null){
            root = new BST(word);
        }
        else{
            if(root.contains(word)){
                return;
            }
            root.add(word);
        }
        size++;
    }

    // Return true if word contained
    @Override
    public boolean contains(Word word) {
        return root.contains(word);
    }

    // Return current set size
    @Override
    public int size() {
        return size;
    }

    @Override
    public Iterator iterator() {
        return new bstIterator();
    }

    private class bstIterator implements Iterator<Word>{
        private BST next = root;

        public bstIterator(){
            while(next.left != null){
                next = next.left;
            }
        }

        @Override
        public boolean hasNext() {
            return next != null;
        }

        @Override
        public Word next() {
            // Solution from http://stackoverflow.com/questions/12850889/in-order-iterator-for-binary-tree
            // Cannot take credit for it


            // Set return Bst before looking for next
            BST bst = next;

            // If next has a right child go to it
            if (next.right != null){
                next = next.right;

                // While parent got a left child go to it and then return BST
                while(next.left != null){
                    next = next.left;
                }
                return bst.word;
            }else{
                // While true aint good, but it has 2 break points so it wont be an infinity loop.
                while(true){
                    // If next doesn´t have a parent then everything is done
                    if (next.parent == null){
                        next = null;
                        return bst.word;
                    }
                    // If present next is the same as next parents left, than you are at the far most left child in
                    // that part and then you say next will be nexts parent which means you are going up one step.
                    if (next.parent.left == next){
                        next = next.parent;
                        return bst.word;
                    }
                    next = next.parent;
                }
            }
        }
    }


    private class BST {
        private Word word;
        private BST parent;
        private BST left = null;
        private BST right = null;

        public BST(Word val){
            word = val;
        }

        public BST(BST par, Word val){
            parent = par;
            word = val;
        }

        public void add(Word val){
            if (word.compareTo(val) > 0){
                if (left == null){
                    left = new BST(this, val);
                }else{
                    left.add(val);
                }
            }else if (word.compareTo(val) < 0){
                if (right == null){
                    right = new BST(this, val);
                }else{
                    right.add(val);
                }
            }
        }

        public boolean contains(Word val){
            if (word.compareTo(val) > 0){
                if (left == null){
                    return false;
                }else{
                    return left.contains(val);
                }
            }else if (word.compareTo(val) < 0){
                if (right == null){
                    return false;
                }else{
                    return right.contains(val);
                }
            }
            return true;
        }
    }
}
