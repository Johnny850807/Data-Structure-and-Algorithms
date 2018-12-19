package practices.waterball.adt;

import dsa.adt.LinkedListStack;
import practices.waterball.adt.nodes.WbLinkNode;

public class WbLinkedListStack extends LinkedListStack {
    private WbLinkNode top = null;

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
        WbLinkNode node = new WbLinkNode(item);
        node.next = top;
        top = node;
        return this;
    }

    @Override
    public int pop() {
        if (isEmpty())
            throw new RuntimeException("Empty");

        int item = top.data;
        top = top.next;
        return item;
    }

}
