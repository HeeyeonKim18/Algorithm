package codingstudy.day19;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class Test1946 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            int cnt = 1;
            int[][] rank = new int[n][2];

            for (int i = 0; i < n; i++) {
                String[] input = br.readLine().split(" ");
                rank[i][0] = Integer.parseInt(input[0]);
                rank[i][1] = Integer.parseInt(input[1]);
            }

            Arrays.sort(rank, Comparator.comparingInt(o -> o[0]));

            int min = rank[0][1];

            for (int i = 1; i < n; i++) {
                if (min > rank[i][1]) {
                    cnt++;
                    min = rank[i][1];
                }
            }
            System.out.println(cnt);
        }
    }
}
