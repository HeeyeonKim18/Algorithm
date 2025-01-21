package codingstudy.day7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Test1697 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] s = br.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int k = Integer.parseInt(s[1]);

        System.out.println(bfs(n, k));
    }

    private static int bfs(int start, int target){
        int[] visited = new int[100001];
        Arrays.fill(visited, -1);

        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        visited[start] = 0;

        while(!q.isEmpty()){
            int cur = q.poll();

            if(cur == target){
                return visited[cur];
            }

            for(int next: new int[]{cur - 1, cur + 1, cur * 2}){
                if(next >= 0 && next <= 100000 && visited[next] == -1){
                    visited[next] = visited[cur] + 1;
                    q.offer(next);
                }
            }
        }
        return -1;
    }
}
