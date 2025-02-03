package Example;

import java.util.Stack;

public class CuPhapStack {
    public static void main(String[] args) {
        Stack<String> animals = new Stack<>();
        animals.push("dog");
        animals.push("horse");
        animals.push(("cat"));
        //cat
        //horse
        //dog
        System.out.println("Initial stack: "+animals);
        String element = animals.pop();// loại bỏ khỏi đỉnh stack và lưu khỏi nơi khác
        System.out.println("Removed element: "+element);
        String element1 = animals.peek();
        System.out.println("Element at top: "+element1);
        int position = animals.search("horse");
        System.out.println("Position of horse: "+position);
        animals.clear();
        System.out.println("Is this empty? "+animals.isEmpty());
    }
}
