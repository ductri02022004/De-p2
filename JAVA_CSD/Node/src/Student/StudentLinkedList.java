package Student;

import java.util.Scanner;

public class StudentLinkedList {
    private Node head;
    public StudentLinkedList(){
        this.head=null;
    }
    public void add(Student data){
        Node newNode = new Node(data);
        if(head == null) {
            head = newNode;
        }else {
            Node current = head;
            while (current.next != null){
                current = current.next;
            }
            current.next = newNode;
        }
    }
    public void display(){
        if(head==null){
            System.out.println("danh sach rong");
            return;
        }
        Node current = head;
        while (current != null){
            System.out.println(current.data);
            current = current.next;
        }
    }
    public void sort(){
        if(head == null || head.next == null){
            return;
        }
        Node current, index ;
        Student temp;
        for(current = head; current.next != null; current = current.next){
            for(index = current.next; index != null; index = index.next){
                if(current.data.id > index.data.id){
                    temp = current.data;
                    current.data = index.data;
                    index.data = temp;
                }
            }
        }
    }
    public void delete(int id){
        if(head == null){
            System.out.println("danh sach rong");
            return;
        }
        if(head.data.id == id){
            head = head.next;
            return;
        }
        Node current = head;
        Node prev = null;
        while(current != null && current.data.id != id){
            prev = current;
            current = current.next;
        }
        if(current == null){
            System.out.println("khong tim thay sinh vien voi ID: "+id);
            return;
        }
        prev.next = current.next;
    }
    public static void main(String[] args) {
        StudentLinkedList list = new StudentLinkedList();
        list.add(new Student(3, "Nguyen Van A"));
        list.add(new Student(10, "Le Thi B"));
        list.add(new Student(7, "Tran Van C"));
        System.out.println("Danh sach sinh vien ban dau: ");
        list.display();
        System.out.println("Danh sach sinh vien sau khi sap xep theo ma: ");
        list.sort();
        list.display();
        System.out.println("Danh sach sinh vien sau khi xoa sinh vien id 7: ");
        list.delete(7);
        list.display();
    }
}