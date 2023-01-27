package main.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main10814_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringBuilder[] sbArr = new StringBuilder[201]; // 1살부터 200살까지 입력 가능

        for(int i = 0; i < sbArr.length; i++){
            sbArr[i] = new StringBuilder(); // 객체 생성
        }

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int age = Integer.parseInt(st.nextToken()); // 나이 입력
            String name = st.nextToken();       // 이름 입력
            sbArr[age].append(age).append(" ").append(name).append("\n");   // 인덱스 = 나이, 값 = 나이 + " " + 값
        }


        StringBuilder sb = new StringBuilder();

        for (StringBuilder s : sbArr) {
            sb.append(s);   // 모든 문자 더하고 인덱스 1번 값부터 출력하기
        }
        System.out.println(sb); // 출력하기

    }
}
