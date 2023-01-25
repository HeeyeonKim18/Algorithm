package main.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main2839 {
    public static void main(String[] args) throws IOException {
        // 수를 입력받기 위해 BufferedReader 객체 생성
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 입력받는 수
        int N = Integer.parseInt(br.readLine());
        // 봉지의 수를 카운드하는 변수
        int cnt = 0;
        while (true) {
            if (N % 5 == 0) {   // 입력 받은 수가 5로 나눠 떨어진다면 ?
                cnt += N / 5;   // 변수 cnt에 나눈 값을 더하여 출력
                System.out.println(cnt);
                break;  // break 문을 빠져나가면서 while문 종료
            } else if (N < 0) {
                System.out.println(-1); // N이 0보다 작다면 -1 출력
                break;
            }
            N -= 3; // while문이 돌아가는 동안 입력받은 N값에 -3을 해줌
            cnt++;  // 3kg 한봉지를 사용한 것이기에 변수 cnt의 값을 증가시킴
        }
    }
}
