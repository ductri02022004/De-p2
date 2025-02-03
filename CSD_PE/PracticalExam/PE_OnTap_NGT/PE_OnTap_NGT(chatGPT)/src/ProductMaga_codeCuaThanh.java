/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PEontap;


import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;



class Product {
    private String id;
    private String description;
    private int priority;

    public Product(String id, String description, int priority) {
        this.id = id;
        this.description = description;
        this.priority = priority;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    @Override
    public String toString() {
        return "Product{" + "id=" + id + ", description=" + description + ", priority=" + priority + '}';
    }

}

class ProductMaga {
    private List<Product> products;

    public ProductMaga() {
        products = new ArrayList<>();
    }

    public void addProduct(String id, String description, int priority) {
        for (Product product : products) {
            if (product.getId().equals(id)) {
                product.setDescription(description);
                product.setPriority(priority);
                return;
            }
        }
        products.add(new Product(id, description, priority));
    }

    public void removeProduct(String id) {
        products.removeIf(product -> product.getId().equals(id));
    }

    public Product searchProduct(String id) {
        for (Product product : products) {
            if (product.getId().equals(id)) {
                return product;
            }
        }
        return null;
    }

    public List<Product> listProductsByPriority() {
        products.sort(Comparator.comparingInt(Product::getPriority).reversed());
        return products;
    }

    public static void main(String[] args) {
        ProductMaga pms = new ProductMaga();
        pms.addProduct("001", "Product 1", 3);
        pms.addProduct("002", "Product 2", 5);
        pms.addProduct("003", "Product 3", 1);

        System.out.println("List of products by priority:");
        for (Product product : pms.listProductsByPriority()) {
            System.out.println(product);
        }

        System.out.println("\nSearch for product with id '002':");
        System.out.println(pms.searchProduct("002"));

        pms.removeProduct("002");
        System.out.println("\nList of products after removing product with id '002':");
        for (Product product : pms.listProductsByPriority()) {
            System.out.println(product);
        }
    }
}

////////////////////////////////////////////////////////////////////////////////////////////////////////////////


class Car implements Comparable<Car> {
    int id;
    String name;
    String manufacturer;
    int unitsSold;
    double customerRating;
    String country;

    public Car(int id, String name, String manufacturer, int unitsSold, double customerRating, String country) {
        this.id = id;
        this.name = name;
        this.manufacturer = manufacturer;
        this.unitsSold = unitsSold;
        this.customerRating = customerRating;
        this.country = country;
    }

    @Override
    public int compareTo(Car other) {
        return this.name.compareTo(other.name);
    }

    @Override
    public String toString() {
        return "Car id  " + id + ",  name " + name + ",   manufacturer " + manufacturer + ",  unitsSold " + unitsSold + ",  customerRating " + customerRating + ",  country " + country;
    }

    
}

class BST {
    private class Node {
        Car data;
        Node left, right;

        Node(Car data) {
            this.data = data;
        }
    }

    private Node root;

    public void insert(Car car) {
        root = insertRec(root, car);
    }

    private Node insertRec(Node root, Car car) {
        if (root == null) {
            root = new Node(car);
            return root;
        }
        if (car.compareTo(root.data) < 0)
            root.left = insertRec(root.left, car);
        else if (car.compareTo(root.data) > 0)
            root.right = insertRec(root.right, car);

        return root;
    }

    public void delete(String name) {
        root = deleteRec(root, name);
    }

    private Node deleteRec(Node root, String name) {
        if (root == null)
            return root;

        if (name.compareTo(root.data.name) < 0)
            root.left = deleteRec(root.left, name);
        else if (name.compareTo(root.data.name) > 0)
            root.right = deleteRec(root.right, name);
        else {
            if (root.left == null)
                return root.right;
            else if (root.right == null)
                return root.left;

            root.data = minValue(root.right);
            root.right = deleteRec(root.right, root.data.name);
        }

        return root;
    }

    private Car minValue(Node root) {
        Car minv = root.data;
        while (root.left != null) {
            minv = root.left.data;
            root = root.left;
        }
        return minv;
    }

    public Car search(String name) {
        return searchRec(root, name);
    }

