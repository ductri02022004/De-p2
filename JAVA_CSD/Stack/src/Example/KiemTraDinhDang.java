package Example;

import java.util.Scanner;
import java.util.Stack;

public class KiemTraDinhDang {
    public static void main(String[] args) {
        do{
            System.out.println("Nhap vao mot chuoi bat ki: ");
            String input = new Scanner(System.in).nextLine();
            System.out.println(isValid(input)?"dung dinh dang":"sai dinh dang");
        }while(true);
    }
    public static boolean isValid(String s){
        Stack<Character> stack = new Stack<>();
        for(char c : s.toCharArray()){
            if(c == '(' || c == '{' || c=='['){
                stack.push(c);
            }else if(c == ')' && !stack.isEmpty() && stack.peek()=='('){
                stack.pop();
            } else if(c == '}' && !stack.isEmpty() && stack.peek()=='{'){
                stack.pop();
            }else if(c == ']' && !stack.isEmpty() && stack.peek()=='['){
                stack.pop();
            }else {
                return false;
            }
        }
        return stack.isEmpty();
    }
}
