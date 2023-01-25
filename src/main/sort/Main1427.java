package main.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

import static java.util.Collections.reverseOrder;

public class Main1427 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String N = br.readLine();
        Integer[] arr = new Integer[N.length()];
        for (int i = 0; i < N.length(); i++) {
            arr[i] = N.charAt(i) - 48;
        }
        Arrays.sort(arr, reverseOrder());

        for(int i = 0; i < arr.length; i++){
            System.out.print(arr[i]);
        }
    }
}
