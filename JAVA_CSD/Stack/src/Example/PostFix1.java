package Example;

import java.util.Scanner;
import java.util.Stack;

public class PostFix1 {
    public static void main(String[] args) {
        System.out.println("Moi nhap bieu thuc: ");
        String exp = new Scanner(System.in).nextLine();
        System.out.println("Result = " + cal(exp));
    }
    public static int cal(String exp){
        Stack<Integer> stack = new Stack<>();
        for(int i=-1; ++i < exp.length();){
            char c = exp.charAt(i);
            if(Character.isDigit(c)){
                stack.push(c - '0');
            }else {
                int val1 = stack.pop();
                int val2 = stack.pop();
                switch (c){
                    case '+' -> stack.push(val2 + val1);
                    case '-' -> stack.push(val2 - val1);
                    case '*' -> stack.push(val2 * val1);
                    case '/' -> stack.push(val2 / val1);
                }
            }
        }
    return stack.pop();
    }
}
