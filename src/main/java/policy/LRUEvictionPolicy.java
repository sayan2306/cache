package policy;

import ds.DoublyLinkedList;
import ds.DoublyLinkedListNode;

import java.util.HashMap;
import java.util.Map;

public class LRUEvictionPolicy<K> implements EvictionPolicy<K> {
    private DoublyLinkedList<K> dll;
    private Map<K, DoublyLinkedListNode<K>> mapper;


    public LRUEvictionPolicy() {
        dll = new DoublyLinkedList<K>();
        mapper = new HashMap<K, DoublyLinkedListNode<K>>();
    }


    public void keyAccessed(K key) throws Exception {
        if(mapper.containsKey(key)) {
            dll.removeNode(mapper.get(key));
            dll.addElementToLast(key);
        } else {
            DoublyLinkedListNode<K> newNode = dll.addElementToLast(key);
            mapper.put(key, newNode);
        }
    }

    public K evictKey() {
        DoublyLinkedListNode<K> first = dll.getFirstNode();
        if(first == null) {
            return null;
        }
        dll.removeNode(first);
        return first.data;
    }
}
