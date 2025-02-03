package srcCode.elementarySortingAlgorithms.insertionSort;

public class InsertionSort {
    private int [] a;

    public InsertionSort() {
    }

    public InsertionSort(int[] a) {
        this.a = a;
    }
    public void insertionSort(int [] a){
        for(int i=1; i<a.length;i++){
            int temp = a[i];
            int j = i-1;
            while(j>=0 && a[j]>temp){
                a[j+1] = a[j];
                j--;
            }
            a[j+1] = temp;
        }
    }
}
