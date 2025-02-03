package srcCode.efficientSortingAlgorithms.mergeSort;

public class MergeSort {
    private int [] a;

    public MergeSort() {
    }

    public MergeSort(int[] a) {
        this.a = a;
    }
    public void mergeSort(int[] arr){
        int n = arr.length;
        if(n < 2) return;
        int mid = n/2;
        int[] l = new int[mid];
        int[] r = new int[n-mid];
        for(int i=0; i<mid; i++){
            l[i] = arr[i];
        }
        for(int i=mid; i<n;i++){
            r[i - mid] = arr[i];
        }
        mergeSort(l);
        mergeSort(r);
        merge(arr,l,r);
    }
    private void merge(int arr[], int[] l, int[] r) {
        int lSize = l.length;
        int rSize = r.length;
        int i = 0, j = 0, k = 0;
        while (i < lSize && j < rSize) {
            if (l[i] <= r[j]) {
                arr[k] = l[i];
                i++;
            } else {
                arr[k] = r[j];
                j++;
            }
            k++;
        }
        while (i < lSize) {
                arr[k] = l[i];
                i++;
                k++;
        }
        while (j < rSize){
                arr[k] = r[j];
                j++;
                k++;
        }
    }
}
