package org.example.Cache.Eviction;

import org.example.Cache.Algorithms.DoublyLinkedList;
import org.example.Cache.Algorithms.DoublyLinkedListNode;

import java.util.*;

public class LRUEvictionPolicy<Key> implements EvictionPolicy<Key> {
    private final Map<Key, DoublyLinkedListNode<Key>> map;
    private final DoublyLinkedList<Key> dll;

    public LRUEvictionPolicy() {
        this.map = new HashMap<>();
        this.dll = new DoublyLinkedList<>();
    }

    @Override
    public void keyAccessed(final Key key) {
        if(map.containsKey(key)) {
            dll.detachNode(map.get(key));
            dll.insertNodeAtEnd(map.get(key));
        } else {
            DoublyLinkedListNode<Key> node = dll.insertElementAtEnd(key);
            map.put(key, node);
        }
    }

    @Override
    public Key evict() {
        final DoublyLinkedListNode<Key> lruNode = dll.getFirstNode();
        dll.detachNode(lruNode);
        map.remove(lruNode.getElement());
        return lruNode.getElement();
    }
}
