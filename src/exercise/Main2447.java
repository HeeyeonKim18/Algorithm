package exercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main2447 {
    static String[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        arr = new String[N][N];
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++){
                arr[i][j] = " ";
            }
        }
        star(arr, 0, 0, N);

    }

    static void star(String[][] arr, int x, int y, int N){
        if(N == 1){
            arr[x][y] = "*";
            return;
        }
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                if (!(i == 1 && j == 1)) {
                    star(arr, x + i * (N / 3), y + j * (N / 3), N / 3);
                }
            }
        }
    }


}
