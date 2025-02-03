package Problem1;

public class Product {
    String id;
    String description;
    int priority;

    public Product(String id, String description, int priority) {
        this.id = id;
        this.description = description;
        this.priority = priority;
    }

    public Product() {
    }

    @Override
    public String toString() {
        return "ID: "+id+", description: "+description+", priority: "+priority;
    }
}
