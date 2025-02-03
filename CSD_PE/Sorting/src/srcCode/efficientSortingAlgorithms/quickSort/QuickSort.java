package srcCode.efficientSortingAlgorithms.quickSort;

public class QuickSort {
    private int [] a;

    public QuickSort() {
    }

    public QuickSort(int[] a) {
        this.a = a;
    }
    public void quickSort(int[] arr, int lowIndex, int highIndex){
        if(lowIndex>=highIndex) return;

        int pivot = arr[highIndex];
        int leftPoint = lowIndex;
        int rightPoint = highIndex;
        while(leftPoint < rightPoint) {
            while(arr[leftPoint] <= pivot && leftPoint < rightPoint){
                leftPoint++;
            }
            while(arr[rightPoint] >= pivot && leftPoint < rightPoint){
                rightPoint--;
            }
            swap(arr, leftPoint, rightPoint);
        }
        swap(arr,leftPoint,highIndex);
        quickSort(arr,lowIndex,leftPoint-1);
        quickSort(arr,leftPoint+1,highIndex);
    }
    private void swap(int[] arr, int index1, int index2){
        int temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }
}
