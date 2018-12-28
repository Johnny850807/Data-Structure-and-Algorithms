package practices.waterball.adt;

import dsa.adt.LinkedList;
import practices.waterball.adt.nodes.WbLinkNode;

public class WbSingleLinkList extends SingleLinkedList {
    private WbLinkNode head;
    private WbLinkNode tail;

    @Override
    public SingleLinkedList invert() {
        WbLinkNode left, right = null, p = head;

        tail = head;
        while(p != null)
        {
            left = right;
            right = p;
            p = p.next;
            right.next = left;
        }
        head = right;
        return this;
    }


    @Override
    public LinkedList addHead(int item) {
        WbLinkNode node = new WbLinkNode(item);
        if (head == null)
            head = tail = node;
        node.next = head;
        head = node;
        return this;
    }

    @Override
    public LinkedList addTail(int item) {
        WbLinkNode node = new WbLinkNode(item);
        if (head == null)
            head = tail = node;
        tail.next = node;
        tail = node;
        return this;
    }

    @Override
    public LinkedList insert(int index, int item) {
        WbLinkNode node = new WbLinkNode(item);
        WbLinkNode p = head;

        if (index == -1)
            throw new IndexOutOfBoundsException();
        if (isEmpty())
            return addHead(item);

        for (int i = 0; i < index; i ++)
        {
            p = p.next;
            if (p == null)
                throw new IndexOutOfBoundsException();
        }

        if (p == tail)
        {
            tail.next = node;
            tail = node;
        }
        else //head or between head and tail
        {
            node.next = p.next;
            p.next = node;
        }

        return this;
    }


    @Override
    public int deleteHead() {
        int item = head.data;
        head = head.next;
        return item;
    }

    @Override
    public int deleteTail() {
        int item = tail.data;
        WbLinkNode previous = head;
        while (previous.next != tail)
            previous = previous.next;
        tail = previous;
        return item;
    }

    @Override
    public int delete(int index) {
        WbLinkNode previous = null;
        WbLinkNode p = head;
        for (int i = 0; i < index; i ++)
        {
            previous = p;
            p = p.next;
        }

        if (index == 0)
            return deleteHead();
        else if (p == tail)
            return deleteTail();
        else
            previous.next = p.next;
        return p.data;
    }

    @Override
    public int get(int index) {
        WbLinkNode p = head;
        for (int i = 0; i < index; i ++)
            p = p.next;
        return p.data;
    }

    @Override
    public int length() {
        int count = 0;
        WbLinkNode p = head;
        while (p != null)
        {
            count ++;
            p = p.next;
        }
        return count;
    }

    @Override
    public boolean isEmpty() {
        return head == null;
    }

    @Override
    public LinkedList concatenate(LinkedList linkedList) {
        WbSingleLinkList wblist = (WbSingleLinkList)linkedList;
        tail.next = wblist.head;
        tail = wblist.tail;
        return this;
    }

    @Override
    public Object head() {
        return head;
    }

    @Override
    public String toString() {
        if (head == null)
            return "";
        StringBuilder stringBuilder = new StringBuilder();
        for (WbLinkNode n = head; n != null; n = n.next)
            stringBuilder.append(n.data).append(" ");
        return stringBuilder.toString().trim();
    }
}
