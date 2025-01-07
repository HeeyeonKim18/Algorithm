package sparta_algorithm.secondweek.backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class Test10845 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        LinkedList<Integer> q = new LinkedList<>();
        StringBuilder sb = new StringBuilder();

        while(n-- > 0){
            String input = br.readLine();

            if(input.startsWith("push")){
                int num = Integer.parseInt(input.split(" ")[1]);
                q.offer(num);
            }else if(input.startsWith("pop")){
                if(q.isEmpty()) sb.append(-1);
                else sb.append(q.poll());
                sb.append("\n");
            }else if(input.startsWith("size")){
                sb.append(q.size()).append("\n");
            }else if(input.startsWith("empty")){
                if(q.isEmpty()) sb.append(1);
                else sb.append(0);
                sb.append("\n");
            }else if(input.startsWith("front")){
                if(q.isEmpty()) sb.append(-1);
                else sb.append(q.peek());
                sb.append("\n");
            }else if(input.startsWith("back")){
                if(q.isEmpty()) sb.append(-1);
                else sb.append(q.peekLast());
                sb.append("\n");
            }
        }

        System.out.println(sb);
    }
}
