package sort;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {4,1,2,3,5};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void sort(int[] arr) {
        quickSort(arr, 0, arr.length - 1);
    }

    private static void quickSort(int[] arr, int l, int h) {
        if(l >= h) return;

        int pivot = partition(arr, l, h);

        if(pivot == 2) return;
        quickSort(arr, l, pivot - 1);
        quickSort(arr, pivot + 1, h);
    }

    private static int partition(int[] arr, int left, int right) {
        int l = left;
        int h = right;
        int pivot = arr[right];

        while(l < h){
            while(arr[l] < pivot && l < h){
                l++;
            }
            while(arr[h] >= pivot && l < h){
                h--;
            }
            swap(arr, l, h);
        }
        swap(arr, right, h);

        return h;
    }

    private static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

}
