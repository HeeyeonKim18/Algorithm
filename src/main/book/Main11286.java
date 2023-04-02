package main.book;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main11286 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());    // 연산의 개수

        StringBuilder sb = new StringBuilder();
        PriorityQueue<Integer> pq = new PriorityQueue<>(((o1, o2) -> {  // 우선순위 큐 생성
            int first = Math.abs(o1);
            int second = Math.abs(o2);
            if(first == second) return o1 > o2? 1: -1;  // 값이 동일하다면 음수 값을 우선하도록
            else return first-second;   // 절대값 기준으로 정렬
        }));
        while (N-- > 0) {
            int x = Integer.parseInt(br.readLine());
            if (x == 0) {
                if (pq.isEmpty()) { // 큐가 비어있다면
                    sb.append("0").append("\n");    // 0을 출력
                } else {
                    sb.append(pq.poll()).append("\n");  // 큐의 최솟값 출력
                }
            } else {
                pq.add(x);  // 큐가 비어있지 않다면 큐에 데이터 삽입
            }
        }
        System.out.println(sb); // 출력
    }
}
