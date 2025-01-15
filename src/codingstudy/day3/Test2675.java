package codingstudy.day3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 비기너
public class Test2675 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        while(t-- > 0){
            String[] input = br.readLine().split(" ");
            int r = Integer.parseInt(input[0]);
            String s = input[1];

            for(int i = 0; i < s.length(); i++){
                char c = s.charAt(i);
                for(int j = 0; j < r; j++){
                    sb.append(c);
                }
            }
             sb.append("\n");
        }

        System.out.println(sb);
    }
}
