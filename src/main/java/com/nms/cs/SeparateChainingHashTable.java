package com.nms.cs;

public class SeparateChainingHashTable<K, V> {

    public final int capacity;
    public HashTableNode[] symbolTable;
    public int size;

    public SeparateChainingHashTable(int capacity) {
        this.capacity = capacity;
        //noinspection unchecked
        symbolTable = new HashTableNode[capacity];
        size = 0;
    }

    private class HashTableNode<K, V> {

        K key;
        V value;
        HashTableNode next;

        HashTableNode(K key, V value, HashTableNode next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }

    public V get(K key) {
        int hashCode = Math.abs(key.hashCode());
        int hash = hashCode % capacity;

        if(symbolTable[hash] != null){
            HashTableNode<K,V> currentNode = symbolTable[hash];
            while(currentNode != null){
                if(key.equals(currentNode.key)){
                    return currentNode.value;
                }
                currentNode = currentNode.next;
            }
        }
        return null;
    }

    public void put(K key, V value) {

        int hashCode = key.hashCode();
        int hash = hashCode % capacity;

        HashTableNode newNode = new HashTableNode(key, value, null);
        HashTableNode currentNode = symbolTable[hash];
        if (currentNode != null) {
            //Check if value already exists in the map
            while (currentNode != null) {
                if (key.equals(currentNode.key)) {
                    currentNode.value = value;
                    return;
                }
                currentNode = currentNode.next;
            }
            newNode = new HashTableNode(key, value, symbolTable[hash]);
        }
        symbolTable[hash] = newNode;
        size++;
        return;
    }

    public V remove(K key) {

        int hashCode = Math.abs(key.hashCode());
        int hash = hashCode % capacity;

        if(hash < symbolTable.length && symbolTable[hash] != null){
            HashTableNode<K,V> currentNode = symbolTable[hash];
            HashTableNode prevNode = null;

            //Head element is key to be removed
            if(key.equals(currentNode.key)){
                symbolTable[hash] = currentNode.next;
                size--;
                return currentNode.value;
            }

            while(currentNode != null){
                if(key.equals(currentNode.key)){
                    prevNode.next = currentNode.next;
                    size--;
                    return currentNode.value;
                }
                prevNode = currentNode;
                currentNode = currentNode.next;
            }
        }
        return null;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public String toString(){
        StringBuilder symbolTableString = new StringBuilder();
        for(HashTableNode htNode : symbolTable){
            HashTableNode<K,V> temp = htNode;
            while (temp != null){
                symbolTableString.append("Key: " + temp.key + ". Value: " + temp.value + "\n");
                temp = temp.next;
            }
            symbolTableString.append("================= \n");
        }
        return symbolTableString.toString();
    }

    // Driver method to tessymbolTable[hash]t Map class
    public static void main(String[] args) {
        SeparateChainingHashTable<String, Integer> map = new SeparateChainingHashTable<>(2);
        map.put("this", 1);
        map.put("coder", 2);
        map.put("hi", 5);
        map.put("true", 6);
        map.put("foo", 7);
        map.put("bar", 8);
        map.put("hello", 9);
        map.put("time", 10);
        map.put("this", 4);
        System.out.println(map);

        System.out.println(map.get("hello"));
        System.out.println(map.get("true"));
        System.out.println(map.get("coder"));
        System.out.println(map.get("doesnotexist"));

        System.out.println(map.remove("hello"));
        System.out.println(map.remove("true"));
        System.out.println(map.remove("coder"));
        System.out.println(map.remove("doesnotexist"));

    }
}

