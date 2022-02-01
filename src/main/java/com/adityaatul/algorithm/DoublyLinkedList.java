package com.adityaatul.algorithm;

import com.adityaatul.exception.InvalidElementException;
import lombok.Data;

@Data
public class DoublyLinkedList<E> {

    DoublyLinkedListNode<E> head;
    DoublyLinkedListNode<E> tail;

    public DoublyLinkedList() {
        head = new DoublyLinkedListNode<>(null);
        tail = new DoublyLinkedListNode<>(null);

        head.next = tail;
        tail.prev = head;
    }

    /**
     * Method to detach a random node from a DLL.
     * @param node to remove
     */
    public void detachNode(DoublyLinkedListNode<E> node) {
        if (node != null) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }
    }

    /**
     * Helper method to add a node at the end of the list.
     * @param node
     */
    public void addNodeAtLast(DoublyLinkedListNode<E> node) {
        DoublyLinkedListNode tailPrev = this.tail.prev;
        node.prev = tailPrev;
        node.next = this.tail;
        tailPrev.next = node;
        this.tail.prev = node;
    }

    /**
     * Helper method to add element at last and return and instance of the element.
     * @param element
     * @return The element added to the list.
     */
    public DoublyLinkedListNode<E> addElementAtLast(E element) {
        if (element == null) {
            throw new InvalidElementException("Invalid element provided");
        }
        DoublyLinkedListNode<E> newNode = new DoublyLinkedListNode<>(element);
        addNodeAtLast(newNode);
        return newNode;
    }
}
