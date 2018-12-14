package practices.waterball.adt;

import dsa.adt.Stack;

public class WbLinkedListStack extends Stack{
    private Node top = null;

    public WbLinkedListStack() {
        super((int) Double.POSITIVE_INFINITY);
    }

    @Override
    public boolean isFull() {
        return false;
    }

    @Override
    public boolean isEmpty() {
        return top == null;
    }

    @Override
    public Stack push(int item) {
        Node node = new Node(item);
        node.link = top;
        top = node;
        return this;
    }

    @Override
    public int pop() {
        return 0;
    }


    private class Node{
        int data;
        Node link;

        public Node(int data) {
            this.data = data;
        }
    }
}
