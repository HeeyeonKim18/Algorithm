package main.book;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main2164 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            q.add(i);   // 카드 큐에 저장
        }

        while(q.size() > 1){ // 카드가 한 장 남을 때까지
            q.poll();   // 맨 위의 카드 버림
            q.add(q.poll());    // 맨 위의 카드를 다시 아래로 이동
        }
        System.out.println(q.poll());   // 남은 카드 출력
    }
}
