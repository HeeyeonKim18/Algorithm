package main.book;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main11003 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());   // 데이터 개수
        int L = Integer.parseInt(st.nextToken());   // 최솟값을 구하는 범위

        Deque<Node> deq = new LinkedList<>();   // 큐와 비슷한 자료구조이지만 앞, 뒤 모두 삽입 Or 삭제 가능
        StringBuilder sb = new StringBuilder();
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            int p = Integer.parseInt(st.nextToken());

            while(!deq.isEmpty() && deq.getLast().value > p){   // 입력 값보다 큰 값이 덱에 저장되어 있다면 제거
                deq.removeLast();
            }
            deq.addLast(new Node(i, p));    // 덱에 저장

            if(deq.getFirst().idx <= i - L){    // 인덱스가 L 범위에서 벗어났을 경우
                deq.removeFirst();  // 덱에서 제거
            }
            sb.append(deq.getFirst().value).append(" ");    // 덱의 첫 번째 값 출력 (최소값)
        }
        System.out.println(sb);
    }
    static class Node{  // 인덱스와 입력 값을 담을 클래스
        int idx;
        int value;

        public Node(int idx, int value) {
            this.idx = idx;
            this.value = value;
        }
    }
}
