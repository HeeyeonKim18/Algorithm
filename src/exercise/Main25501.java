package exercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main25501 {
    static int count = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        
        for(int i = 0; i < N; i++){
            String str = br.readLine();
            sb.append(isF(str)).append(" ").append(count).append("\n");
        }
        System.out.println(sb);

    }

    private static int isF(String str) {
        count = 1;
        return recursion(str, 0, str.length() - 1);
    }

    private static int recursion(String str, int i, int j) {
        if(i >= j) return 1;
        else if(str.charAt(i) != str.charAt(j)) return 0;
        else {
            count++;
            return recursion(str, i + 1, j - 1);
        }

    }

}
