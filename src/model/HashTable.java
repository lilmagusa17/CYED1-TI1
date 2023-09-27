package model;

import util.IHash;
    public class HashTable<K, V extends Comparable<V>> implements IHash<K, V> {

        public static final int UNIVERSE = 11;

        private HashNode<K, V>[] list;

        private int size;


        public HashTable() {
            this.size = 0;
            list = new HashNode[UNIVERSE];

        }

        @Override
        public void add(K key, V value) {
            int index = hashFunction(key);
            HashNode<K, V> nodeAdd = new HashNode<K, V>(key, value);

            if(list[index]!= null) {
                list[index].add(nodeAdd);

            }else {
                list[index] = nodeAdd;
                size++;
            }

        }

        @Override
        public boolean remove(K key){
            int index = hashFunction(key);

            if(isEmpty() == true) {
               return false;
            }else {
                if(list[index] == null) {
                    return false;
                }else {
                    if(list[index].getNext() == null) {
                        list[index] = null;
                        size--;
                        return true;
                    }else {
                        list[index].romoveLast();
                        size--;
                        return true;
                    }
                }
            }
        }

        @Override
        public V search(K key) {
            int index = hashFunction(key);
            return list[index].getValue();
        }

        @Override
        public int getSize() {
            return size;
        }

        @Override
        public boolean isEmpty() {
            return size==0;
        }

        public int hashFunction(K key) {
            int index = key.hashCode();

            if(index > UNIVERSE) {
                index = key.hashCode()% UNIVERSE;
            }else if (index < 1 ) {
                index = key.hashCode()* UNIVERSE;
            }

            return index +1;
        }


    }


