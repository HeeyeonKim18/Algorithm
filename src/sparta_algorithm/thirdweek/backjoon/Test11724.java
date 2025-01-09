package sparta_algorithm.thirdweek.backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Test11724 {
    static boolean[] vistied ;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);

        int[][] nums = new int[n + 1][1];
        vistied = new boolean[n+1];
        while(m-- > 0){
            String[] str = br.readLine().split(" ");
            int u = Integer.parseInt(str[0]);
            int v = Integer.parseInt(str[1]);

            nums[u][0] = v;
            
        }

    }
}
