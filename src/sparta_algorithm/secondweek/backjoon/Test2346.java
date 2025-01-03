package sparta_algorithm.secondweek.backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Test2346 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Deque<int[]> q = new ArrayDeque<>();
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i = 1; i <= n; i++){
            q.offer(new int[]{i, Integer.parseInt(st.nextToken())});
        }

        StringBuilder sb = new StringBuilder();
        while(!q.isEmpty()){
            int[] cur = q.poll();
            sb.append(cur[0]).append(" ");
            
            if(q.isEmpty()) break;

            int move = cur[1];
            if(move > 0){
                for(int i = 1; i < move; i++){
                    q.offer(q.poll());
                }
            }else{
                for(int i = 0; i < Math.abs(move); i++){
                    q.offerFirst(q.pollLast());
                }
            }
        }
        System.out.println(sb);
    }
}
