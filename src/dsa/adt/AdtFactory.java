package dsa.adt;

import practices.waterball.adt.SingleLinkedList;

public interface AdtFactory {
    ArrayStack createArrayStack(int maxSize);
    LinkedListStack createLinkedListStack();
    MultipleStack createDoubleStack(int maxSize);
    MultipleStack createMultipleStack(int n, int maxSize);
    Queue createCircularArrayQueue(int maxSize);
    Queue createSingleLinkedListQueue();
    Queue createCircularLinkedListQueue();
    SingleLinkedList createSingleLinkedList();
    LinkedList createDoubleLinkedList();
    BSTree createBStree();
    MinBinaryHeap createMinHeap();
    DisjointSet createDisjointSet();
}
