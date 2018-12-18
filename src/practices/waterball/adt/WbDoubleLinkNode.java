package practices.waterball.adt;

public class WbDoubleLinkNode {
    public int data;
    public WbDoubleLinkNode next;
    public WbDoubleLinkNode previous;

    public WbDoubleLinkNode(int data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return String.valueOf(data);
    }
}
