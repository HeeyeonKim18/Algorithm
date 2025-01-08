package sparta_algorithm.secondweek.backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Test5525 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        String s = br.readLine();

        int count = 0;
        int patternCount = 0;

        for(int i = 1; i < m - 1; i++){
            if(s.charAt(i-1) == 'I' && s.charAt(i) == 'O'&& s.charAt(i+1) == 'I'){
                patternCount++;

                if(patternCount >= n) count++;
                i++;
            }else{
                patternCount = 0;
            }
        }

        System.out.println(count);
    }
}
