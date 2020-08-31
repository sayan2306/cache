package ds;

import exception.InvalidElementException;

public class DoublyLinkedList<T>{

    DoublyLinkedListNode<T> head;
    DoublyLinkedListNode<T> tail;

    public DoublyLinkedList() {
        head = new DoublyLinkedListNode<T>(null);
        tail = new DoublyLinkedListNode<T>(null);

        head.next = tail;
        tail.prev = head;
    }



    public void addElementToLast(T element) throws InvalidElementException{
        if(element == null) {
            throw new InvalidElementException();
        }
        DoublyLinkedListNode<T> node = new DoublyLinkedListNode<T>(element);
        DoublyLinkedListNode<T> temp = tail.prev;
        node.next = tail;
        tail.prev = node;
        temp.next = node;
        node.prev = temp;
    }


    public void removeNode(DoublyLinkedListNode<T> node) {
        if(node != null) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }
    }
}

