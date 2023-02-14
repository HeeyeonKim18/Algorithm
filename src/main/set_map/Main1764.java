package main.set_map;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main1764 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());   // N 입력받기
        int M = Integer.parseInt(st.nextToken());   // M 입력받기

        Set<String> set = new HashSet<>();  // HashSet 생성
        for (int i = 0; i < N; i++) {
            set.add(br.readLine()); // set에 입력값 저장
        }

        List<String> list = new ArrayList<>();  // 정렬을 해줄 list 생성
        int count = 0;
        while (M-- > 0) {
            String s = br.readLine();
            if (set.contains(s)) {  // set에 해당 입력 값이 포함되어 있다면?
                list.add(s);    // list에 저장하기
                count++;    // count 증가
            }
        }
        System.out.println(count);  // count 값 출력
        list.stream().sorted().forEach(System.out::println);    // stream을 이용하여 list 정렬하고 출력
    }
}
