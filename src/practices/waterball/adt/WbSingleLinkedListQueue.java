package practices.waterball.adt;

import dsa.adt.LinkedListQueue;
import dsa.adt.Queue;

public class WbSingleLinkedListQueue extends LinkedListQueue{
    private WbLinkNode front;
    private WbLinkNode rear;

    @Override
    public Queue add(int item) {
        WbLinkNode node = new WbLinkNode(item);
        if (front == null)
            front = node;
        else
            rear.next = node;
        rear = node;
        return this;
    }

    @Override
    public int delete() {
        if (isEmpty())
            throw new RuntimeException("Empty");
        int item = front.data;
        front = front.next;
        return item;
    }

    @Override
    public boolean isEmpty() {
        return front == null;
    }

    @Override
    public boolean isFull() {
        return false;
    }
}