    private Car searchRec(Node root, String name) {
        if (root == null || root.data.name.equals(name))
            return root != null ? root.data : null;

        if (root.data.name.compareTo(name) > 0)
            return searchRec(root.left, name);

        return searchRec(root.right, name);
    }

    public List<Car> inOrder() {
        List<Car> cars = new ArrayList<>();
        inOrderRec(root, cars);
        return cars;
    }

    private void inOrderRec(Node root, List<Car> cars) {
        if (root != null) {
            inOrderRec(root.left, cars);
            cars.add(root.data);
            inOrderRec(root.right, cars);
        }
    }

    public List<Car> postOrder() {
        List<Car> cars = new ArrayList<>();
        postOrderRec(root, cars);
        return cars;
    }

    private void postOrderRec(Node root, List<Car> cars) {
        if (root != null) {
            postOrderRec(root.left, cars);
            postOrderRec(root.right, cars);
            cars.add(root.data);
        }
    }

    public void buildFromTraversals(List<Car> inOrder, List<Car> postOrder) {
        root = buildTree(inOrder, postOrder, 0, inOrder.size() - 1, new int[]{postOrder.size() - 1});
    }

    private Node buildTree(List<Car> inOrder, List<Car> postOrder, int inStart, int inEnd, int[] postIndex) {
        if (inStart > inEnd)
            return null;

        Car rootCar = postOrder.get(postIndex[0]--);
        Node node = new Node(rootCar);

        if (inStart == inEnd)
            return node;

        int inIndex = inOrder.indexOf(rootCar);

        node.right = buildTree(inOrder, postOrder, inIndex + 1, inEnd, postIndex);
        node.left = buildTree(inOrder, postOrder, inStart, inIndex - 1, postIndex);

        return node;
    }
}

class CarMaga {
    public static void quickSort(Car[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    private static int partition(Car[] arr, int low, int high) {
        int pivot = arr[high].unitsSold;
        int i = (low - 1);
        for (int j = low; j < high; j++) {
            if (arr[j].unitsSold > pivot) {
                i++;
                Car temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        Car temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }

    public static void main(String[] args) {
        Car[] cars = {
                new Car(1, "Model S", "Tesla", 5000, 4.8, "USA"),
                new Car(2, "Camry", "Toyota", 7000, 4.5, "Japan"),
                new Car(3, "3 Series", "BMW", 4500, 4.6, "Germany"),
                new Car(4, "Civic", "Honda", 8000, 4.4, "Japan"),
                new Car(5, "A4", "Audi", 4200, 4.7, "Germany"),
                new Car(6, "F-150", "Ford", 9000, 4.3, "USA"),
                new Car(7, "Altima", "Nissan", 6500, 4.2, "Japan"),
                new Car(8, "Golf", "Volkswagen", 6000, 4.5, "Germany"),
                new Car(9, "Model 3", "Tesla", 7500, 4.9, "USA"),
                new Car(10, "Accord", "Honda", 7000, 4.6, "Japan")
        };

        BST bst = new BST();
        for (Car car : cars) {
            bst.insert(car);
        }

        System.out.println("BST In-Order Traversal:");
        List<Car> inOrderList = bst.inOrder();
        inOrderList.forEach(System.out::println);

        System.out.println("\nBST Post-Order Traversal:");
        List<Car> postOrderList = bst.postOrder();
        postOrderList.forEach(System.out::println);

        bst.delete("Camry");
        System.out.println("\nBST In-Order Traversal after deleting 'Camry':");
        inOrderList = bst.inOrder();
        inOrderList.forEach(System.out::println);

        Car searchResult = bst.search("Model 3");
        System.out.println("\nSearch result for 'Model 3':");
        System.out.println(searchResult);

        quickSort(cars, 0, cars.length - 1);
        System.out.println("\nCars sorted by units sold:");
        for (Car car : cars) {
            System.out.println(car);
        }

        Car highestUnitsSold = cars[0];
        System.out.println("\nCar with highest units sold:");
        System.out.println(highestUnitsSold);

        BST newBst = new BST();
        newBst.buildFromTraversals(inOrderList, postOrderList);
        System.out.println("\nNew BST In-Order Traversal from traversals:");
        List<Car> newInOrderList = newBst.inOrder();
        newInOrderList.forEach(System.out::println);
    }
}
