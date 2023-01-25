package main.array2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main2566 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[][] arr = new int[9][9];
        int max = Integer.MIN_VALUE;
        String location = null;

        for(int i = 0; i < 9; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0; j < 9; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
                if(max < arr[i][j]){
                    max = arr[i][j];
                    location = (i+1) + " " + (j+1);
                }
            }
        }
        System.out.println(max);
        System.out.println(location);
    }
}
