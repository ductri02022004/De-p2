//package Problem1;
//
//
//import java.util.Collections;
//import java.util.LinkedList;
//import java.util.Scanner;
//
//
//public class MyLinkedList {
//    static Node head, tail;
//
//    public MyLinkedList() {
//        head=tail=null;
//    }
//    public static boolean isEmpty(){
//        return head == null;
//    }
//    public void addFirst(Product value){
//        Node node = new Node(value);
//        if(isEmpty()){
//            head=tail=node;
//        }
//        else {
//            node.next = head;
//            head = node;
//        }
//    }
//    public static void removeProduct(String id) {
//        int index = 0;
//        if (isEmpty()) return;
//        else {
//            int pos = 0;
//            Node current = head;
//            while (current.next != null) {
//                if ((index - 1) == pos) break;
//                current = current.next;
//                pos++;
//            }
//            if (current.next == null) return;
//            else {
//                if (current.next == tail){
//                    delLastWithNoReturnValue();
//                    return;
//                }
//                else {
//                    Product name = current.next.value;
//                    current.next = current.next.next;
//                    System.out.print("Deleted: ["+name+"]");
//                    return;
//                }
//            }
//        }
//    }
//    public static void delLastWithNoReturnValue(){
//        if(isEmpty()) return;
//        else{
//            Node current = head;
//            while ( current.next!=tail){
//                current=current.next;
//            }
//            Product name = current.next.value;
//            current.next = null;
//            tail = current;
//            System.out.print("Deleted: ["+name+"]");
//        }
//    }
//
//    public static Product searchProduct(String id){
//        if(isEmpty()) return null;
//        else {
//            Node current = head;
//            while(current.next==tail){
//                Product p = current.value;
//                if(current.value.id.equalsIgnoreCase(id)){
//                    return p;
//                }
//            }
//        }
//        return null;
//    }
//    public static LinkedList<Product> listProductsByPriority(){
//        bubbleSort(productLinkedList);
//        return productLinkedList;
//    }
//    public static void bubbleSort(LinkedList<Product> productLinkedList) {
//        int n = productLinkedList.size();
//        for (int i = 0; i < n - 1; i++) {
//            boolean check = false;
//            for (int j = 0; j < n - i - 1; j++) {
//                if (productLinkedList.get(j).priority < productLinkedList.get(j + 1).priority) {
//                    int flag = productLinkedList.get(j).priority;
//                    productLinkedList.get(j).priority=productLinkedList.get(j+1).priority;
//                    productLinkedList.get(j+1).priority=flag;
//                    check = true;
//                }
//            }
//            if (!check) break;
//        }
//    }
//
//    public static void main(String[] args) {
//        productLinkedList.addFirst(new Product("P1","vip",3));
//        productLinkedList.addFirst(new Product("P2","noob",5));
//        productLinkedList.addFirst(new Product("P3","bad",1));
//        productLinkedList.addFirst(new Product("P4","normal",9));
//        productLinkedList.addFirst(new Product("P5","limited",13));
//        productLinkedList.addFirst(new Product("P6","error",23));
//        productLinkedList.addFirst(new Product("P7","good",31));
//        productLinkedList.addFirst(new Product("P9","low",95));
//        productLinkedList.addFirst(new Product("P4","best",55));
//        productLinkedList.addFirst(new Product("P12","high",11));
//        productLinkedList.addFirst(new Product("P20","rarely",52));
//        listProductsByPriority();
//        System.out.println("Enter id for deletion: ");
//        String id = new Scanner(System.in).nextLine();
//        removeProduct(id);
//        listProductsByPriority();
//        System.out.println("Enter id for searching: ");
//        id = new Scanner(System.in).nextLine();
//        searchProduct(id);
//    }
//}
