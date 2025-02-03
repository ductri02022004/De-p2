package Example;

public class LinkedList {
    private Node head;

    public LinkedList() {
    }

    public LinkedList(Node head){
        this.head = null;
    }
    public void add(int data){
        Node newNode = new Node(data);
        if(head == null){
            head = newNode;
        }else {
            Node current = head;
            while(current.next != null){
                current = current.next;
            }
            current.next = newNode;
        }
    }
    public void display(){
        if(head == null){
            System.out.println("danh sach rong");
            return;
        }
        Node current = head;
        while(current != null){
            System.out.println(current.data+" ");
            current = current.next;
        }
        System.out.println();
    }
    public void delete(int key){
        if(head == null){
            System.out.println("danh sach rong");
            return;
        }
        if(head.data == key){
            head = head.next;
            return;
        }
        Node current = head;
        Node prev = null;
        while(current!=null && current.data != key){
            prev = current;
            current = current.next;
        }
        if(current == null){
            System.out.println("Khong tim thay vi tri: "+key);
            return;
        }
        prev.next = current.next;
    }
    public Boolean search( int key){
        Node current = head;
        while(current != null){
            if(current.data == key) return true;
            current = current.next;
        }
        return false;
    }
    public void sort(){
        if(head == null || head.next == null){
            return;
        }
        int temp;
        Node current, index;
        for(current = head; current.next != null; current = current.next){
            for(index=current.next;index!=null; index = index){
                if(current.data > index.data){
                    temp = current.data;
                    current.data = index.data;
                    index.data = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.add(10);
        list.add(20);
        list.add(30);
        list.add(40);
        list.add(50);
        System.out.println("Danh sach lien ket: ");
        list.display();
        System.out.println("Xoa node voi gia tri 20: ");
        list.delete(20);
        System.out.println("tim kiem gia tri 20 trong danh sach: "+
                (list.search(20)?"tim thay":"khong tim thay"));
        System.out.println("tim kiem gia tri 40 trong danh sach: "+
                (list.search(40)?"tim thay":"khong tim thay"));
        System.out.println("Sap xep: ");
        list.sort();
        list.display();
    }
}
