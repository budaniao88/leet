package leet.rank;

public class quicksort {
    private int partition(int[] arr,int low,int high){
        if (low >= high) return low;
        int pivot = arr[high];
        int pointer = low;
        for (int i = low; i < high; i++) {
            if (arr[i] <= pivot){
                int temp = arr[i];
                arr[i] = arr[pointer];
                arr[pointer] = temp;
                pointer ++;
            }
        }
        int temp = arr[pointer];
        arr[pointer] = arr[high];
        arr[high] = temp;
        return pointer;
    }
    private int[] quickSort(int[] array, int low, int high){
        if (low < high){
            int position = partition(array,low,high);
            quickSort(array,low,position-1);
            quickSort(array,position+1,high);
        }
        return array;
    }
}
