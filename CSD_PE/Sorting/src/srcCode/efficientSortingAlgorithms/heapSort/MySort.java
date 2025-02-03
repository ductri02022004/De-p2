package srcCode.efficientSortingAlgorithms.heapSort;

import java.util.Random;
import java.util.Scanner;

public class MySort {
    public static void main(String[] args) {
        Random rd = new Random();
        Scanner sc = new Scanner(System.in);
        System.out.print("Input size: ");
        int n = Integer.parseInt(sc.nextLine());
        int[] a = new int[n];
        HeapSort hs = new HeapSort();

        for(int i=0; i<a.length;i++){
            a[i] = rd.nextInt(100) + 1;
        }
        System.out.println("Unsorted: ");
        display(a);
        System.out.println("Sorted: ");
        hs.heapSort(a);
        display(a);
        System.out.println("Check: " + check(a));
    }
    private static void display(int [] a){
        for(int i=0;i<a.length;i++){
            System.out.print(a[i]+", ");
            if(i==a.length-1){
                System.out.println(a[i]);
                break;
            }
        }
    }
    private static boolean check(int [] a){
        for(int i=1;i<a.length;i++){
            if(a[i]<a[i-1]) return false;
        }
        return true;
    }
}