package org.neatcode;

public class DoublyList<K, V> {
    private final Node<K, V> head;
    private final Node<K, V> tail;
    public DoublyList() {
        this.head = new Node<>(null, null);
        this.tail = new Node<>(null, null);
        head.setNext(tail);
        tail.setPrev(head);
    }

    public void addToFront(Node<K, V> node) {
        Node temp = head.getNext();
        head.setNext(node);
        temp.setPrev(node);
        node.setPrev(head);
        node.setNext(temp);
    }

    public void moveToFront(Node<K, V> node) {
        node.getPrev().setNext(node.getNext());
        node.getNext().setPrev(node.getPrev());

        addToFront(node);
    }

    public Node<K, V> removeFromEnd() {
        if (tail.getPrev() == head) {
            return null;
        }

        Node<K, V> removedNode = tail.getPrev();
        tail.setPrev(removedNode.getPrev());
        removedNode.getPrev().setNext(tail);
        return removedNode;
    }
}
