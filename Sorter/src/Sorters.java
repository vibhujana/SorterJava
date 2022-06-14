

public class Sorters {
    private int[] _arr;

    public Sorters(int[] arr) {
        _arr = arr;
    }

    public void selectionSort() {
        for (int i = 0; i < _arr.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < _arr.length; j++) {
                if (_arr[j] < _arr[minIndex]) {
                    minIndex = j;
                }
            }
            swap(_arr, i, minIndex);
        }
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public void mergeSort(){
        mergeSortInternal(_arr,0,_arr.length);
    }

    private void mergeSortInternal(int[] arr, int start, int end) {
        int arrLen = end - start;
        if(arrLen <= 1) // base case
            return;
        int mid = start + (end - start)/2;
        mergeSortInternal(arr,start,mid);
        mergeSortInternal(arr,mid,end);
        merge(arr,start,mid,end);
    }

    private void merge(int[] arr, int start, int mid, int end) {
        int arrLen = end - start;
        int[] temp = new int[arrLen];
        int leftCount = start;
        int rightCount = mid;
        int tempCount = 0;
        while (leftCount <  mid && rightCount < end){
            if(arr[leftCount] < arr[rightCount]){
                temp[tempCount++] = arr[leftCount++];
            } else {
                temp[tempCount++] = arr[rightCount++];
            }
        }
        while(leftCount < mid){
            temp[tempCount++] = arr[leftCount++];
        }
        while (rightCount < end){
            temp[tempCount++] = arr[rightCount++];
        }
        int count = 0;
        for (int i = start; i < end; i++) {
            arr[i] = temp[count++];
        }
    }

    public void quickSort(){
        quickSortInternal(_arr,0, _arr.length);
    }

    private void quickSortInternal(int[] arr, int start, int end) {
        if(end - start <= 1)
            return;
        int i = start - 1;
        int pivot = end - 1;
        int j = i+1;
        while (j < pivot){
            if(arr[pivot] >= arr[j]) {
                swap(arr,++i,j);
            }
            j++;
        }
        swap(arr,i+1,pivot);
        quickSortInternal(arr,start,i+1);
        quickSortInternal(arr,i+2,end);
    }


    @Override
    public String toString(){
        StringBuilder builder = new StringBuilder();
        for(int v : _arr){
            builder.append(v + " ");
        }
        return builder.toString();
    }

}
