package Queue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Test {
    public static void main(String[] args) {
        // add(): thêm vào queue và nếu vượt quá số lượng thì nó sẽ đẩy cái đầu tiên ra ngoài
        // offer(): thêm vào queue và nếu vượt quá số lượng thì nó sẽ báo lỗi
        // element(): lấy top
        // peek(): lấy top nhưng không xóa khỏi stack
        // remove(): xóa top
        // poll(): lấy top và xóa khỏi stack


        Queue<String> danhSachSV = new LinkedList<String>();
        danhSachSV.offer("Nguyen Van A");
        danhSachSV.offer("Nguyen Van B");
        danhSachSV.offer("Nguyen Van C");
        danhSachSV.offer("Nguyen Van D");
        danhSachSV.offer("Nguyen Van E");
        Stack<String> stack = new Stack<>();
//        int m = danhSachSV.size();
//        for(int i=-1;++i<m;){
//            stack.push(danhSachSV.poll());
//        }
//        int n = stack.size();
//        for(int i=-1;++i<n;){
//            System.out.println(stack.pop());
//        }

        while (true) {
            String ten = danhSachSV.poll();
            if(ten == null) {
                break;
            }
            System.out.println(ten);
        }
    }
}
