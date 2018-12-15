package practices.waterball.adt;

import com.sun.org.apache.regexp.internal.RE;
import dsa.adt.ArrayQueue;
import dsa.adt.Queue;

public class WbCircularArrayQueue extends ArrayQueue {
    private int front;
    private int rear;
    private boolean isFull = false;

    public WbCircularArrayQueue(int MAX_SIZE) {
        super(MAX_SIZE);
        front = rear = 0;
    }

    @Override
    public Queue add(int item) {
        if (isFull())
            throw new RuntimeException("Full");
        rear = (rear + 1) % MAX_SIZE;
        elements[rear] = item;
        if (front == rear)
            isFull = true;
        return this;
    }

    @Override
    public int delete() {
        if (isEmpty())
            throw new RuntimeException("Empty");
        front = (front + 1) % MAX_SIZE;
        if (front == rear)
            isFull = false;
        return elements[front];
    }

    @Override
    public boolean isEmpty() {
        return !isFull && rear == front;
    }

    @Override
    public boolean isFull() {
        return isFull && rear == front;
    }
}
