package practices.waterball.adt;

import dsa.adt.LinkedListQueue;
import dsa.adt.Queue;

public class WbCircularLinkedListQueue extends LinkedListQueue {
    private WbLinkNode rear;

    @Override
    public Queue add(int item) {
        WbLinkNode node = new WbLinkNode(item);

        if (rear == null)
            node.next = node;
        else
        {
            node.next = rear.next;
            rear.next = node;
        }

        rear = node;
        return this;
    }

    @Override
    public int delete() {
        if (isEmpty())
            throw new RuntimeException("Empty");

        WbLinkNode front = rear.next;
        rear.next = front.next;

        return front.data;
    }

    @Override
    public boolean isEmpty() {
        return rear == null;
    }

    @Override
    public boolean isFull() {
        return false;
    }
}
