package binarySearchTree;

public class Node {
    Car info;
    Node left, right;

    public Node() {
    }

    public Node(Car info) {
        this.info = info;
        this.left = null;
        this.right = null;
    }
    public Node(String name, int price){
        info = new Car(name,price);
        left = right = null;
    }
}
