import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Student[] students = {
                new Student(2, "Bob", 3.5),
                new Student(3, "Charlie", 3.8),
                new Student(4, "David", 3.7),
                new Student(5, "Alice", 3.9),
                new Student(1, "Alice", 3.8),
                new Student(8, "Bob", 3.5),
                new Student(3, "Charlie", 3.8),
        };
        System.out.println("Danh sách sinh viên trước khi sắp xếp:");
        Arrays.stream(students).forEach(System.out::println);
        MergeSort.mergeSort(students, 0, students.length - 1);
        System.out.println("\nDanh sách sinh viên sau khi sắp xếp (mergeSort) :");
        Arrays.stream(students).forEach(System.out::println);

        System.out.println("Danh sách sinh viên trước khi sắp xếp:");
        Arrays.stream(students).forEach(System.out::println);
        BubbleSort.bubbleSort(students);
        System.out.println("\nDanh sách sinh viên sau khi sắp xếp (bubbleSort) :");
        Arrays.stream(students).forEach(System.out::println);
    }
}
