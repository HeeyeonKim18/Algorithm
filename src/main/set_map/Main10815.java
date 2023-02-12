package main.set_map;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main10815 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());    // 상근이가 소유한 숫자카드 개수

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        Set<Integer> set = new HashSet<>(); // Set 객체 생성
        for(int i = 0; i < N; i++){
            set.add(Integer.parseInt(st.nextToken()));  // Set에 숫자카드 더하기
        }

        int M = Integer.parseInt(br.readLine());    // 상근이가 소유하고 있는 카드인지 알아보는 숫자카드의 개수
        StringBuilder sb = new StringBuilder();
        StringTokenizer st1 = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < M; i++){
            if(set.contains(Integer.parseInt(st1.nextToken()))) // set에 해당 카드가 존재하는지, 만약 존재하면?
                sb.append("1").append(" "); // "1" 출력
            else
                sb.append("0").append(" "); // 없다면 "0" 출력

        }
        System.out.println(sb);
    }
}
