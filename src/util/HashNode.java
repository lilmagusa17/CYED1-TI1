package util;

public class HashNode<K, V extends Comparable<V>> {
    private K key;
    private V value;

    private HashNode<K,V> next;
    private HashNode<K,V> previous;
    private int size;

    /**
     * Constructor of the class
     * @param key
     * @param value
     */
    public HashNode(K key, V value) {

        this.key = key;
        this.value = value;
        next = null;
        previous = null;
        size = 1;

    }

    /**
     * This method return the key of the node
     * @return key
     */

    public K getKey() {
        return key;
    }

    /**
     * This method set the key of the node
     * @param key
     */
    public void setKey(K key) {
        this.key = key;
    }

    /**
     * This method return the value of the node
     * @return value
     */
    public V getValue() {
        return value;
    }

    /**
     * This method set the value of the node
     * @param value
     */
    public void setValue(V value) {
        this.value = value;
    }

    /**
     * This method return the next node
     * @return next
     */
    public HashNode<K, V> getNext() {
        return next;
    }

    /**
     * This method set the next node
     * @param next
     */
    public void setNext(HashNode<K, V> next) {
        this.next = next;
    }


    /**
     * This method return the previus node
     * @return
     */
    public HashNode<K, V> getPrevious() {
        return previous;
    }

    /**
     * This method set the previus node
     * @param previous
     */
    public void setPrevious(HashNode<K, V> previous) {
        this.previous = previous;
    }

    /**
     * This method returns the size of the node
     * @return size
     */
    public int getSize() {
        return size;
    }


    /**
     * This method increments the size of the node
     */
    public void incrementSize() {
        size++;
    }

    /**
     * This method adds a node to the list
     * @param added
     */
    public void add(HashNode<K, V> added) {
        if(next == null) {
            next = added;
        }else {
            next.add(added);
        }
    }

    /**
     * This method removes the last node of the list
     */
    public void removeLast() {
        if(next.getNext() == null) {
            next = null;
        }else {
            next.removeLast();
        }
    }


    /**
     * This method returns the node with the value
     * @param value
     * @return
     */
    public HashNode<K, V> getObjet(V value){
        if(next != null) {
            if(next.value.compareTo(value)== 0) {
                return next;
            }else {
                return next.getObjet(value);
            }
        }else {
            return null;
        }
    }

}

