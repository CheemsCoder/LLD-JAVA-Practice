package org.example.Cache.Algorithms;

public class DoublyLinkedListNode<E> {
    E element;
    DoublyLinkedListNode<E> next;
    DoublyLinkedListNode<E> prev;

    public DoublyLinkedListNode(E element) {
        this.element = element;
        this.next = null;
        this.prev = null;
    }

    public E getElement() {
        return element;
    }
}
