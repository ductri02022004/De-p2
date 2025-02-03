package binarySearchTree.queueForBreadth_First;

import binarySearchTree.Node;

public class MyQueue {
    NodeQueue head, tail;
    public MyQueue(){
        head=tail=null;
    }
    public boolean isEmpty(){
        return head == null;
    }
    public void EnQueue(Node p){
        NodeQueue node = new NodeQueue(p);
        if(isEmpty()) head=tail=node;
        else {
            tail.next = node;
            tail = node;
        }
    }
    public Node Dequeue(){
        if(isEmpty()) return null;
        Node value = head.value;
        head = head.next;
        return value;
    }
}
