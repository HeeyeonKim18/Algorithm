package main.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main1181 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // 문자 N개의 수

        String[] arr = new String[N];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = br.readLine(); // 문자 입력 받기
        }

        /**
         * Comparator 람다식으로 구현
         * compareTo()는 알파벳을 사전 순으로 정렬함
         */
        Arrays.sort(arr, (o1, o2) -> {

            if (o1.length() == o2.length()) { // 길이가 같다면 ?
                return o1.compareTo(o2);    // 사전 순으로 정렬
            } else {
                return o1.length() - o2.length();   // 이외의 경우는 길이가 짧은 순서로 정렬
            }
        });

        StringBuilder sb = new StringBuilder();

        for (int i = 1; i < arr.length; i++) {
            if (!arr[i - 1].equals(arr[i])) // 배열의 값이 같지 않다면?
                sb.append(arr[i - 1]).append("\n"); // 출력
        }
        sb.append(arr[arr.length - 1]);

        System.out.println(sb);
    }
}
