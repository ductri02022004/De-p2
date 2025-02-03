package Search;

import java.util.LinkedList;
import java.util.Scanner;

public class LinearSearch {
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
        int rs = linearSearch(linkedList, key);
        System.out.println((rs != -1) ? "Phần tử " + key + " được tìm thấy tại vị trí " + rs :
                "Phần tử " + key + " không tồn tại trong danh sách liên kết.");
    }
    public static int linearSearch(LinkedList<Integer> list, int key){
        for(int i=-1; ++i<list.size();){
            if(key==list.get(i)){
                return i;
            }
        }
        return -1;
    }
}
