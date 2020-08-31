package ds;

public class DoublyLinkedListNode<T> {
    public DoublyLinkedListNode<T> next;
    public DoublyLinkedListNode<T> prev;
    public T data;

    public DoublyLinkedListNode(T data) {
        this.next = null;
        this.prev = null;
        this.data = data;
    }
}
