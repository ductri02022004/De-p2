package Search;

import java.util.LinkedList;
import java.util.Scanner;

public class BinarySearch {
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
        int rs = binarySearch(linkedList, key);
        System.out.println((rs != -1) ? "Phần tử " + key + " được tìm thấy tại vị trí " + rs :
                "Phần tử " + key + " không tồn tại trong danh sách liên kết.");
    }
    public static int binarySearch(LinkedList<Integer> list, int key){
        int left = 0;
        int right = list.size()-1;
        while(left <= right){
            int mid = (left + right)/2;
            int midValue = list.get(mid);
            if(midValue==key){
                return mid;
            }else if(midValue < key){
                left = mid + 1;
            }else {
                right = mid - 1;
            }
        }
        return -1;
    }
}
