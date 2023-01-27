package main.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main10814 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        String[] arr = new String[N];
        for (int i = 0; i < N; i++) {
            arr[i] = br.readLine();
        }

        for (int k = 0; k < arr.length - 1; k++) {
            for (int i = 1; i < arr.length - k; i++) {
                for (int j = 1; j < N; j++) {
                    int arr1 = Integer.parseInt(arr[j].substring(0, arr[j].indexOf(" ")));
                    int arr2 = Integer.parseInt(arr[j - 1].substring(0, arr[j - 1].indexOf(" ")));
                    if (arr1 < arr2) swap(arr, i, i - 1);
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (String s : arr) {
            sb.append(s).append("\n");
        }
        System.out.println(sb);

    }

    static void swap(String[] arr, int i, int j) {
        String tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
