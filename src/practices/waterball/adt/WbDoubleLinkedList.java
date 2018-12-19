package practices.waterball.adt;

import dsa.adt.LinkedList;
import practices.waterball.adt.nodes.WbDoubleLinkNode;

public class WbDoubleLinkedList implements LinkedList {
    private WbDoubleLinkNode head;

    @Override  // O(1)
    public LinkedList addHead(int item) {
        WbDoubleLinkNode node = new WbDoubleLinkNode(item);
        if (head == null)
        {
            head = node;
            head.next = head.previous = head;
        }
        else
        {
            WbDoubleLinkNode tail = head.previous;
            tail.next = node;
            node.previous = tail;
            node.next = head;
            head.previous = node;
            head = node;
        }
        return this;
    }

    @Override  // O(1)
    public LinkedList addTail(int item) {
        WbDoubleLinkNode node = new WbDoubleLinkNode(item);
        if (head == null)
        {
            head = node;
            head.next = head.previous = head;
        }
        else
        {
            WbDoubleLinkNode tail = head.previous;
            tail.next = node;
            node.previous = tail;
            head.previous = node;
            node.next = head;
        }
        return this;
    }

    @Override  // O(1)
    public int deleteHead() {
        if (head == null)
            throw new RuntimeException("Empty");
        int item = head.data;
        WbDoubleLinkNode tail = head.previous;
        head.next.previous = tail;
        tail.next = head.next;
        head = head.next;
        return item;
    }

    @Override  // O(1)
    public int deleteTail() {
        if (head == null)
            throw new RuntimeException("Empty");
        WbDoubleLinkNode tail = head.previous;
        int item = tail.data;
        tail.previous.next = head;
        head.previous = tail.previous;
        return item;
    }

    @Override  // O(n)
    public int delete(int index) {
        WbDoubleLinkNode target = findNode(index);
        target.previous.next = target.next;
        target.next.previous = target.previous;
        return target.data;
    }

    @Override  // O(n)
    public int get(int index) {
        return findNode(index).data;
    }

    @Override  // O(n)
    public LinkedList insert(int index, int item) {
        WbDoubleLinkNode target = findNode(index);
        WbDoubleLinkNode node = new WbDoubleLinkNode(item);
        node.next = target.next;
        target.next.previous = node;
        node.previous = target;
        target.next = node;
        return this;
    }

    // O(n)
    private WbDoubleLinkNode findNode(int index){
        WbDoubleLinkNode target = head;
        for (int i = 1; i <= index; i ++)
        {
            target = target.next;
            if (target == head)
                throw new IndexOutOfBoundsException("Index out of bound.");
        }
        return target;
    }

    @Override  // O(n)
    public int length(){
        if (head == null)
            return 0;

        WbDoubleLinkNode pointer = head;
        int length = 1;
        while(pointer.next != head)
        {
            pointer = pointer.next;
            length ++;
        }
        return length;
    }

    @Override
    public boolean isEmpty() {
        return head == null;
    }

    @Override
    public LinkedList concatenate(LinkedList linkedList) {
        WbDoubleLinkNode head2 = (WbDoubleLinkNode) linkedList.head();

        if (head == null)
            this.head = head2;
        else if (head2 != null)
        {
            head.previous.next = head2;
            head2.previous = head.previous;
        }
        return this;
    }

    @Override
    public WbDoubleLinkNode head() {
        return head;
    }

    @Override
    public String toString() {
        if (head == null)
            return "";
        StringBuilder stringBuilder = new StringBuilder();
        for (WbDoubleLinkNode n = head; n.next != head; n = n.next)
            stringBuilder.append(n.data).append(" ");
        stringBuilder.append(head.previous.data);
        return stringBuilder.toString();
    }

}
