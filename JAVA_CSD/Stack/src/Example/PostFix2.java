package Example;

import java.util.Stack;

public class PostFix2 {
    public static String cal(String infix){
        StringBuilder postfix = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        for(char c : infix.toCharArray()){
            if(Character.isLetterOrDigit(c)){
                postfix.append(c);
            } else if (c == '(') {
                stack.push(c);
            } else if (c == ')') {
                while(!stack.isEmpty() && stack.peek() != '('){
                    postfix.append(stack.pop());
                }
                stack.pop();
            }else {
                while (!stack.isEmpty() && )
            }
        }
    }
    public static int precedence(char ep){
        switch (ep){
            case '+' :
            case '-' :{
                return 1;
            }
            case '*' :
            case  '/':return 2;
        }
    }
}
