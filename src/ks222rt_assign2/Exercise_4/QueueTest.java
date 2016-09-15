package ks222rt_assign2.Exercise_4;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.omg.PortableInterceptor.Interceptor;

import java.util.Iterator;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * Created by Kristoffer on 2016-09-15.
 */
public class QueueTest {
    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void size() throws Exception {
        // Trying a queue with integers
        Queue q = buildInt(5);
        assertEquals(5, q.size());

        Queue q1 = buildInt(100000);
        assertEquals(100000, q1.size());

        assertNotEquals(q.size(), q1.size());

        // Trying a queue with strings
        Queue q2 = buildString(5);
        assertEquals(5, q2.size());

        Queue q3 = buildString(100000);
        assertEquals(100000, q3.size());

        assertNotEquals(q.size(), q1.size());
    }

    @Test
    public void isEmpty() throws Exception {
        // Trying a queue with integers
        Queue q = buildInt(0);
        assertTrue(q.isEmpty());

        Queue q1 = buildInt(5);
        assertFalse(q1.isEmpty());

        Queue q2 = buildInt(100000);
        assertTrue(!q2.isEmpty());

        // Trying a queue with integers
        Queue q3 = buildInt(0);
        assertTrue(q3.isEmpty());

        Queue q4 = buildInt(5);
        assertFalse(q4.isEmpty());

        Queue q5 = buildInt(100000);
        assertTrue(!q5.isEmpty());
    }

    @Test
    public void enqueue() throws Exception {
        // Adding booleans to the queue
        Queue q = new Queue();
        for (int i = 0; i < 5; i++){
            q.enqueue((i % 2 == 0));
        }
        assertFalse(q.isEmpty());

        // Adding a huge amount of integers
        Queue q1 = new Queue();
        for (int i = 0; i < 100000; i++){
            q1.enqueue(i);
        }
        assertFalse(q.isEmpty());

    }

    @Test
    public void dequeue() throws Exception {
        // Dequeue an empty queue
        try {
            Queue q = buildInt(0);
            q.dequeue();
            fail("Expected an IndexOutOfBounds to be thrown");
        }catch(IndexOutOfBoundsException e){
            assertThat(e.getMessage(), is("Error: Queue is empty!"));
        }

        // Dequeue the first object
        Queue q = buildInt(10);
        assertEquals(q.first(), q.dequeue());

        // Dequeue a huge amount
        Queue q1 = buildInt(1000000);
        for (int i = 0; i < 1000000; i++){
            q1.dequeue();
        }
        assertTrue(q1.isEmpty());
    }

    @Test
    public void first() throws Exception {
        // Get first object in an empty queue
        try{
            Queue q = buildInt(0);
            q.first();
            fail("Expected an IndexOutOfBounds to be thrown");
        }catch(IndexOutOfBoundsException e){
            assertThat(e.getMessage(), is("Error: Queue is empty!"));
        }

        // Get first object in a queue
        Queue q = buildInt(5);
        assertEquals(q.first(), q.dequeue());

        // Get first object after dequeued everything else
        Queue q1 = buildInt(5);
        for (int i = 0; i < 4; i++){
            q1.dequeue();
        }
        assertEquals(q1.first(), q1.dequeue());

        // Get first object in a huge queue
        Queue q2 = buildInt(100000);
        assertEquals(q2.first(), q2.dequeue());
    }

    @Test
    public void last() throws Exception {
        // Get last object in an empty queue
        try{
            Queue q = buildInt(0);
            q.last();
            fail("Expected an IndexOutOfBounds to be thrown");
        }catch(IndexOutOfBoundsException e){
            assertThat(e.getMessage(), is("Error: Queue is empty!"));
        }

        // Get last object in a queue
        Queue q = buildInt(5);
        q.enqueue("Testing");
        assertEquals("Testing", q.last());

        // Get last object after dequeued everything else
        Queue q1 = buildInt(5);
        for (int i = 0; i < 4; i++){
            q1.dequeue();
        }
        q1.enqueue(2);
        assertEquals(2, q1.last());

        // Get last object in a huge queue
        Queue q2 = buildInt(100000);
        q2.enqueue("Testing again");
        assertEquals("Testing again", q2.last());

        // Testing last on an dequeued queue
        try {
            Queue q5 = buildInt(5);
            for (int i = 0; i < 5; i++){
                q5.dequeue();
            }
            q5.last();
            fail("Expected an IndexOutOfBounds to be thrown");
        }catch (IndexOutOfBoundsException e){
            assertThat(e.getMessage(), is("Error: Queue is empty!"));
        }

        // Testing last on a queue with one object
        Queue q3 = buildInt(1);
        assertEquals(0, q3.last());

    }

    @Test
    public void iterator() throws Exception {
        // Testing iterator on a queue with 10
        Queue q = buildInt(10);
        Iterator it = q.iterator();
        while (it.hasNext()){
            System.out.print(it.next() + " ");
        }

        // Testing iterator on a queue with a huge amount
        Queue q1 = buildInt(100000);
        it = q1.iterator();
        while(it.hasNext()){
            System.out.print(it.next() + " ");
        }

        // Testing to iterate over an empty queue
        Queue q2 = buildInt(0);
        it = q2.iterator();
        while(it.hasNext()){
            System.out.println(it.next() + " ");
        }
    }

    private Queue buildInt(int size){
        Queue queue = new Queue();
        for (int i = 0; i < size; i++){
            queue.enqueue(i);
        }
        return queue;
    }

    private Queue buildString(int size){
        Queue queue = new Queue();
        for (int i = 0; i < size; i++){
            queue.enqueue(Integer.toString(i));
        }
        return queue;
    }

}