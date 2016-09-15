package ks222rt_assign2.Exercise_3;

import ks222rt_assign2.Exercise_1.ArrayIntList;
import ks222rt_assign2.Exercise_1.ArrayIntStack;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * Created by Kristoffer on 2016-09-15.
 */
public class ArrayIntListTest {
    private static int count = 0;

    @Before
    public void setUp() throws Exception {
        System.out.println("Running test method: " + (++count));
    }

    @After
    public void tearDown() throws Exception {
        System.out.println("-- done with test " + count);
    }

    @Test
    public void add() throws Exception {
        ArrayIntList intList = build(5);
        assertEquals(5, intList.size());
        intList.add(1);
        assertEquals(6, intList.size());

        ArrayIntList intList1 = build(100);
        assertEquals(100, intList1.size());

        ArrayIntList intList2 = build(1000000);
        assertEquals(1000000, intList2.size());
        assertNotEquals(1, intList2.size());

    }

    @Test
    public void addAt() throws Exception {
        try {
            ArrayIntList intList = build(5);
            intList.addAt(1337, 7);
            fail("Expected an IndexOutOfBoundsException to be thrown");
        } catch (IndexOutOfBoundsException anIndexOutOfBoundsException) {
            assertThat(anIndexOutOfBoundsException.getMessage(), is("Index is out of the arrays size"));
        }

        ArrayIntList intList = build(1000000);
        intList.addAt(1000001, 50000);
        assertEquals(1000001, intList.get(50000));

        ArrayIntList intList1 = build(5);
        intList1.addAt(1337, 3);
        assertEquals(1337, intList1.get(3));

        ArrayIntList intList2 = build(5);
        intList2.addAt(1, 3);
        assertEquals(6, intList2.size());

    }

    @Test
    public void remove() throws Exception {
        try {
            ArrayIntList intList = build(5);
            intList.remove(7);
            fail("Expected an IndexOutOfBoundsException to be thrown");
        }catch (IndexOutOfBoundsException anIndexOutOfBoundsException){
            assertThat(anIndexOutOfBoundsException.getMessage(), is("Index is out of the arrays size"));
        }

        ArrayIntList intList = build(5);
        intList.remove(3);
        assertEquals(4, intList.size());

        ArrayIntList intList1 = build(150);
        for (int i = 0; i < 150; i++){
            intList1.remove(0);
        }
        assertEquals(0, intList1.size());

        int test = 7;
        ArrayIntList intList2 = build(5);
        intList2.addAt(test, 1);
        intList2.remove(1);
        assertNotEquals(test, intList2.get(1));

    }

    @Test
    public void get() throws Exception {
        try {
            ArrayIntList intList = build(5);
            intList.get(10000);
            fail("Expected an IndexOutOfBounds exception");
        }catch(IndexOutOfBoundsException anIndexOutOfBoundsException){
            assertThat(anIndexOutOfBoundsException.getMessage(), is("Index is out of the arrays size"));
        }

        try {
            ArrayIntList list = build(1);
            list.get(-12);
            fail("Expected an IndexOutOfBounds exception");
        }catch(IndexOutOfBoundsException anIndexOutOfBoundsException){
            assertThat(anIndexOutOfBoundsException.getMessage(), is("Index is out of the arrays size"));
        }

        ArrayIntList intList = build(5);
        intList.addAt(1337, 1);
        assertEquals(1337, intList.get(1));

        ArrayIntList intList1 = build(100000);
        intList1.add(1);
        assertEquals(1, intList1.get(100000));

        ArrayIntList intList2 = build(100000000);
        for (int i = 0; i < intList2.size(); i++){
            assertEquals(i, intList2.get(i));
        }
        for (int i = 0; i < intList2.size(); i++){
            assertNotEquals(i + 1, intList2.get(i));
        }
    }

    @Test
    public void indexOf() throws Exception {
        ArrayIntList intList = build(10);
        assertEquals(-1, intList.indexOf(1337));
        assertEquals(0, intList.indexOf(0));

        intList.add(1337);
        assertNotEquals(1, intList.indexOf(1337));
        assertNotEquals(-1, intList.indexOf(9));
    }

    private ArrayIntList build(int size){
        ArrayIntList intList = new ArrayIntList();
        for (int i = 0; i < size; i++){
            intList.add(i);
        }
        return intList;
    }

}