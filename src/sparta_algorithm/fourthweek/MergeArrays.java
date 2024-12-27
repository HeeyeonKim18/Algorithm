package sparta_algorithm.fourthweek;

import java.util.Arrays;
import java.util.stream.IntStream;

public class MergeArrays {

    private static int[] sorted;
    public static void main(String[] args) {
        int[] arr1 = {1,3,5};
        int[] arr2 = {2,4,6};
        sort(arr1, arr2);

        int[] arr3 = {10,5,15};
        int[] arr4 = {4,11,2};
        sort(arr3, arr4);
    }

    private static void sort(int[] a1, int[]a2){
        int[] arr = IntStream.concat(
            Arrays.stream(a1), Arrays.stream(a2)
            )
            .toArray();
        
        sorted = new int[arr.length];
        
        divide(arr, 0, arr.length - 1);

        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    private static void divide(int[] a, int l, int r){
        if(l == r) return;

        int mid = (l + r) / 2;

        divide(a, l, mid);
        divide(a, mid + 1, r);

        merge(a, l, mid, r);
    }

    private static void merge(int[] a, int l, int m, int r){
        int left = l;
        int right = m + 1;
        int idx = l;

        while (left <= m && right <= r) {
            
            if(a[left] <= a[right]){
                sorted[idx++] = a[left++];
            }else{
                sorted[idx++] = a[right++];
            }
        }

        if(left > m){
            while(right <= r){
                sorted[idx++] = a[right++];
            }
        }else{
            while(left <= m){
                sorted[idx++] = a[left++];
            }
        }

        for(int i = l; i <= r; i++){
            a[i] = sorted[i];
        }
    }
}
