package sort_intermediate;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class RadixSort {
    static int bucket_num = 10;
    public static void main(String[] args) {
        int[] arr = {384, 19837, 5, 963, 84, 542};
        Queue<Integer>[] bucket = new LinkedList[bucket_num];
        for(int a = 0; a < bucket_num; a++){
            bucket[a] = new LinkedList<>();
        }

        int digitNum = 0;
        int arrIndex = 0;

        for (int i = 0; i < mostDigits(arr); i++) {
            for (int j = 0; j < arr.length; j++) {
                digitNum = getDigit(arr[j],i);
                bucket[digitNum].add(arr[j]);
            }
            for(int j=0; j<bucket_num; j++) {
                while (!bucket[j].isEmpty()) {
                    arr[arrIndex++] = bucket[j].remove();
                    System.out.println(arrIndex);
                }
            }
            arrIndex = 0;
        }
        System.out.println(Arrays.toString(arr));
    }

    private static int mostDigits(int[] arr) {
        int maxDigits = 0;
        for (int i = 0; i < arr.length; i++) {
            maxDigits = Math.max(maxDigits, digitCount(arr[i]));
        }
        return maxDigits;
    }

    private static int digitCount(int i) {
        if (i == 0) return 1;
        return (int) Math.floor(Math.abs(Math.log10(i)));
    }

    private static int getDigit(int arr, int num) {
        return (int) (Math.floor(Math.abs(arr) / Math.pow(10, num)) % 10);
    }
}
