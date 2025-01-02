package sparta_algorithm.secondweek.backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Test1158 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 입력 처리
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int k = Integer.parseInt(input[1]); 


        System.out.println(getList(n, k));
    }

    private static String getList(int n, int k){
        Queue<Integer> q = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        sb.append("<");
        
        for(int i = 1; i <= n; i++){
            q.offer(i);
        }

        while(!q.isEmpty()){

            for(int i = 1; i < k; i++){
                q.offer(q.poll());
            }
            
            sb.append(q.poll());
            if(!q.isEmpty()){
                sb.append(", ");
            }
        }

        sb.append(">");
        return sb.toString();
    }
}
