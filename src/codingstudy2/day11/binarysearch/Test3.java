package codingstudy2.day11.binarysearch;

import java.util.Arrays;

/**
 * N개의 집이 수직선 상에 있고, 좌표는 각각 다름.
 * C개의 공유기를 설치해야 함.
 * 단, 서로 가장 가까운 두 공유기 사이의 거리를 최대화하고 싶음.
 * 목표: 공유기 사이의 최소 거리를 최대화할 수 있는 최댓값을 구하자.
 */
public class Test3 {
    public static void main(String[] args) {
        int n = 5;
        int[] arr = { 1, 2, 8, 4, 9 };
        int c = 3;

        Arrays.sort(arr);
        int low = 1;
        int high = arr[n - 1] - arr[0];
        int answer = 0;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (canInstall(arr, mid, c)) {
                answer = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        System.out.println(answer);
    }

    static boolean canInstall(int[] houses, int distance, int c) {
        int count = 1;
        int lastInstalled = houses[0];

        for (int i = 1; i < houses.length; i++) {
            if (houses[i] - lastInstalled >= distance) {
                count++;
                lastInstalled = houses[i];
            }
        }
        return count >= c;
    }
}
