package Problem1;

public class Node {
    Node next;
    Product value;

    public Node() {
    }

    public Node(Node next, Product value) {
        this.next = next;
        this.value = value;
    }

    public Node(Product value) {
        this.value = value;
        next=null;
    }
}
