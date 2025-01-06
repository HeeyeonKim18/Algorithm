package sparta_algorithm.secondweek.backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Test9012 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        while(t-- > 0){
            char[] c = br.readLine().toCharArray();

            Stack<Character> stack = new Stack<>();

            boolean result = putStack(c, stack);

            if(!stack.isEmpty() || !result) sb.append("NO").append("\n");
            else sb.append("YES").append("\n");
        }

        System.out.println(sb);
    }

    private static boolean putStack(char[] c, Stack<Character> stack){
        for(int i = 0; i < c.length; i++){
            if(c[i] == '(') stack.push(c[i]);
            else{
                if(stack.isEmpty()) return false;
                stack.pop();
            }
        }
        return true;
    }
}
