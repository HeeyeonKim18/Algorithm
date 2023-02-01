package main.recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main24060 {

    static int[] sorted;    // 임시 배열
    static int K;   // K번째 저장되는 수
    static int cnt = 0; // K번째 입력 값 카운트
    static int num = -1;    // 출력 값

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());   // N개의 수
        K = Integer.parseInt(st.nextToken());   // static으로 생성한 변수 K

        int[] arr = new int[N]; // 배열 생성
        StringTokenizer st1 = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st1.nextToken()); // 배열의 값 입력 받기
        }

        sorted = new int[arr.length];
        mergeSort(arr, 0, arr.length - 1);  // merge sort
        System.out.println(num);    // K번째 값 출력하기
    }

    private static void mergeSort(int[] arr, int i, int j) {
        if (i < j) {
            int mid = (i + j) / 2;
            mergeSort(arr, i, mid);
            mergeSort(arr, mid + 1, j);
            merge(arr, i, mid, j);
        }
    }

    private static void merge(int[] arr, int i, int mid, int j) {
        int left = i;
        int right = mid + 1;
        int idx = i;

        while (left <= mid && right <= j) {
            if (arr[left] <= arr[right]) {
                sorted[idx++] = arr[left++];
            } else {
                sorted[idx++] = arr[right++];
            }
        }
        if (left > mid) {
            while (right <= j) {
                sorted[idx++] = arr[right++];
            }
        } else {
            while (left <= mid) {
                sorted[idx++] = arr[left++];
            }
        }

        for (int k = i; k <= j; k++) {
            cnt++;
            if (cnt == K) { // 카운트한 값과 K값이 같다면?
                num = sorted[k];    // 변수 num에 현재 sorted[k] 값 저장 후
                break;              // 반복문 빠져나오기
            }
            arr[k] = sorted[k];     // 정렬한 값을 arr 배열에 저장
        }
    }
}
