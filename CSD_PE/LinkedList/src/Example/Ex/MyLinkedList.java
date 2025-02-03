package Example.Ex;

public class MyLinkedList {
    Node head, tail;

    public MyLinkedList() {
        head=tail=null;
    }
    public boolean isEmpty(){
        return head == null;
    }
    public boolean checkPrime(int value){
        if(value<2){
            return false;
        }
        for(int i=2; i<=value/2;i++){
            if(value%i == 0){
                return false;
            }
        }
        return true;
    }
    public void addFirst(int value){
        if(!checkPrime(value)){
            return;
        }
        Node node = new Node(value);
        if(isEmpty()){
            head=tail=node;
        }
        else{
            node.next = head;
            head = node;
        }
    }
    public void addIndex(int value, int index){
        checkPrime(value);
        if(index<0) return;
        if (index == 0) {
            addFirst(value);
        }else{
            Node current = head;
            int pos = 0;
            while(current.next != null){
                if((index-1) == pos ) break;
                current = current.next;
                pos++;
            }
            if(current == null) return;
            else {
                Node node = new Node(value);
                node.next = current.next;
                current.next = node;
            }
        }
    }
    public void display(){
        Node current = head;
        while(current!=null){
            System.out.print(current.value + ", ");
            current=current.next;
            if(current == tail){
                System.out.println(current.value);
                break;
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
        myLinkedList.addFirst(10);
        myLinkedList.addFirst(15);
        myLinkedList.addFirst(21);
        myLinkedList.addFirst(-1);
        myLinkedList.display();
        myLinkedList.addIndex(23,0);
        myLinkedList.addIndex(41,1);
        myLinkedList.addIndex(23,1);
        myLinkedList.addIndex(21,0);
        myLinkedList.addIndex(25,2);
        myLinkedList.addIndex(99,2);
        myLinkedList.addIndex(11,3);
        myLinkedList.display();

    }
}
