package main.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main13305 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());    // 도시의 개수

        long[] distance = new long[N-1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < distance.length; i++){
            distance[i] = Integer.parseInt(st.nextToken()); // 거리
        }

        long[] cost = new long[N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < cost.length; i++){
            cost[i] = Integer.parseInt(st.nextToken()); // 도시 주유소의 리터당 가격
        }

        long sum = 0;   // 합계
        long min = cost[0]; // 리터 당 가격 최소 비용 저장 (초기값: 첫 번째)
        for(int i = 0; i < N -1; i++){
                // 현재 리터 당 가격이 최소 비용보다 싸다면?
                if (cost[i] < min) {
                    min = cost[i];
                }
            sum += (distance[i] * min); // 합계에 거리 * 리터 당 가격
        }
        System.out.println(sum);    // 출력
    }
}
