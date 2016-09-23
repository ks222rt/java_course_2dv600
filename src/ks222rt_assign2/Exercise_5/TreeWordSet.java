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
        private BST node = root;

        public bstIterator(){
            while(node.left != null){
                node = node.left;
            }
        }

        @Override
        public boolean hasNext() {
            return node != null;
        }

        @Override
        public Word next() {
            // Set return Bst before looking for node
            BST bst = node;

            // If node has a right child go to it
            if (node.right != null){
                node = node.right;

                // While parent got a left child go to it and then return BST
                while(node.left != null){
                    node = node.left;
                }

                return bst.word;
            }else{
                // It will break out if the parent is null and set node to null and return the last object.
                while(node.parent != null){
                    // If present node is the same as node parents left, than you are at the far most left child in
                    // that part and then you set so the node will be nodes parent which means you are going up one step.
                    if (node.parent.left == node){
                        node = node.parent;
                        return bst.word;
                    }
                    node = node.parent;
                }

                node = null;
                return bst.word;

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
