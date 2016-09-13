package ks222rt_assign2.Exercise_1;

import da1031.AbstractIntCollection;
import da1031.IntList;

/**
 * Created by Kristoffer on 2016-09-13.
 */
public class ArrayIntList extends AbstractIntCollection implements IntList{

    public ArrayIntList(){  }

    /* Add integer n to the end of the list. */
    @Override
    public void add(int n) {
        values[size++] = n;
        if (size == values.length){
            resize();
        }
    }

    /* Inserts integer n at position index. Shifts the element currently at that
	 * position (if any) and any subsequent elements to the right.  */
    @Override
    public void addAt(int n, int index) throws IndexOutOfBoundsException {
        if (checkIndex(index, size)) {
            int temporary = values[index];
            values[index] = n;
            for (int i = index; i < size; i++) {
                int temp = values[i + 1];
                values[i + 1] = temporary;
                temporary = temp;
            }
            size++;
        }else{
            throw new IndexOutOfBoundsException();
        }
    }

    /* Remove integer at position index. */
    @Override
    public void remove(int index) throws IndexOutOfBoundsException {
        if (checkIndex(index, size)) {
            for (int i = index; i < size; i++) {
                values[i] = values[i + 1];
            }
            size--;
        }else{
            throw new IndexOutOfBoundsException();
        }
    }

    /* Get integer at position index. */
    @Override
    public int get(int index) throws IndexOutOfBoundsException {
        if (checkIndex(index, size)) {
            return values[index];
        }else{
            throw new IndexOutOfBoundsException();
        }
    }

    /* Find position of integer n, otherwise return -1 */
    @Override
    public int indexOf(int n) {
        int index = 0;

        for (int i = 0; i < size; i++){
            if (values[i] == n){
                return index;
            }
            index++;
        }
        return -1;
    }
}
