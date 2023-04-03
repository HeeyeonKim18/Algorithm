package main.book;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main1377 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());    // 배열의 크기

        Data[] A = new Data[N]; // Data 클래스 배열
        for (int i = 0; i < N; i++) {
            A[i] = new Data(Integer.parseInt(br.readLine()), i);    // 값 입력 받기
        }

        Arrays.sort(A); // value 값 기준으로 값 정렬
        int max = 0;

        // 정렬 전 인덱스와 정렬 후 인덱스 비교해 최댓값을 도출
        for(int i = 0; i< N; i++){
            if(max < A[i].idx - i)
                max = A[i].idx - i;
        }
        // 스왑이 일어나지 않는 반복문이 한번 더 실행되는 것을 감안해 최댓값에 1을 더함
        System.out.println(max+1);
    }


    private static class Data implements Comparable<Data>{
        int value;
        int idx;

        public Data(int value, int idx) {
            this.value = value;
            this.idx = idx;
        }

        @Override
        public int compareTo(Data o) {
            return this.value - o.value;
        }
    }
}
