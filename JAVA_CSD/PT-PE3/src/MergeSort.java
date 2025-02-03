public class MergeSort {

    public static void mergeSort(Student[] arr, int low, int high) {
        if (low < high) {
            int mid = low + (high - low) / 2;
            mergeSort(arr, low, mid);
            mergeSort(arr, mid + 1, high);
            merge(arr, low, mid, high);
        }
    }

    public static void merge(Student[] arr, int low, int mid, int high) {
        Student[] temp = new Student[arr.length];
        for (int i = low; i <= high; i++) {
            temp[i] = arr[i];
        }

        int i = low;
        int j = mid + 1;
        int k = low;

        while (i <= mid && j <= high) {
            if (temp[i].gpa > temp[j].gpa || (temp[i].gpa == temp[j].gpa && temp[i].name.compareTo(temp[j].name) < 0) || (temp[i].gpa == temp[j].gpa && temp[i].name.equals(temp[j].name) && temp[i].id < temp[j].id)) {
                arr[k++] = temp[i++];
            } else {
                arr[k++] = temp[j++];
            }
        }

        while (i <= mid) {
            arr[k++] = temp[i++];
        }
    }
}