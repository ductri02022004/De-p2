package Stack;

import java.util.Scanner;
import java.util.Stack;

public class Test {
    public static void main(String[] args) {
        Stack<String> stackChuoi = new Stack<String>();
        // push() => đưa giá trị vào stack
        // pop() => lấy giá trị ra, xóa khỏi stack
        // peek() => lấy giá trị ra, nhưng k xóa khỏi stack
        // clear() => xóa tất cả các phần tử trong stack
        // contain() => xác định giá trị có tồn tại trong stack hay không ?
        // size() => độ dài của stack

        //Ví dụ: đảo ngược chuỗi
        String s = "toi la con heo";
        for(int i = 0 ; i<s.length();i++){
            stackChuoi.push(s.charAt(i)+"");
        }
        System.out.println("Chuỗi đảo ngược: ");
        for(int i=0; i<s.length();i++){
            System.out.print(stackChuoi.pop());
        }
        System.out.println();
        // chuyển từ hệ thâp phân sàng hệ nhị phân
        Stack<Integer> stackSoDu = new Stack<>();
        System.out.println("Nhập số nguyên dương: " );
        int x =Integer.parseInt(new Scanner(System.in).nextLine());

        while (x>0){
            int remain = x%2;
            stackSoDu.push(remain);
            x/=2;
        }
        System.out.println("Số nhị phân là: ");
        int n = stackSoDu.size();
        for(int i=0; i<n;i++){
            System.out.print(stackSoDu.pop()+ " ");
        }
    }
}
