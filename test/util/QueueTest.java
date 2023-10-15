package util;
import static org.junit.jupiter.api.Assertions.*;

import exception.EmptyQueueException;
import org.junit.jupiter.api.Test;
public class QueueTest {

    //queue test
    private Queue<String> queue;

    private void setupScenary1() {
        queue = new Queue<String>();
    }

    private void setupScenary2() {
        queue = new Queue<String>();
        queue.enqueue("Hola");
        queue.enqueue("Adios");
        queue.enqueue("Buenas tardes");
    }

    @Test
    public void enqueueTest() throws EmptyQueueException {
        setupScenary1();
        queue.enqueue("Hola");
        assertEquals("Hola", queue.peek());
    }

    @Test
    public void peekTest() throws EmptyQueueException {
        setupScenary2();
        assertEquals("Hola", queue.peek());
    }

    @Test
    public void dequeueTest() throws EmptyQueueException {
        setupScenary2();
        assertEquals("Hola", queue.dequeue());
    }

    @Test
    public void isEmptyTest() {
        setupScenary1();
        assertTrue(queue.isEmpty());
    }

    @Test
    public void notIsEmptyTest() {
        setupScenary2();
        assertFalse(queue.isEmpty());
    }

    @Test
    public void sizeTest() {
        setupScenary2();
        assertEquals(3, queue.size());
    }

}
