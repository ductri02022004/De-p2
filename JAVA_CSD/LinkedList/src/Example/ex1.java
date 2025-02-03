package Example;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

public class ex1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LinkedList<Integer> linkedList = new LinkedList<>();
        int node;
        System.out.println("Nhap so phan tu: ");
        int n = sc.nextInt();
        System.out.println("Nhap gia tri: ");
        for(int i =-1; ++i<n;){
            System.out.print("Nhap phan tu thu ["+i+"]: ");
            node = sc.nextInt();
            linkedList.add(node);
        }
        Iterator<Integer> iterator = linkedList.iterator();
        while(iterator.hasNext()){
            System.out.print(iterator.next()+"\t");
        }
    }
}
