package sparta_algorithm.secondweek.backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Test9375 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        HashMap<String, Integer> map;
        StringBuilder sb = new StringBuilder();
        while(t-- > 0){
            int n = Integer.parseInt(br.readLine());

            map = new HashMap<>();
            for(int i = 0 ; i < n; i++){
                String[] clothes = br.readLine().split(" ");
                map.put(clothes[1], map.getOrDefault(clothes[1], 1) + 1);
            }

            int result = 1;
            for (int i : map.values()) {
                result *= i;
            }

            sb.append(result - 1).append("\n");
        }

        System.out.println(sb);
    }
}
