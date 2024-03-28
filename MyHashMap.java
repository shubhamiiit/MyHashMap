package HashMap;

import java.beans.IntrospectionException;

public class MyHashMap<K,V>{

    // Initial capacity of default hashmap
    private static final int INITIAL_SIZE = 1 << 14;

    // Maximum capacity of Hashmap
    private static final int MAXIMUM_CAPACITY = 1 << 30;

    public Entry[] hashTable;

    public MyHashMap(){
        hashTable = new Entry[INITIAL_SIZE];
    }

    public MyHashMap(int capacity){
        int tableSize = tableSizeFor(capacity);
        hashTable = new Entry[tableSize];
    }

    final int tableSizeFor(int capacity){
        int n = capacity-1;

        n |= n >>> 1;
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;

        return (n<0)?1:(n>=MAXIMUM_CAPACITY)? MAXIMUM_CAPACITY : n+1;
    }

    class Entry<K,V>{

        public K key;
        public V value;
        public Entry next;

        Entry(K k, V v){
            key = k;
            value = v;
        }   
    }

    public void put(K key, V value){
        int hashCode = key.hashCode()%hashTable.length;

        Entry existing = hashTable[hashCode];

        if(existing == null){
            Entry newNode = new Entry<K,V>(key, value);
            hashTable[hashCode] = newNode;
        }
        else{
            Entry previousNode = existing;
            while(existing != null){
                if(existing.key == key){
                    existing.value = value;
                    return;
                }
                previousNode = existing;
                existing = existing.next;
            }
            Entry newNode = new Entry<K,V>(key, value);
            previousNode.next = newNode;
        }
    }


    public V get(K key){
        int hashCode = key.hashCode()%hashTable.length;
        Entry existing = hashTable[hashCode];

        while(existing != null){
            if(existing.key.equals(key)){
                return (V) existing.value;
            }
            existing = existing.next;
        }

        return null;
    }

    public static void main(String[] args) {
        MyHashMap<Integer, String>map = new MyHashMap<Integer, String>(10);
        map.put(1, "hi");
        map.put(2, "bye");
        String value = map.get(1);
        System.out.println(value);
    }
}