package Example.Node;

public class Node {
    public int value;
    public Node next;

    public Node() {
    }
    public Node(int value, Node next) {
        this.value = value;
        this.next = next;
    }

    public Node(int value) {
        this.value = value;
        next = null;
    }
}
