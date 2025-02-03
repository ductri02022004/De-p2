package Search;

import java.util.LinkedList;
import java.util.Scanner;

public class InterpolationSearch {
    public static void main(String[] args) {
        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.add(10);
        linkedList.add(20);
        linkedList.add(30);
        linkedList.add(40);
        linkedList.add(50);
        System.out.println("Danh sách liên kết: " + linkedList);
        System.out.println("Nhập phần tử cần tìm kiếm: ");
        int key = new Scanner(System.in).nextInt();
        int rs = interpolationSearch(linkedList, key);
        System.out.println((rs != -1) ? "Phần tử " + key + " được tìm thấy tại vị trí " + rs :
                "Phần tử " + key + " không tồn tại trong danh sách liên kết.");
    }
    // t: tập xác định giá tỉn
    // x: giá trị cần tình -> vị trí
    // IS => s = l + (x'key'- T(l))'list.get(left)'*(r-l)
    //           -------------------
    //           (T(r)   - T(l))
    public static int interpolationSearch(LinkedList<Integer> linkedList, int key) {
        int low = 0;
        int high = linkedList.size() - 1;
        while (low <= high && key >= linkedList.get(low) && key <= linkedList.get(high)) {
            int pos = low + ((key - linkedList.get(low)) * (high - low)) / (linkedList.get(high) - linkedList.get(low));
            if (linkedList.get(pos) == key) {
                return pos;
            }
            if (linkedList.get(pos) < key) {
                low = pos + 1;
            } else {
                high = pos - 1;
            }
        }
            return -1;
        }
}