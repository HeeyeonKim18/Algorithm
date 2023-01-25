package main.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main2775 {
    public static void main(String[] args) throws IOException {
        // 2차원 배열 생성
        // 1 <= floor, door <= 14
        int[][] apt = new int[15][15];

        // 기본값 초기화 0층과 각 1호
        for (int i = 0; i < apt.length; i++) {
            apt[i][1] = 1;
            apt[0][i] = i;
        }

        // 이중 for문으로 2 ~ 14호 값 입력하기
        for (int i = 1; i < apt.length; i++) {
            int sum = apt[i - 1][1];
            for (int j = 2; j < apt.length; j++) {
                sum += apt[i - 1][j];
                apt[i][j] = sum;
            }
        }

        // 입력 받기 위해 BufferedReader 객체 생성
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 테스트 케이스 수
        int T = Integer.parseInt(br.readLine());

        // 테스트 케이스 만큼 입력받기 위해 for문
        for (int i = 0; i < T; i++) {
            // 층수 입력받기
            int floor = Integer.parseInt(br.readLine());
            // 호수 입력받기
            int door = Integer.parseInt(br.readLine());
            // 배열에 저장된 값 출력하기
            System.out.println(apt[floor][door]);
        }
    }
}
