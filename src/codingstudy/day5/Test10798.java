package codingstudy.day5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Test10798 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();
        String[] inputs = new String[5]; 
        int maxLength = 0; 

        for (int i = 0; i < 5; i++) {
            inputs[i] = br.readLine();
            maxLength = Math.max(maxLength, inputs[i].length());
        }

        for (int i = 0; i < maxLength; i++) { 
            for (int j = 0; j < 5; j++) {
                if (i < inputs[j].length()) { 
                    sb.append(inputs[j].charAt(i));
                }
            }
        }

        System.out.println(sb);
    }
}
