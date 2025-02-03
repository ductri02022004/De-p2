package Queue;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class Priority {
    public static void main(String[] args) {
        // add(): thêm vào queue và nếu vượt quá số lượng thì nó sẽ đẩy cái đầu tiên ra ngoài
        // offer(): thêm vào queue và nếu vượt quá số lượng thì nó sẽ báo lỗi
        // element(): lấy top
        // peek(): lấy top nhưng không xóa khỏi stack
        // remove(): xóa top
        // poll(): lấy top và xóa khỏi stack


        Queue<String> danhSachSV = new PriorityQueue<>();
        danhSachSV.offer("Nguyen Van A");
        danhSachSV.offer("Nguyen Van B");
        danhSachSV.offer("Nguyen Van C");
        danhSachSV.offer("Nguyen Van D");
        danhSachSV.offer("Nguyen Van E");
        while (true) {
            String ten = danhSachSV.poll();
            if(ten == null) {
                break;
            }
            System.out.println(ten);
        }
    }
}
