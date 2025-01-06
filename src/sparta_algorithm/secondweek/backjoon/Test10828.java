package sparta_algorithm.secondweek.backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
public class Test10828 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();

        while(n-- > 0){
            String s = br.readLine();
            if(s.startsWith("push")){
                int num = Integer.parseInt(s.split(" ")[1]);
                stack.push(num);
            }else if(s.startsWith("pop")){
                if(stack.isEmpty()) sb.append(-1).append("\n");
                else sb.append(stack.pop()).append("\n");
            }else if(s.startsWith("size")){
                sb.append(stack.size()).append("\n");
            }else if(s.startsWith("empty")){
                if(stack.isEmpty()) sb.append(1).append("\n");
                else sb.append(0).append("\n");
            }else if(s.startsWith("top")){
                if(stack.isEmpty()) sb.append(-1).append("\n");
                else sb.append(stack.peek()).append("\n");
            }
        }

        System.out.println(sb);
    }
}
