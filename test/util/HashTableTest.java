package util;

import exception.HashEmptyException;
import exception.NonexistentKeyException;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

class HashTableTest {

    private HashTable<Integer, Integer> hash;

    private void setupScenary1() {
        hash = new HashTable<Integer, Integer>();
    }


    private void setupScenary2(){
        hash = new HashTable<Integer, Integer>();
        hash.add(1, 1);

    }

    private void setupScenary3() {
        hash = new HashTable<Integer, Integer>();
        hash.add(1, 1);
        hash.add(2, 2);
        hash.add(3, 3);
        hash.add(4, 4);
        hash.add(5, 5);
    }

    @Test
    public void emptyHashTest() {
        //setup test
        setupScenary1();

        //act
        boolean empty = hash.isEmpty();

        //assert
        assertTrue(empty, "The Hash isn't empty");
    }

    @Test
    public void deleteEmptyHashTest() throws NonexistentKeyException, HashEmptyException {
        //setup test
        setupScenary1();

        //act
        boolean removed = hash.remove(1);

        //assert
        assertFalse(removed, "Can't delete an object from an empty Hash");
    }

    @Test
    public void addTest1(){
        //setup test
        setupScenary2();

        //assert
        assertFalse(hash.isEmpty(), "The Hash is not empty");
    }

    @Test
    public void addTest2() {
        //setup test
        setupScenary3();

        //act
        hash.add(1, 1);
        hash.add(2, 2);
        hash.add(3, 3);
        hash.add(4, 4);
        hash.add(5, 5);

        //assert
        assertEquals(5, hash.getSize(), "The size is not correct");
    }

    @Test
    public void searchTest(){
        //setup test
        setupScenary3();

        //act
        int value = hash.search(4);

        //assert
        assertEquals(4, value, "The value is not correct");
    }

}
