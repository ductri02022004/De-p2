package problem_1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Product implements Comparable<Product> {
    private String productID;
    private String productDetail;
    private int priotize;

    public Product(String productID, String productDetail, int priotize) {
        this.productID = productID;
        this.productDetail = productDetail;
        this.priotize = priotize;
    }

    public String getProductID() {
        return productID;
    }

    public void setProductID(String productID) {
        this.productID = productID;
    }

    public String getProductDetail() {
        return productDetail;
    }

    public void setProductDetail(String productDetail) {
        this.productDetail = productDetail;
    }

    public int getPriotize() {
        return priotize;
    }

    public void setPriotize(int priotize) {
        this.priotize = priotize;
    }

    @Override
    public String toString() {
        return "productID=" + productID + ", productDetail=" + productDetail + ", priotize=" + priotize;
    }

    @Override
    public int compareTo(Product that) {
        return Integer.compare(that.priotize, this.priotize); // Sort by priority in descending order
    }
}

class Node {
    Node next;
    Product product;

    public Node(Product product) {
        this.next = null;
        this.product = product;
    }
}

class LinkedList {
    private Node head;

    public LinkedList() {
        this.head = null;
    }

    public void addProduct(String id, String description, int priority) {
        Node current = head;
        Node father = null;

        while (current != null && !current.product.getProductID().equals(id)) {
            father = current;
            current = current.next;
        }

        if (current != null) { // Product exists, update it
            current.product.setProductDetail(description);
            current.product.setPriotize(priority);
        } else { // Product does not exist, add it
            Node newNode = new Node(new Product(id, description, priority));
            if (head == null) {
                head = newNode;
            } else {
                father.next = newNode;
            }
        }
    }

    public void display() {
        if (head == null) {
            System.out.println("Empty list");
        } else {
            Node current = head;
            while (current != null) {
                System.out.println(current.product);
                current = current.next;
            }
        }
    }

    public Product searchProduct(String id) {
        Node current = head;

        while (current != null) {
            if (current.product.getProductID().equals(id)) {
                return current.product;
            }
            current = current.next;
        }

        System.out.println("Product not found");
        return null;
    }

    public void removeProduct(String id) {
        head = remove(id, head);
    }

    private Node remove(String productId, Node head) {
        if (head == null) {
            System.out.println("List is empty");
            return null;
        }

        if (head.product.getProductID().equals(productId)) {
            return head.next; // Remove the head
        }

        Node current = head;
        Node previous = null;

        while (current != null && !current.product.getProductID().equals(productId)) {
            previous = current;
            current = current.next;
        }

        if (current == null) {
            System.out.println("Product not found");
            return head;
        }

        previous.next = current.next;
        return head;
    }

    public List<Product> listProductsByPriority() {
        List<Product> products = new ArrayList<>();
        Node current = head;

        while (current != null) {
            products.add(current.product);
            current = current.next;
        }

        Collections.sort(products); // Sort products by priority in descending order
        return products;
    }
}

public class Problem_1 {
    public static void main(String[] args) {
        LinkedList productList = new LinkedList();

        productList.addProduct("101", "John", 1);
        productList.addProduct("102", "Emily", 2);
        productList.addProduct("103", "Michael", 3);

        System.out.println("Displaying all products:");
        productList.display();

        System.out.println("\nSearching for product with ID 102:");
        Product searchedProduct = productList.searchProduct("102");
        if (searchedProduct != null) {
            System.out.println("Found: " + searchedProduct);
        }

        System.out.println("\nRemoving product with ID 101");
        productList.removeProduct("101");

        System.out.println("Displaying all products after removal:");
        productList.display();

        System.out.println("\nUpdating product with ID 103");
        productList.addProduct("103", "Michael Updated", 5);

        System.out.println("Displaying all products after update:");
        productList.display();

        System.out.println("\nListing products by priority:");
        List<Product> sortedProducts = productList.listProductsByPriority();
        for (Product product : sortedProducts) {
            System.out.println(product);
        }
    }
}
