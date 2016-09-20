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
            root = new BST(null, word);
        }
        else{
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
        private BST top = root;
        private BST current = root;
        private BST bottomLeft = null;
        private boolean notEmpty = true;

        @Override
        public boolean hasNext() {
            return notEmpty || top.parent != null;
        }

        @Override
        public Word next() {
            if (current.left != null){
                current = current.left;
                next();
            }else{
                Word temp = current.word;
                current.left = null;
                return current.word;
            }

            if(current.right != null){
                current = current.right;
                next();
            }else{
                return current.word;
            }



            return null;
        }
    }


    private class BST {
        private Word word;
        private BST parent;
        private BST left = null;
        private BST right = null;

        public BST(BST par, Word val){
            parent = par;
            word = val;
        }

        public void add(Word val){
            if (word.compareTo(val) < 0){
                if (left == null){
                    left = new BST(parent, val);
                }else{
                    left.add(val);
                }
            }else if (word.compareTo(val) > 0){
                if (right == null){
                    right = new BST(parent, val);
                }else{
                    right.add(val);
                }
            }
        }

        public boolean contains(Word val){
            if (word.compareTo(val) < 0){
                if (left == null){
                    return false;
                }else{
                    return left.contains(val);
                }
            }else if (word.compareTo(val) > 0){
                if (right == null){
                    return false;
                }else{
                    return right.contains(val);
                }
            }
            return true;
        }

//        public BST remove(Word val){
//            if (word.compareTo(val) < 0){
//                if (left != null){
//                    left = left.remove(val);
//                }
//            }else if (word.compareTo(val) > 0){
//                if (right != null){
//                    right = right.remove(val);
//                }
//            }else{
//                if (left == null){
//                    return right;
//                }else if (right == null){
//                    return left;
//                }else{
//                    if (right.left == null){
//                        word = right.word;
//                        right = right.right;
//                    }else{
//                        // Kommer till denna sen!
//                        word = right.delete_min();
//                    }
//                }
//            }
//        }
//
//        public Word delete_min(){
//            return null;
//        }

    }
}
