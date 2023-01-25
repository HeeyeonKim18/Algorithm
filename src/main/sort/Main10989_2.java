package main.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main10989_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());

        int[] cntArr = new int[10001];
        int max = 0;

        for(int i = 0; i < N; i++){
            int num = Integer.parseInt(br.readLine());
            cntArr[num]++;
            max = Math.max(max, num);
        }

        for (int i = 0; i <= max; i++) {
            while(cntArr[i]-- > 0){
                sb.append(i).append("\n");
            }
        }
        System.out.println(sb);
    }
}
