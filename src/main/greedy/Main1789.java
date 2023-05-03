package main.greedy;

import java.util.Scanner;

public class Main1789 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long S = sc.nextLong();
        int i = 1;
        int cnt = 0;
        long sum = 0;
        while(S >= sum){
            sum += i;
            i++; cnt ++;
        }
        System.out.println(cnt-1);
    }
}
