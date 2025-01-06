package sparta_algorithm.secondweek.backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class test2893 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        Stack<int[]> stack = new Stack<>();

        StringBuilder sb = new StringBuilder();
        for(int i = 1; i <= n; i++){
            int height = Integer.parseInt(st.nextToken());

            while(!stack.isEmpty() && stack.peek()[0] < height){
                stack.pop();
            }

            if(stack.isEmpty()){
                sb.append(0).append("\n");
            }else{
                sb.append(stack.peek()[1]).append("\n");
            }

            stack.push(new int[]{height, i} );
        }

        System.out.println(sb);

    }
}
