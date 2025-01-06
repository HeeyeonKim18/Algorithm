package sparta_algorithm.secondweek.backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;

public class Test10866 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        Deque<Integer> dq = new LinkedList<>();
        StringBuilder sb = new StringBuilder();

        while(n-- > 0){
            String str = br.readLine();

            if(str.startsWith("push_front")){
                int num = Integer.parseInt(str.split(" ")[1]);
                dq.addFirst(num);
            }else if(str.startsWith("push_back")){
                int num = Integer.parseInt(str.split(" ")[1]);
                dq.addLast(num);
            }else if(str.startsWith("pop_front")){
                if(dq.isEmpty()) sb.append(-1);
                else sb.append(dq.pollFirst());
                sb.append("\n");
            }else if(str.startsWith("pop_back")){
                if(dq.isEmpty()) sb.append(-1);
                else sb.append(dq.pollLast());
                sb.append("\n");
            }else if(str.startsWith("size")){
                sb.append(dq.size()).append("\n");
            }else if(str.startsWith("empty")){
                if(dq.isEmpty()) sb.append(1).append("\n");
                else sb.append(0).append("\n");
            }else if(str.startsWith("front")){
                if(dq.isEmpty()) sb.append(-1);
                else sb.append(dq.peekFirst());
                sb.append("\n");
            }else{
                if(dq.isEmpty()) sb.append(-1);
                else sb.append(dq.peekLast());
                sb.append("\n");
            }
        }

        System.out.println(sb);
    }
}
