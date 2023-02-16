package main.geometry;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main2477 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int K = Integer.parseInt(br.readLine());

        int[][] arr = new int[6][2];

        int maxWidth = 0;
        int maxHeight = 0;
        int maxWidthIndex = 0;
        int maxHeightIndex = 0;

        for (int i = 0; i < 6; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());

            if (arr[i][0] == 1 || arr[i][0] == 2) {
                if (maxWidth < arr[i][1]) {
                    maxWidth = Math.max(maxWidth, arr[i][1]);
                    maxWidthIndex = i;
                }
            } else {
                if (maxHeight < arr[i][1]) {
                    maxHeight = Math.max(maxHeight, arr[i][1]);
                    maxHeightIndex = i;
                }
            }

        }

        int smallRectangle = arr[(maxWidthIndex + 3) % 6][1] * arr[(maxHeightIndex + 3) % 6][1];
        System.out.println(((maxWidth * maxHeight) - smallRectangle) * K);

    }
}
