public class BubbleSort {
        public static void bubbleSort(Student[] arr) {
            int n = arr.length;
            for (int i = 0; i < n - 1; i++) {
                for (int j = 0; j < n - i - 1; j++) {
                    if (arr[j].gpa < arr[j + 1].gpa || (arr[j].gpa == arr[j + 1].gpa && arr[j].name.compareTo(arr[j + 1].name) > 0) || (arr[j].gpa == arr[j + 1].gpa && arr[j].name.equals(arr[j + 1].name) && arr[j].id > arr[j + 1].id)) {
                        Student temp = arr[j];
                        arr[j] = arr[j + 1];
                        arr[j + 1] = temp;
                    }
                }
            }
        }
}
