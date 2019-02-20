package practices.waterball.adt;

import dsa.adt.Deque;
import dsa.adt.Stack;

public class DequeByTwoStacks implements Deque {
    private Stack stack1;
    private Stack stack2;

    public DequeByTwoStacks(Stack stack1, Stack stack2) {
        this.stack1 = stack1;
        this.stack2 = stack2;
    }

    @Override
    public Deque addHead(int item) {
        stack1.push(item);
        return this;
    }

    @Override
    public int deleteHead() {
        if (stack1.isEmpty())
        {
            while (!stack2.isEmpty())
                stack1.push(stack2.pop());
        }
        if (!stack1.isEmpty())
            return stack1.pop();

        throw new RuntimeException("Empty");
    }

    @Override
    public Deque addTail(int item) {
        stack2.push(item);
        return this;
    }

    @Override
    public int deleteTail() {
        if (stack2.isEmpty())
        {
            while (!stack1.isEmpty())
                stack2.push(stack1.pop());
        }
        if (!stack2.isEmpty())
            return stack2.pop();

        throw new RuntimeException("Empty");
    }

    @Override
    public boolean isEmpty() {
        return stack1.isEmpty() && stack2.isEmpty();
    }

    @Override
    public boolean isFull() {
        return stack1.isFull() || stack2.isFull();
    }
}
