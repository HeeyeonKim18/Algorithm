package main.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main2750_bubble {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];

        for(int i = 0; i < arr.length; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        boolean noSwap;

        for(int j = 1; j < arr.length-1; j++) {
            noSwap = true;
            for (int i = 0; i < arr.length - j; i++) {
                if (arr[i] > arr[i + 1]) {
                    int tmp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = tmp;
                    noSwap = false;
                }
            }
            if(noSwap) break;
        }
        for(int i = 0; i < arr.length; i++)
            System.out.println(arr[i]);
    }
}
