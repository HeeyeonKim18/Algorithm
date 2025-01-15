package sparta_algorithm.thirdweek.backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Test11724 {
    static ArrayList<Integer>[] graph;
    static boolean[] visited ;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);

<<<<<<< HEAD
        graph = new ArrayList[n+1];
        visited = new boolean[n+1];
        for(int i = 1; i <= n; i++){
            graph[i] = new ArrayList<>();
=======
        int[][] nums = new int[n + 1][1];
        vistied = new boolean[n+1];
        while(m-- > 0){
            String[] str = br.readLine().split(" ");
            int u = Integer.parseInt(str[0]);
            int v = Integer.parseInt(str[1]);
            nums[u][0] = v;
            
>>>>>>> 8289860 (코테 스터디 미들러)
        }

        for(int i = 0; i < m; i++){
            String[] edge = br.readLine().split(" ");
            int u = Integer.parseInt(edge[0]);
            int v = Integer.parseInt(edge[1]);

            graph[u].add(v);
            graph[v].add(u);
        }

        int cnt = 0;
        for(int i = 1; i <= n; i++){
            if(!visited[i]){
                cnt++;
                dfs(i);
            }
        }

        System.out.println(cnt);
    }

    private static void dfs(int idx){
        visited[idx] = true;

        for(int i : graph[idx]){
            if(!visited[i]){
                dfs(i);
            }
        }
    }
}
