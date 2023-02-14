package main.set_map;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main1620 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Map<Integer, String> map = new HashMap<>();
        for(int i = 1; i <= N; i++){
            map.put(i, br.readLine());
        }

        StringBuilder sb = new StringBuilder();

        for(int i =0; i < M; i++){
            String s = br.readLine();
            if(s.charAt(0) < 65){
                sb.append(map.get(Integer.parseInt(s))).append("\n");
            }else{
                Optional<Integer> integer = map.entrySet().stream()
                        .filter(entry -> s.equals(entry.getValue()))
                        .findFirst().map(Map.Entry::getKey);
                sb.append(integer.get()).append("\n");
            }
        }
        System.out.println(sb);
    }
}
