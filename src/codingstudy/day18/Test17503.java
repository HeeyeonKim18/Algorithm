package codingstudy.day18;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Test17503 {
    static int max = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        // 마셔야 하는 맥주의 수
        int n = Integer.parseInt(st.nextToken());
        // 선호도가 m보다 커야함
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[][] alcohol = new int[k][2];

        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            alcohol[i][0] = Integer.parseInt(st.nextToken());
            alcohol[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(alcohol, (o1, o2) -> {
            return o1[1] == o2[1] ? o2[0] - o1[0] : o2[1] - o1[1];
        });

    }
}
