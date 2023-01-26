package main.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 시간초과났음..
 */
public class Main11650 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[][] arr = new int[N][2];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int front = Integer.parseInt(st.nextToken());
            int back = Integer.parseInt(st.nextToken());

            arr[i][0] = front;
            arr[i][1] = back;
        }

        for(int i = 0; i < N; i++) {
            for (int j = 1; j < N; j++) {
                if (arr[j - 1][0] > arr[j][0]) {
                    swap(arr, j);
                } else if (arr[j - 1][0] == arr[j][0]) {
                    if (arr[j - 1][1] > arr[j][1]) {
                        swap(arr, j);
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < N; i++){
            sb.append(arr[i][0]).append(" ").append(arr[i][1]).append("\n");
        }
        System.out.println(sb);
    }

    static void swap(int[][] arr, int j){
        int tmpF = arr[j - 1][0];
        int tmpB = arr[j - 1][1];
        arr[j - 1][0] = arr[j][0];
        arr[j - 1][1] = arr[j][1];
        arr[j][0] = tmpF;
        arr[j][1] = tmpB;
    }
}
