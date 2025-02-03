package srcCode.elementarySortingAlgorithms.selectionSort;

public class SelectionSort {
    public int [] a;

    public SelectionSort() {
    }

    public SelectionSort(int[] a) {
        this.a = a;
    }
    private void sort(int b){
        int min = b;
        if(b==a.length-1) return;
        for(int i=b+1; i < a.length; i++){
            if(a[min]>a[i]) min = i;
        }
        int temp = a[min];
        a[min] = a[b];
        a[b] = temp;
        sort(b+1);
    }
    public void sort(){
        sort(0);
    }
//    public void sort1(int [] arr){
//        int n = arr.length;
//        for(int i=-1;++i<n-1;){
//            int min = arr[i];
//            int indexMin = i;
//            for(int j = i+1;j<n;j++){
//                if(arr[j]<min){
//                    min = arr[j];
//                    indexMin = j;
//                }
//            }
//            swap(arr,i,indexMin);
//        }
//    }
//    private void swap(int [] arr, int a, int b){
//        int temp = arr[a];
//        arr[a]=arr[b];
//        arr[b] = temp;
//    }
}
