package srcCode.elementarySortingAlgorithms.bubbleSort;

public class BubbleSort {
    private int[] a;

    public BubbleSort() {
    }

    public BubbleSort(int[] a) {
        this.a = a;
    }

    public void bubbleSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            boolean check = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int flag = arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=flag;
                    check = true;
                }
            }
            if (!check) break;
        }
    }
}
