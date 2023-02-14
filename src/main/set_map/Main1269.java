package main.set_map;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main1269 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken()) ;
        int M = Integer.parseInt(st.nextToken());

        Set<Integer> A = new HashSet<>();   // 집합 A 생성
        Set<Integer> B = new HashSet<>();   // 집합 B 생성

        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < N; i++){
            A.add(Integer.parseInt(st.nextToken()));    // 집합 A에 입력 값 저장(1,2,4)
        }

        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < M; i++){
            B.add(Integer.parseInt(st.nextToken()));    // 집합 B에 입력 값 저장(3,4,5,6)
        }

        int count = 0;

        for (int i : A) {
            if(!B.contains(i)) count++; // 집합 B에 A의 수가 포함되어 있지 않다면 count 증가
        }
        for (int i : B) {
            if(!A.contains(i)) count++; // 집합 A에 B의 수가 포함되어 있지 않다면 count 증가
        }

        System.out.println(count);  // count 출력
    }
}
