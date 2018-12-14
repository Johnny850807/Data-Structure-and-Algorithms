package dsa.adt;

public interface AdtFactory {
    Stack createArrayStack(int maxSize);
    Stack createLinkedListStack();
}
