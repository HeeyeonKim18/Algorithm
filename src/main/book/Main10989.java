package main.book;

import list.queue.Queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main10989 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] num = new int[N];

        for(int i = 0; i < N; i++){
            num[i] = Integer.parseInt(br.readLine());
        }

        sort(num, 5);
    }

    private static void sort(int[] num, int ms) {
        int[] output = new int[num.length];
        int last = 1;
        int count = 0;
        while(count != ms){
            int[] bucket = new int[10];
            for(int i = 0; i < num.length; i++){
                bucket[(num[i] / last) % 10]++;
            }
        }
    }
}
