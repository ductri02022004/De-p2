package srcCode.efficientSortingAlgorithms.heapSort;

public class HeapSort {
    private int[] arr;

    public HeapSort() {
    }

    public HeapSort(int[] arr) {
        this.arr = arr;
    }
    public void heapSort(int[] arr){
        int n = arr.length;
        for(int i = (n/2) - 1; i >= 0; i--){
            heap(arr,n,i);
        }
        for(int i=n-1; i>0; i--){
            swap(arr,0,i);
            heap(arr,i,0);
        }
    }
    private void heap(int[] arr, int n, int i){
        int max = i;
        int l = 2*i;
        int r = 2*i + 1;
        if(l<n && arr[l] > arr[max]){
            max = l;
        }
        if(r<n && arr[r] > arr[max]){
            max = r;
        }
        if(max != i){
            swap(arr,i,max);
            heap(arr,n,max);
        }
    }
    private void swap(int[] arr, int index1, int index2){
        int temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }
}
