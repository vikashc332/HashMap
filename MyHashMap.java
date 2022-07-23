package com.Hashmap;

import com.blz.linkedlist.LinkList;


public class MyHashMap<K, V> {

     LinkList<K> hashLinkedList;

    public MyHashMap() {
        this.hashLinkedList = new LinkList<K, V>();
    }


    public V get(K key) {
        Node<K, V> myMapNode = (Node<K, V>) this.hashLinkedList.search(key);
        return (myMapNode == null) ? null : myMapNode.getValue();
    }

    public void add(K key, V value) {
        Node<K, V> myMapNode = (Node<K, V>) this.hashLinkedList.search(key);
        if (myMapNode == null) {
            myMapNode = new Node<K, V>(key, value);
            this.hashLinkedList.append(Node);
        } else {
            myMapNode.setValue(value);
        }
    }

    @Override
    public String toString() {
        return "Hash Map{" + hashLinkedList + "}";
    }

}
