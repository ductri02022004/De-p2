package Example;

import java.util.Scanner;
import java.util.Stack;

public class Palindrome_ChuoiDoiXung {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap chuoi: ");
        String input = sc.nextLine();
        boolean isPalindrome = checkPalondrome(input);
        System.out.println("Chuoi co phai la palindrome ? " + isPalindrome);
    }
    public static boolean checkPalondrome(String s){
        Stack<Character> stack = new Stack<>();
        int n = s.length();
        for(int i=-1;++i<n;){
            stack.push(s.charAt(i));
        }
        int start = (n%2==0) ? n/2 : n/2+1;
        for(int i=start;i<n;i++){
            if(s.charAt(i) != stack.pop()){
                return false;
            }
        }
        return true;
    }
}
