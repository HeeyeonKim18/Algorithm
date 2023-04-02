package main.book;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main17298 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n]; // 입력 값 저장 배열
        int[] result = new int[n];  // 결과 저장 배열

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());  // 입력 값 저장
        }

        Stack<Integer> s = new Stack<>();
        s.push(0);  // 빈 스택에 초기값 셋팅
        for(int i = 1; i < n; i++){ // 배열 값을 스택에 저장하는 것이 아닌 인덱스를 저장

            // 스택이 비어있지 않고 현재 입력되는 인덱스 값이 스택 최상단 값보다 클 경우
            while (!s.isEmpty() && arr[s.peek()] < arr[i]) {
                result[s.pop()] = arr[i];   // 스택 상단 값을 꺼내고 그 값을 결과 배열에 저장
            }
            s.push(i);  // 신규 데이터(인덱스) push
        }
        while(!s.isEmpty()){    // 반복문 종료에도 스택이 비어있지 않다면 ?
            result[s.pop()] = -1;   // 해당 인덱스에 -1을 저장
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < n; i++){
            sb.append(result[i] + " ");
        }

        System.out.println(sb); // 출력
    }
}
