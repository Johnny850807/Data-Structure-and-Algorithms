package dsa.adt;

public interface LinkedList extends ADT{

    LinkedList addHead(int item);
    LinkedList addTail(int item);
    LinkedList insert(int index, int item);
    int deleteHead();
    int deleteTail();
    int delete(int index);
    int get(int index);
    int length();
    boolean isEmpty();
    LinkedList concatenate(LinkedList linkedList);
    Object head();
}
