package model;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
public class HashNodeTest {

    @Test
    public void testHashNode() {
        HashNode<Integer, String> hashNode = new HashNode<Integer, String>(1, "Hola");
        assertEquals(1, hashNode.getKey());
        assertEquals("Hola", hashNode.getValue());
        assertNull(hashNode.getNext());
        assertNull(hashNode.getPrevius());
        assertEquals(1, hashNode.getSize());
    }

    @Test
    public void testGetKey() {
        HashNode<Integer, String> hashNode = new HashNode<Integer, String>(1, "Hola");
        assertEquals(1, hashNode.getKey());
    }

    @Test
    public void testSetKey() {
        HashNode<Integer, String> hashNode = new HashNode<Integer, String>(1, "Hola");
        hashNode.setKey(2);
        assertEquals(2, hashNode.getKey());
    }

    @Test
    public void testGetValue() {
        HashNode<Integer, String> hashNode = new HashNode<Integer, String>(1, "Hola");
        assertEquals("Hola", hashNode.getValue());
    }

    @Test
    public void testSetValue() {
        HashNode<Integer, String> hashNode = new HashNode<Integer, String>(1, "Hola");
        hashNode.setValue("Adios");
        assertEquals("Adios", hashNode.getValue());
    }

    @Test
    public void testGetNext() {
        HashNode<Integer, String> hashNode = new HashNode<Integer, String>(1, "Hola");
        assertNull(hashNode.getNext());
    }

    @Test
    public void testSetNext() {
        HashNode<Integer, String> hashNode = new HashNode<Integer, String>(1, "Hola");
        HashNode<Integer, String> hashNode2 = new HashNode<Integer, String>(2, "Adios");
        hashNode.setNext(hashNode2);
        assertEquals(hashNode2, hashNode.getNext());
    }

    @Test
    public void testGetPrevius() {
        HashNode<Integer, String> hashNode = new HashNode<Integer, String>(1, "Hola");
        assertNull(hashNode.getPrevius());
    }

    @Test
    public void testSetPrevius() {
        HashNode<Integer, String> hashNode = new HashNode<Integer, String>(1, "Hola");
        HashNode<Integer, String> hashNode2 = new HashNode<Integer, String>(2, "Adios");
        hashNode.setPrevius(hashNode2);
        assertEquals(hashNode2, hashNode.getPrevius());

    }

}
