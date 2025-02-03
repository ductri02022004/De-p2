package Example;

import java.util.Scanner;
import java.util.Stack;

public class DaoChuoi {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap chuoi: ");
        String input = sc.nextLine();
        String reversed = reverseString(input);
        System.out.println("Chuoi sau khi dao: "+ reversed);
    }
    public static String reverseString(String s){
        Stack<Character> stack = new Stack<>();
        for(char c : s.toCharArray()){
            stack.push(c);
        }
        StringBuilder reversed = new StringBuilder();
        while (!stack.isEmpty()){
            reversed.append(stack.pop());
        }
        return reversed.toString();
    }
}
