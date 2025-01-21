package codingstudy.day6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Test27160 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] s= new int[4];

        while(n-- > 0){
            String[] input = br.readLine().split(" ");
            String fruits = input[0];
            int cnt = Integer.parseInt(input[1]);

            switch (fruits) {
                case "STRAWBERRY":
                    s[0] += cnt;
                    break;
                case "BANANA":
                    s[1] += cnt;
                    break;
                case "LIME":
                    s[2] += cnt;
                    break;
                case "PLUM":
                    s[3] += cnt;    
                    break;
            }
        }

        for (int i : s) {
            if(i == 5){
                System.out.println("YES");
                return;
            }
        }
        System.out.println("NO");
    }
}
