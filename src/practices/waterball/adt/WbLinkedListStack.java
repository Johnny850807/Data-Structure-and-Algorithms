package practices.waterball.adt;

import dsa.adt.ArrayStack;
import dsa.adt.LinkedListStack;

public class WbLinkedListStack extends LinkedListStack {
    private Node top = null;

    @Override
    public boolean isFull() {
        return false;
    }

    @Override
    public boolean isEmpty() {
        return top == null;
    }

    @Override
    public LinkedListStack push(int item) {
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
