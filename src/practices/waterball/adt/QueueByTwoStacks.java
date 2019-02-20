package practices.waterball.adt;


import dsa.adt.Queue;
import dsa.adt.Stack;


public class QueueByTwoStacks extends Queue {
    private Stack stack1;
    private Stack stack2;

    public QueueByTwoStacks(Stack stack1, Stack stack2) {
        this.stack1 = stack1;
        this.stack2 = stack2;
    }

    @Override
    public Queue add(int item) {
        stack1.push(item);
        return this;
    }

    @Override
    public int delete() {
        if(stack2.isEmpty())
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
        return stack1.isFull();
    }
}
