package main.book;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main1874_1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        Stack<Integer> stack = new Stack<>();
        int num = 0;

        while (n-- > 0) {
            int input = Integer.parseInt(br.readLine());
            if (input > num) {
                for (int i = num+1; i <= input; i++) {
                    stack.push(i);
                    sb.append("+").append("\n");
                }
                num = input;
            } else if (input != stack.peek()) {
                System.out.println("NO");
                System.exit(0);
            }
            stack.pop();
            sb.append("-").append("\n");
        }
        System.out.println(sb);
    }
}
