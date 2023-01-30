package main.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main18870 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N]; // N 길이로 배열 생성

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());  // 배열에 값 저장하기
        }

        int[] result = arr.clone(); // 배열 result 생성하여 배열 arr값 복사하기

        Arrays.sort(arr);   // arr 정렬하기

        int count = 0;  // map에서 value값으로 인덱스 위치 지정

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < N; i++) {
            if (!map.containsKey(arr[i])) { // map에 해당 키가 있다면 count값이 증가되지 않도록 조건문 설정
                map.put(arr[i], count++);   // map에 키가 없다면, 키와 값을 추가하도록 함
            }
        }

        StringBuilder sb = new StringBuilder();

        for (int i : result) {
            sb.append(map.get(i)).append(" ");  // map에서 해당 키의 값을 출력하기
        }

        System.out.println(sb);
    }
}
