package sparta_algorithm.secondweek.backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Test1874 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        Stack<Integer> stack = new Stack<>();
        boolean isPossible = true;
        int cur = 1;

        while(n--> 0){
            int num = Integer.parseInt(br.readLine());

            while(cur <= num){
                stack.push(cur++);
                sb.append("+").append("\n");
            }

            if(stack.peek() == num){
                stack.pop();
                sb.append("-").append("\n");
            }else{
                isPossible = false;
                break;
            } 
        }

        if(isPossible){
            System.out.println(sb);
        }else{
            System.out.println("NO");
        }
    }
}
