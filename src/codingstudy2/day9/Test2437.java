package codingstudy2.day9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Test2437 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] w = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            w[i] = Integer.parseInt(st.nextToken());
        }

        // 추를 오름차순으로 정렬
        Arrays.sort(w);

        // 현재까지 측정 가능한 범위의 최대값
        long currentSum = 0;

        for (int i = 0; i < n; i++) {
            // 현재 추의 무게가 측정 가능한 범위 + 1보다 크다면, 그 값이 최소 측정 불가능한 값
            if (w[i] > currentSum + 1) {
                System.out.println(currentSum + 1);
                return;
            }
            // 현재 추를 사용해 측정 가능한 범위를 확장
            currentSum += w[i];
        }

        // 모든 추를 사용한 후에도 측정 가능한 범위를 벗어나는 값
        System.out.println(currentSum + 1);
    }
}
