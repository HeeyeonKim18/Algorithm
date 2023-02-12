package main.set_map;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main10815_1 {
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int M = Integer.parseInt(br.readLine());
        StringTokenizer st1 = new StringTokenizer(br.readLine(), " ");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            boolean search = search(Integer.parseInt(st1.nextToken()), 0, arr.length - 1);
            if (search)
                sb.append("1").append(" ");
            else
                sb.append("0").append(" ");

        }
        System.out.println(sb);
    }

    private static boolean search(int i, int left, int right) {
        while (left <= right) {
            int mid = (left + right) / 2;
            if (i < arr[mid]) right = mid - 1;
            else if (i > arr[mid]) left = mid + 1;
            else return true;
        }
        return false;
    }
}
