package main.book;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main11004 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());  // 입력 값 배열 저장
        }

        quick(arr, 0, N - 1, K - 1);    // 메소드 실행
        System.out.println(arr[K-1]);   // 출력
    }

    private static void quick(int[] arr, int s, int e, int k) {
       if(s < e){
           int pivot = partition(arr, s, e);    // 피봇 구하기
           if(pivot == k) return;   // 피봇이 k라면 종료
           else if (k < pivot) quick(arr, s, pivot - 1, k); // 피봇이 K보다 클 경우
           else quick(arr, pivot + 1, e, k);    // 피봇이 K보다 작을 경우
       }

    }

    private static int partition(int[] arr, int s, int e) {
        if(s+1 == e){   // 데이터가 2개라면 바로 비교 후 정렬
            if(arr[s] > arr[e]) swap(arr, s, e);
            return e;
        }
        int mid = (s + e) / 2;  // 중앙값
        swap(arr, s, mid);  // 중앙값과 시작 위치 값 바꾸기

        int pivot = arr[s];
        int i = s+1, j = e;
        while(i <= j){
            while(pivot < arr[j] && j > 0) j--; // 피봇보다 작은 수 나올 때가지
            while(pivot > arr[i] && i < arr.length-1) i++;  // 피봇보다 큰 수 나올 때까지
            if(i <= j) swap(arr, i++, j--); // 찾은 값 swap
        }
        arr[s] = arr[j];
        arr[j] = pivot;
        return j;   // 그룹으로 나눠진 경계 Index 리턴
    }
    private static void swap(int[] arr, int s, int e) {
        int tmp = arr[s];
        arr[s] = arr[e];
        arr[e] = tmp;
    }
}
