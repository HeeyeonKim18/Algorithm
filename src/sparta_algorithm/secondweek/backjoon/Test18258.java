package sparta_algorithm.secondweek.backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Test18258 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        Queue<Integer> q = new LinkedList<>();
        StringBuilder sb = new StringBuilder();

        int back = -1;
        while(n-- > 0){
            String command = br.readLine();

            if(command.startsWith("push")){
                int x = Integer.parseInt(command.split(" ")[1]);
                q.offer(x);
                back = x;
            }else if(command.startsWith("pop")){
                if(q.isEmpty()) sb.append(-1);
                else sb.append(q.poll());
                sb.append("\n");
            }else if(command.startsWith("size")){
                sb.append(q.size()).append("\n");
            }else if(command.startsWith("empty")){
                if(q.isEmpty()) sb.append(1);
                else sb.append(0);
                sb.append("\n");
            }else if(command.startsWith("front")){
                if(q.isEmpty()) sb.append(-1);
                else sb.append(q.peek());
                sb.append("\n");
            }else{
                sb.append(back).append("\n");
            }
        }

        System.out.println(sb.toString());
    }
}
