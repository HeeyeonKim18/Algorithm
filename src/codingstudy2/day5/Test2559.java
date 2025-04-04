package codingstudy2.day5;

import java.io.BufferedReader;
import java.util.StringTokenizer;

// 연속적인 온도가 가장 큰 합을 구하기 
public class Test2559 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        // 온도 측정한 전체 날짜의 수
        int n = Integer.parseInt(st.nextToken());
        // 연속적인 날짜의 수
        int k = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // 최대 합
        int max = Integer.MIN_VALUE;
        // 각 구간마다의 합 계산
        int sum = 0;

        int first = 0;
        int second = 0;
        while (second < n) {
            sum += arr[second];

            if (second - first + 1 > k) {
                sum -= arr[first];
                first++;
            }

            if (second - first + 1 == k) {
                max = Math.max(max, sum);
            }

            second++;
        }

        System.out.println(max);
    }
}