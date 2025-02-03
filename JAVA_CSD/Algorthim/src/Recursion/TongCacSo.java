package Recursion;

import java.util.Scanner;

public class TongCacSo {
    public static int tinhTong( int a){
        if(a==0){
            return 1;
        }return a + tinhTong(a-1);
    }

    public static void main(String[] args) {
        System.out.println("Nhap so");
        int a = new Scanner(System.in).nextInt();
        System.out.println("Ket qua: " +tinhTong(a));    }
}
