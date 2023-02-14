package main.set_map;

import java.io.*;
import java.util.*;

public class Main10816 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());    // N 입력 받기

        Map<Integer, Integer> map = new HashMap<>();    // Map 객체 생성
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            int result = Integer.parseInt(st.nextToken());  // 값 입력 받기

            // 키 값으로 입력 값 넣고, 벨류 값에는 키 값이 존재하지 않으면 0 + 1, 존재하면 기존 밸류 값 + 1
            map.put(result, map.getOrDefault(result, 0) +1);
        }

        int M = Integer.parseInt(br.readLine());     // M 입력 받기
        StringTokenizer st1 = new StringTokenizer(br.readLine(), " ");
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < M; i++) {
            int num = Integer.parseInt(st1.nextToken());

            // 벨류 값 출력하는데 존재하지 않는 키 값이라면 0을 출력
            sb.append(map.getOrDefault(num, 0)).append(" ");
        }

        System.out.println(sb);
    }
}
