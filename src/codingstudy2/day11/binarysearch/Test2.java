package codingstudy2.day11.binarysearch;

import java.util.Arrays;

/**
 * N개의 부서가 각각 예산을 요청한다. 총 예산이 M일 때,
 * 모든 요청을 수용하되 어떤 부서도 특정 상한선을 넘을 수 없다.
 * 이 상한선을 최대화하자.
 */
public class Test2 {
    public static void main(String[] args) {
        int n = 4;
        int[] arr = { 120, 110, 140, 150 };
        int m = 485;

        Arrays.sort(arr);

        int low = 0;
        int high = arr[n - 1];
        while (low <= high) {
            int mid = (low + high) / 2;

            int cnt = 0;
            for (int i = 0; i < n; i++) {
                if (arr[i] > mid) {
                    cnt += mid;
                } else {
                    cnt += arr[i];
                }
            }

            if (cnt <= m) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        System.out.println(high);
    }
}
