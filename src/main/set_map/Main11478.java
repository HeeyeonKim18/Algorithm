package main.set_map;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main11478 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();   // 문자열 입력 받기

        Set<String> set = new HashSet<>(); // set 생성
        for(int i = 0; i < s.length(); i++){
            for(int j = i+1; j <= s.length(); j++){
                set.add(s.substring(i, j)); // 부분 문자열을 set에 저장
            }
        }
        System.out.println(set.size()); // set에 입력된 수의 개수를 출력
    }
}
