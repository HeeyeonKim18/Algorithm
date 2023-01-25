package main.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

import static java.util.Collections.*;

public class Main25305 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());   // 응시자 수
        int k = Integer.parseInt(st.nextToken());   // 상을 받는 인원

        StringTokenizer st1 = new StringTokenizer(br.readLine(), " ");
        Integer[] arr = new Integer[N];     // 점수 값을 저장할 배열

        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st1.nextToken()); // 점수 입력 받기
        }

        Arrays.sort(arr, reverseOrder());   // 내림차순으로 정렬

        System.out.println(arr[k-1]);   // 상 받는 점수 중 가장 낮은 점수 출력, 배열은 0부터 시작하기 때문에 -1해줌
    }
}
