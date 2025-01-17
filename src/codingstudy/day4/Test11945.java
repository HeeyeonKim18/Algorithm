package codingstudy.day4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// Beginner
public class Test11945 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);

        StringBuilder sb = new StringBuilder();
        while(n-- > 0){
            String s = br.readLine();

            for(int i = m - 1; i >= 0; i--){
                char c = s.charAt(i);
                sb.append(c);
            }

            sb.append("\n");
        }

        System.out.println(sb);
    }
}
