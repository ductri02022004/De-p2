package Example.Node;
public class MyLinkedList {
    Node head, tail;

    public MyLinkedList() {
        head = tail = null;
    }
    public boolean isEmpty(){
        return head == null;
    }
    public void addFirst(int value){
        Node node = new Node(value);
        if(isEmpty()){
            head=tail=node;
        }
        else {
            node.next = head;
            head = node;
        }
    }
    public void addLast(int value){
        Node node = new Node(value);
        if(isEmpty()){
            head=tail=node;
        }else {
            tail.next = node;
            tail = node;
        }
    }
    public void addIndex(int value, int index){
        if(index<0) return;
        if(index == 0 ){
            addFirst(value);
        }else {
            Node current = head;
            int pos = 0;
            while (current != null) {
                if ((index - 1) == pos) break;
                current = current.next;
                pos++;
            }
            if(current == null) return; //index khong hop le
            else {
                Node node = new Node(value);
                if(current.next == null) addLast(value); // add vao cuoi vi tri
                else {
                    node.next = current.next;
                    current.next = node;
                }
            }
        }
    }

    // delete khong co gia tri tra ve
    public void delFirstNoReturnValue(){
        if(isEmpty()) return;
        else {
            head = head.next;
        }
    }
    public void delLastWithNoReturnValue(){
        if(isEmpty()) return;
        else{
            Node current = head;
            while ( current.next!=tail){
                current=current.next;
            }
            current.next = null;
            tail = current;
        }
    }
    public void delIndexWithNoReturnValue(int index) {
        if (isEmpty()) return;
        else {
            int pos = 0;
            Node current = head;
            while (current.next != null) {
                if ((index - 1) == pos) break;
                current = current.next;
                pos++;
            }
            if (current.next == null) return;
            else {
                if (current.next == tail){
                    delLastWithNoReturnValue();
                    return;
                }
                else {
                    current.next = current.next.next;
                    return;
                }
            }
        }
    }

    // delete co gia tri tra ve
    public int delFirstWithReturnValue(){
        int value = -1;
        if(isEmpty()) return value;
        else {
            head = head.next;
            value=head.value;
        }
        return value;
    }

    public int delLastWithReturnValue(){
        int value = -1;
        if(isEmpty()) return value;
        if(head==tail){
            value= tail.value;
            head = null;
            tail = null;
            return value;
        }
        Node current = head;
//      while(current.next!=tail){
        while(current.next.next!=null){
            current = current.next; // di tim vi tri truoc tail hay tim vi tri cha cua tail
        }
//      int value = current.next.value;
        value = tail.value;
        current.next = null;
        tail = current;
        return value;
    }
    public int delIndexWithReturnValue(int index){
        int value = -1; // nếu value la gia tri khac thi sex null
        if(index<0) return value;
        else if(index == 0) {
            value = delFirstWithReturnValue();
        }
        else {
            Node current = head;
            int pos = 0;
            while(current.next != null){
                if((index-1) == pos) break;
                current = current.next;
                pos++;
            }
            if(current.next == null) return value; //index > size
            else if(current.next == tail) return delLastWithReturnValue();
            else { // 0<index<size-1
                value = current.next.value;
                current.next = current.next.next;
            }
        }
        return value;
    }
    public int delIndex(int index){
        if(index<0) return -1;
        else if (index==0) return delFirstWithReturnValue();
        Node current = findIndexFatherNode(index);
        if(current==null) return -1;
        if(current == tail) return delLastWithReturnValue();
        int value = current.next.value;
        current.next = current.next.next;
        return value;
    }
    public Node findIndexFatherNode(int index){
        if(index<=0) return null;
        Node current = head;
        int pos = 0;
        while (current != null){
            if(index-1 == pos) break;
            current = current.next;
            pos++;
        }
        if(current == null) return null;
        return current;
    }
    public Node findFather (int value){
        // 1) tim va tra ve node cha cua node co gia tri dau tien la value
        // 2) tim va tra ve node cha cua node co gia tri cuoi cung la value

        return null;
    }
    Node findNode(int value){

        // 1) tim va tra ve node dau tien co gia tri la value
        // 2) tim va tra ve node cuoi cung co gia tri la value

        return null;
    }
    public void display(){
        Node current = head;
        while(current!=null){
            System.out.print(current.value +", ");
            current = current.next;
            if(current == tail){
                System.out.println(current.value);
                break;
            }
        }
    }
    public void sort() {
        if (isEmpty() || head == tail) return;
        for (Node i = head; i.next != null; i = i.next) {
            for (Node j = i.next; j != null; j = j.next) {
                if (i.value > j.value) {
                    int temp = i.value;
                    i.value = j.value;
                    j.value = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.addFirst(1);
        myLinkedList.addFirst(2);
        myLinkedList.addFirst(3);
        myLinkedList.addFirst(4);
        myLinkedList.addFirst(5);
        myLinkedList.addFirst(6);
        myLinkedList.display();
        myLinkedList.addLast(10);
        myLinkedList.addLast(25);
        myLinkedList.addLast(14);
        myLinkedList.display();
        myLinkedList.addIndex(30,2);
        myLinkedList.addIndex(100,0);
        myLinkedList.addIndex(99,3);
        myLinkedList.display();
        System.out.println(myLinkedList.findIndexFatherNode(11).value);
//        System.out.println("Del phan tu FIRST khong co tham so: ");
//        myLinkedList.delFirstNoReturnValue();
//        myLinkedList.display();
//        System.out.println("Del phan tu LAST khong co tham so: ");
//        myLinkedList.delLastWithNoReturnValue();
//        myLinkedList.display();
//        System.out.println("Del phan tu INDEX khong co tham so: ");
//        myLinkedList.delIndexWithNoReturnValue(1);
//        myLinkedList.display();
//
//
//
//        System.out.println("Phan tu LAST: " + myLinkedList.delLastWithReturnValue());
//        myLinkedList.display();
//
//
//        MyLinkedList myLinkedListCheckNull = new MyLinkedList(); // check gia tri sai
//        System.out.println("Phan tu LAST: " + myLinkedListCheckNull.delLastWithReturnValue());

    }
}
