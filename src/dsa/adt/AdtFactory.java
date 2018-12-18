package dsa.adt;

public interface AdtFactory {
    ArrayStack createArrayStack(int maxSize);
    LinkedListStack createLinkedListStack();
    MultipleStack createDoubleStack(int maxSize);
    MultipleStack createMultipleStack(int n, int maxSize);
    Queue createCircularArrayQueue(int maxSize);
    Queue createSingleLinkedListQueue();
    Queue createCircularLinkedListQueue();
    LinkedList createLinkedList();
    BSTree createBStree();
}
