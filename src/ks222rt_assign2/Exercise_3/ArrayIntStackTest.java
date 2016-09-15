package ks222rt_assign2.Exercise_3;

import ks222rt_assign2.Exercise_1.ArrayIntStack;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * Created by Kristoffer on 2016-09-15.
 */
public class ArrayIntStackTest {
    private static int count = 0;

    @Before
    public void setUp() throws Exception {
        System.out.println("Running test method: " + ++count);
    }

    @After
    public void tearDown() throws Exception {
        System.out.println("--- Done with test: " + count);
    }

    @Test
    public void push() throws Exception {
        ArrayIntStack intStack = build(5);
        assertEquals(5, intStack.size());
        intStack.push(5);
        assertEquals(6, intStack.size());
        assertEquals(5, intStack.peek());

        ArrayIntStack intStack1 = build(100000);
        assertEquals(100000, intStack1.size());
        intStack1.push(1);
        assertEquals(1, intStack1.peek());
    }

    @Test
    public void pop() throws Exception {
        try {
            ArrayIntStack intStack = build(0);
            intStack.pop();
            fail("Expected indexOutOfBoundsException to be thrown");
        }catch(IndexOutOfBoundsException e){
            assertThat(e.getMessage(), is("Array is empty, cant remove object"));
        }

        ArrayIntStack intStack = build(5);
        intStack.push(1);
        assertEquals(1, intStack.pop());

        ArrayIntStack intStack1 = build(100000);
        intStack1.push(1);
        intStack1.push(2);
        intStack1.pop();
        assertEquals(1, intStack1.peek());

        try{
            ArrayIntStack stack = build(5);
            for (int i = 0; i < 5; i++){
                stack.pop();
            }
            stack.pop();
            fail("Expected indexOutOfBoundsException to be thrown");
        }catch (IndexOutOfBoundsException e){
            assertThat(e.getMessage(), is("Array is empty, cant remove object"));
        }

    }

    @Test
    public void peek() throws Exception {
        try {
            ArrayIntStack intStack = build(0);
            intStack.peek();
            fail("Expected indexOutOfBoundsException to be thrown");
        }catch (IndexOutOfBoundsException e){
            assertThat(e.getMessage(), is("Array is empty, cant remove object"));
        }

        ArrayIntStack intStack = build(5);
        intStack.push(1);
        assertEquals(1, intStack.peek());

        ArrayIntStack intStack1 = build(10000);
        intStack1.pop();
        intStack1.push(1);
        assertEquals(1, intStack1.peek());
        assertNotEquals(2, intStack1.peek());
    }

    private ArrayIntStack build(int size){
        ArrayIntStack intStack = new ArrayIntStack();
        for (int i = 0; i < size; i++){
            intStack.push(i);
        }
        return intStack;
    }

}