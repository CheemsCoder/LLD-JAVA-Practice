package org.example.Cache.Algorithms;

public class DoublyLinkedList<E> {
    private final DoublyLinkedListNode<E> head;
    private final DoublyLinkedListNode<E> tail;

    public boolean isEmpty() {
        return head.next == tail;
    }

    public DoublyLinkedList() {
        this.head = new DoublyLinkedListNode<>(null);
        this.tail = new DoublyLinkedListNode<>(null);
        this.head.next = this.tail;
        this.tail.prev = this.head;
    }

    public void insertNodeAtEnd(DoublyLinkedListNode<E> node) {
        DoublyLinkedListNode<E> tailPrev = this.tail.prev;
        tailPrev.next = node;
        node.prev = tailPrev;
        node.next = tail;
        tail.prev = node;
    }

    public DoublyLinkedListNode<E> insertElementAtEnd(E element) {
        DoublyLinkedListNode<E> node = new DoublyLinkedListNode<>(element);
        insertNodeAtEnd(node);
        return node;
    }

    public void detachNode(DoublyLinkedListNode<E> node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    public DoublyLinkedListNode<E> getFirstNode() {
        if (isEmpty())
            return null;
        return head.next;
    }

    public DoublyLinkedListNode<E> getLastNode() {
        if (isEmpty())
            return null;
        return tail.prev;
    }


}
