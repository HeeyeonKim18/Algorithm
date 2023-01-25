package main.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main2751 {
    private static int[] sorted;    // 숫자를 재배열할 수 있도록 해주는 임시 배열

    static void mergeSort(int[] a) {
        sorted = new int[a.length];
        mergeSort(a, 0, a.length - 1);
        sorted = null;
    }

    static void mergeSort(int[] arr, int l, int r) {    // 가장 작은 수로 쪼개기(split)
        if (l == r) return;     // 인덱스 끝과 끝이 같다면 return
        int mid = (l + r) / 2;  // 중앙값

        mergeSort(arr, l, mid); // 재귀 함수 호출
        mergeSort(arr, mid + 1, r); // 재귀 함수 호출
        merge(arr, l, mid, r);  // 병합하기
    }

    static void merge(int[] arr, int l, int mid, int r) {
        int left = l;
        int right = mid + 1;
        int idx = l;

        while (left <= mid && right <= r) {
            if (arr[left] <= arr[right]) {
                sorted[idx] = arr[left];
                idx++;
                left++;
            } else {
                sorted[idx] = arr[right];
                idx++;
                right++;
            }
        }

        if (left > mid) {
            while (right <= r) {
                sorted[idx] = arr[right];
                idx++;
                right++;
            }
        } else {
            while (left <= mid) {
                 sorted[idx] = arr[left];
                idx++;
                left++;
            }
        }
        for (int i = l; i <= r; i++) {
            arr[i] = sorted[i];
        }
    }

    static void print(int[] arr) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            sb.append(arr[i] + "\n");
        }
        System.out.println(sb);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        mergeSort(arr);
        print(arr);
    }
}
