package main.geometry;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main1002 {
    static boolean[][] arr = new boolean[20001][20001];
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int i = 0; i < T; i++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int r1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            int r2 = Integer.parseInt(st.nextToken());

            countLocation(x1, y1, r1, x2, y2, r2);
            System.out.println(sb);
        }
    }

    private static void countLocation(int x1, int y1, int r1, int x2, int y2, int r2) {
        int count  = 0;
        int loX1 = x1 + 10000;
        int loY1 = y2 + 10000;
        int loX2 = x2 + 10000;
        int loY2 = y2 + 10000;
        arr[loX1][loY1] = true;
        arr[loX2][loY2] = true;
        while(r1-- > 0){
            arr[loX1++][loY1--] = true;
        }
        while(r2-- > 0){
            if(arr[loX2++][loY2--] != true){
                arr[loX2++][loY2--] = true;
            }else{
               count++;
            }
        }
        sb.append(count);
    }
}
