import java.io.*;
import java.util.*;

class Country implements Comparable<Country>{ //cau 1
    private String countryCode;
    private int rank;
    private String name;
    private double gdp;
    public Country(String countryCode, int rank, String name, double gdp) {
        this.countryCode = countryCode;
        this.rank = rank;
        this.name = name;
        this.gdp = gdp;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public int getRank() {
        return rank;
    }

    public String getName() {
        return name;
    }

    public double getGdp() {
        return gdp;
    }

    @Override
    public String toString() {
        return "Country{" +
                "countryCode='" + countryCode + '\'' +
                ", rank=" + rank +
                ", name='" + name + '\'' +
                ", gdp=" + gdp +
                '}';
    }

    @Override
    public int compareTo(Country o) {
        return this.name.compareTo(o.name);
    }
}
class QuickSort{
    public static void quickSort(Country[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }
    private static int partition(Country[] arr, int low, int high) {
        Country pivot = arr[high];
        int i = (low - 1);
        for (int j = low; j < high; j++) {
            if (arr[j].compareTo(pivot) <= 0) {
                i++;
                Country temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        Country temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;
        return i + 1;
    }
}
class AVLTree{
    private class Node {
        Country country;
        Node left, right;
        int height;

        Node(Country c) {
            country = c;
            height = 1;
        }
    }
    private Node root;
    public void insert(Country country) {
        root = insert(root, country);
    }
    private Node insert(Node node, Country country){
        if (node == null) {
            return new Node(country);
        }

        if (country.compareTo(node.country) < 0) {
            node.left = insert(node.left, country);
        } else if (country.compareTo(node.country) > 0) {
            node.right = insert(node.right, country);
        } else{
            return node;
        }
        node.height = 1 + Math.max(height(node.left), height(node.right));
        return balance(node);
    }
    private Node balance(Node node){
        int balance = getBalance(node);

        if (balance > 1) {
            if (getBalance(node.left) < 0) {
                node.left = leftRotate(node.left);
            }
            return rightRotate(node);
        }

        if (balance < -1) {
            if (getBalance(node.right) > 0) {
                node.right = rightRotate(node.right);
            }
            return leftRotate(node);
        }

        return node;
    }
    private Node leftRotate(Node y) {
        Node x = y.right;
        Node T2 = x.left;

        x.left = y;
        y.right = T2;

        y.height = Math.max(height(y.left), height(y.right)) + 1;
        x.height = Math.max(height(x.left), height(x.right)) + 1;

        return x;
    }

    private Node rightRotate(Node y) {
        Node x = y.left;
        Node T2 = x.right;

        x.right = y;
        y.left = T2;

        y.height = Math.max(height(y.left), height(y.right)) + 1;
        x.height = Math.max(height(x.left), height(x.right)) + 1;

        return x;
    }
    private int height(Node node) {
        return node == null ? 0 : node.height;
    }

    private int getBalance(Node node) {
        return node == null ? 0 : height(node.left) - height(node.right);
    }

    public int countCountryNamesStartingWith(char letter) {
        return countCountryNamesStartingWith(root, letter);
    }

    private int countCountryNamesStartingWith(Node node, char letter) { // A
        if (node == null) return 0;
        int count = 0;
        if (node.country.getName().charAt(0) == letter) count++;
        count += countCountryNamesStartingWith(node.left, letter);
        count += countCountryNamesStartingWith(node.right, letter);
        return count;
    }
}
public class Main {
    public static List<Country> readCountriesFromCSV(String fileName){
        List<Country> countries = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))){
            String line = "";
            while ((line = br.readLine()) != null){
                String[] values = line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)");
                //(?=...): Đây là positive lookahead, một cách để kiểm tra xem có một điều kiện nhất định đúng sau dấu phẩy hay không mà không đưa điều kiện đó vào kết quả của việc phân tách.
                //(?:...): Đây là một non-capturing group, tức là không lưu trữ giá trị của nó trong kết quả của việc phân tách.
                //[^\"]*: Đối với phần này, [^\"] đại diện cho bất kỳ ký tự nào ngoại trừ dấu ngoặc kép " và * đại diện cho việc xuất hiện của một hoặc nhiều ký tự đó.
                //\"[^\"]*\": Đây là một cặp dấu ngoặc kép bao quanh ký tự ngoại trừ dấu ngoặc kép " có thể xuất hiện bên trong nó.
                //[^\"]*(?:\"[^\"]*\")*[^\"]*$: Phần này tương tự như việc kiểm tra số lẻ của dấu ngoặc kép để bảo đảm rằng các dấu phẩy trong cặp dấu ngoặc kép không bị phân tách.
                String countryCode = values[0];
                int rank = Integer.parseInt(values[1]);
                String name = values[3].replace("\"", "");
                double gdp = Double.parseDouble(values[4].replace("\"", "").replace(",", ""));
                countries.add(new Country(countryCode, rank, name, gdp));
            }
        }catch (IOException e){
            e.printStackTrace();
        }
        return countries;
    }
    public static void main(String[] args) {
        List<Country> countryList = readCountriesFromCSV("GDP2022.csv");
        Country[] countries = countryList.toArray(new Country[0]);
        QuickSort.quickSort(countries, 0, countries.length - 1); //cau2
        System.out.println("Countries after Quick Sort:");
        for (Country country : countries) {
            System.out.println(country);
        }
        AVLTree avlTree = new AVLTree(); //cau 3
        for (Country country: countries) {
            avlTree.insert(country);
        }
        int count = avlTree.countCountryNamesStartingWith('A'); //cau 4
        System.out.println("Number of countries starting with 'A': " + count);
    }
}
