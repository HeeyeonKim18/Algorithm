package main.set_map;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main1620_1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Map<Integer, String> map1 = new HashMap<>();
        Map<String, Integer> map2 = new HashMap<>();

        for(int i = 1; i <= N; i++){
            String read = br.readLine();
            map1.put(i, read);
            map2.put(read, i);
        }

        StringBuilder sb = new StringBuilder();
        while(M-- > 0){
            String s = br.readLine();
            if(isNum(s)){
                sb.append(map1.get(Integer.parseInt(s))).append("\n");
            }else
                sb.append(map2.get(s)).append("\n");
        }
        System.out.println(sb);
    }

    private static boolean isNum(String s) {
        if(s.charAt(0) < 65)
            return true;
        return false;
    }
}
