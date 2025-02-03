package problem_2;

import java.util.*;

class Car implements Comparable<Car> {
    private String id, name, manufacturer, country;
    private int unitsSold, customerRating;

    public Car(String id, String name, String manufacturer, int unitsSold, double customerRating, String country) {
        this.id = id;
        this.name = name;
        this.manufacturer = manufacturer;
        this.country = country;
        this.unitsSold = unitsSold;
        this.customerRating = (int) customerRating;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getUnitsSold() {
        return unitsSold;
    }

    public void setUnitsSold(int unitsSold) {
        this.unitsSold = unitsSold;
    }

    public int getCustomerRating() {
        return customerRating;
    }

    public void setCustomerRating(int customerRating) {
        this.customerRating = customerRating;
    }

    @Override
    public int compareTo(Car o) {
        return this.name.compareTo(o.name);
    }

    @Override
    public String toString() {
        return"id='" + id + ", name='" + name + ", manufacturer='" + manufacturer + ", country='" + country + ", unitsSold=" + unitsSold + ", customerRating=" + customerRating;
    }
}

class Node {
    Node left, right;
    Car car;

    public Node(Car car) {
        this.left = null;
        this.right = null;
        this.car = car;
    }
}

class BinarySearchTree {
    Node root;

    public BinarySearchTree() {
        this.root = null;
    }

    public BinarySearchTree(Node root) {
        this.root = root;
    }

    public void insertCar(Car car) {
        root = insert(root, car);
    }

    private Node insert(Node root, Car car) {
        if (root == null) {
            root = new Node(car);
            return root;
        }

        if (car.getName().compareTo(root.car.getName()) < 0) {
            root.left = insert(root.left, car);
        } else if (car.getName().compareTo(root.car.getName()) > 0) {
            root.right = insert(root.right, car);
        }
        return root;
    }

    public void delete(String id) {
        root = deleteRec(root, id);
    }

    private Node deleteRec(Node root, String id) {
        if (root == null) {
            return null;
        }

        int cmp = id.compareTo(root.car.getId());

        if (cmp < 0) {
            root.left = deleteRec(root.left, id);
        } else if (cmp > 0) {
            root.right = deleteRec(root.right, id);
        } else {
            // Node to be deleted found

            // Node with only one child or no child
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }

            // Node with two children: Get the in-order successor (smallest in the right subtree)
            root.car = minValue(root.right);

            // Delete the in-order successor
            root.right = deleteRec(root.right, root.car.getId());
        }

        return root;
    }

    private Car minValue(Node root) {
        Car minValue = root.car;
        while (root.left != null) {
            minValue = root.left.car;
            root = root.left;
        }
        return minValue;
    }

    public Car search(String name) {
        return searchRec(root, name);
    }

    private Car searchRec(Node root, String name) {
        if (root == null || root.car.getName().equals(name))
            return root != null ? root.car : null;

        if (name.compareTo(root.car.getName()) < 0)
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
            cars.add(root.car);
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
            cars.add(root.car);
        }
    }

    public static BinarySearchTree constructFromTraversals(List<Car> inOrder, List<Car> postOrder) {
        if (inOrder.size() != postOrder.size() || inOrder.size() == 0) {
            return null;
        }
        return new BinarySearchTree(constructFromTraversalsRec(inOrder, postOrder, 0, inOrder.size() - 1, new int[]{postOrder.size() - 1}));
    }

    private static Node constructFromTraversalsRec(List<Car> inOrder, List<Car> postOrder, int inStart, int inEnd, int[] postIndex) {
        if (inStart > inEnd)
            return null;

        Car car = postOrder.get(postIndex[0]--);
        Node node = new Node(car);

        if (inStart == inEnd)
            return node;

        int inIndex = inOrder.indexOf(car);
        node.right = constructFromTraversalsRec(inOrder, postOrder, inIndex + 1, inEnd, postIndex);
        node.left = constructFromTraversalsRec(inOrder, postOrder, inStart, inIndex - 1, postIndex);

        return node;
    }
}

class QuickSort {
    public static void quickSort(List<Car> cars) {
        quickSortRec(cars, 0, cars.size() - 1);
    }

    private static void quickSortRec(List<Car> cars, int low, int high) {
        if (low < high) {
            int pi = partition(cars, low, high);
            quickSortRec(cars, low, pi - 1);
            quickSortRec(cars, pi + 1, high);
        }
    }

    private static int partition(List<Car> cars, int low, int high) {
        Car pivot = cars.get(high);
        int i = (low - 1);

        for (int j = low; j < high; j++) {
            if (cars.get(j).getUnitsSold() > pivot.getUnitsSold()) {
                i++;
                Collections.swap(cars, i, j);
            }
        }

        Collections.swap(cars, i + 1, high);
        return i + 1;
    }
}

public class Problem_2 {
    public static void main(String[] args) {
        List<Car> carList = Arrays.asList(
                new Car("1", "Model S", "Tesla", 5000, 4.8, "USA"),
                new Car("2", "Camry", "Toyota", 7000, 4.5, "Japan"),
                new Car("3", "3 Series", "BMW", 4500, 4.6, "Germany"),
                new Car("4", "Civic", "Honda", 8000, 4.4, "Japan"),
                new Car("5", "A4", "Audi", 4200, 4.7, "Germany"),
                new Car("6", "F-150", "Ford", 9000, 4.3, "USA"),
                new Car("7", "Altima", "Nissan", 6500, 4.2, "Japan"),
                new Car("8", "Golf", "Volkswagen", 6000, 4.5, "Germany"),
                new Car("9", "Model 3", "Tesla", 7500, 4.9, "USA"),
                new Car("10", "Accord", "Honda", 7000, 4.6, "Japan")
        );

        BinarySearchTree bst = new BinarySearchTree();
        for (Car car : carList) {
            bst.insertCar(car);
        }

        System.out.println("BST In-order Traversal:");
        List<Car> inOrderList = bst.inOrder();
        inOrderList.forEach(System.out::println);

        System.out.println("\nBST Post-order Traversal:");
        List<Car> postOrderList = bst.postOrder();
        postOrderList.forEach(System.out::println);

        System.out.println("\nSearch for 'Camry':");
        Car searchResult = bst.search("Camry");
        System.out.println(searchResult);

        System.out.println("\nDelete 'Civic':");
        bst.delete("4");
        List<Car> inOrderAfterDeletion = bst.inOrder();
        inOrderAfterDeletion.forEach(System.out::println);

        System.out.println("\nQuick Sort by Units Sold:");
        List<Car> carsForSorting = new ArrayList<>(carList);
        QuickSort.quickSort(carsForSorting);
        carsForSorting.forEach(System.out::println);

        System.out.println("\nReconstruct BST from In-order and Post-order Traversals:");
        BinarySearchTree reconstructedBST = BinarySearchTree.constructFromTraversals(inOrderList, postOrderList);
        List<Car> reconstructedInOrder = reconstructedBST.inOrder();
        reconstructedInOrder.forEach(System.out::println);
    }
}
