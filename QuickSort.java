import java.util.Arrays;

public class QuickSort {
    static void quickSort(int arr[], int low, int high){
        if(low<high){
            int index = partition(arr, low, high);
            quickSort(arr, low, index-1);
            quickSort(arr, index+1, high);
        }
    }

    static int partition(int arr[], int low, int high){
        int pivot = arr[low];
        int i=low+1, j=high;
        while(i<=j){
            if(arr[i]<=pivot) i++;
            else if(arr[j]>pivot) j--;
            else{
                int temp=arr[j];arr[j]=arr[i];arr[i]=temp;
            }
        }
        int temp = arr[low];
        arr[low] = arr[j];
        arr[j] = temp;
        return j;
    }
    public static void main(String[] args) {
        int[] array = {9, 2, 5, 1, 7, 6, 8, 3, 4};
        System.out.println("Original array: " + Arrays.toString(array));

        quickSort(array, 0, array.length - 1);

        System.out.println("Sorted array: " + Arrays.toString(array));
    }
}
