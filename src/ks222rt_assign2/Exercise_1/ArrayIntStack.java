package ks222rt_assign2.Exercise_1;

import da1031.AbstractIntCollection;
import da1031.IntStack;

/**
 * Created by Kristoffer on 2016-09-13.
 */
public class ArrayIntStack extends AbstractIntCollection implements IntStack {

    public ArrayIntStack(){ }

    /* Add integer at top of stack. */
    @Override
    public void push(int n) {
        if (!isEmpty()){
            if (size == values.length){
                resize();
            }

            int temporary = values[0];
            for (int i = 0; i < size(); i++) {
                int temp = values[i + 1];
                values[i + 1] = temporary;
                temporary = temp;
            }
        }
        values[0] = n;
        size++;
    }

    /* Returns and removes integer at top of stack  */
    @Override
    public int pop() throws IndexOutOfBoundsException {
        if (!isEmpty()){
            int temp = values[0];
            for (int i = 0; i < size; i++){
                values[i] = values[i + 1];
            }
            size--;
            return temp;
        }else{
            throw new IndexOutOfBoundsException();
        }
    }

    /* Returns without removing integer at top of stack */
    @Override
    public int peek() throws IndexOutOfBoundsException {
        if (!isEmpty()){
            return values[0];
        }else{
            throw new IndexOutOfBoundsException();
        }
    }
}
