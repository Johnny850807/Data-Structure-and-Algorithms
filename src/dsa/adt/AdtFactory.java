package dsa.adt;

import practices.waterball.adt.SingleLinkedList;


public interface AdtFactory {
    ArrayStack createArrayStack(int maxSize);
    LinkedListStack createLinkedListStack();
    MultipleStack createDoubleStack(int maxSize);
    MultipleStack createMultipleStack(int n, int maxSize);
    Queue createQueueByTwoStacks(Stack stack1, Stack stack2);
    Deque createDequeByTwoStacks(Stack stack1, Stack stack2);
    Queue createCircularArrayQueue(int maxSize);
    Queue createSingleLinkedListQueue();
    Queue createCircularLinkedListQueue();
    SingleLinkedList createSingleLinkedList();
    LinkedList createDoubleLinkedList();
    BSTree createBStree();
    BSTree createAVLBStree();
    MinBinaryHeap createMinBinaryHeap();
    DisjointSet createDisjointSet();
    MinMaxHeap createMinMaxHeap();
    HashMap createHashMap();
    BSTree createOBST(double[] p);
}
