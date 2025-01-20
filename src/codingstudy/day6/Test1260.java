package codingstudy.day6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Test1260 {
    private static ArrayList<Integer>[] graph;
    private static boolean[] visited_dfs;
    private static boolean[] visited_bfs;
    private static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int v = Integer.parseInt(st.nextToken());

        graph = new ArrayList[n+1];
        visited_dfs = new boolean[n+1];
        visited_bfs = new boolean[n+1];
        sb = new StringBuilder();

        for(int i = 1; i <= n; i++){
            graph[i] = new ArrayList<>();
        }

        for(int i = 0; i < m; i++){
            String[] input = br.readLine().split(" ");
            int from = Integer.parseInt(input[0]);
            int to = Integer.parseInt(input[1]);

            graph[from].add(to);
            graph[to].add(from);
        }

        for (int i = 1; i <= n; i++) {
            Collections.sort(graph[i]);
        }


        dfs(v);
        sb.append("\n");
        bfs(v);
        System.out.println(sb);
    }

    private static void dfs(int v){
        visited_dfs[v] = true;
        sb.append(v + " ");

        for (int i : graph[v]) {
            if(!visited_dfs[i]) dfs(i);
        }
    }

    private static void bfs(int v){
        Queue<Integer> q = new LinkedList<>();
        q.offer(v);
        visited_bfs[v] = true;

        while(!q.isEmpty()){
            int cur = q.poll();
            sb.append(cur + " ");
            for(int i : graph[cur]){
                if(!visited_bfs[i]){
                    q.offer(i);
                    visited_bfs[i] = true;
                }
            }
        }
    }
}
