package codingstudy2.day17;

import java.io.*;
import java.util.*;

public class Test18126 {
    static ArrayList<int[]>[] graph;
    static boolean[] visited;
    static long maxDistance = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        graph = new ArrayList[n + 1];
        visited = new boolean[n + 1];

        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < n - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            graph[u].add(new int[] { v, w });
            graph[v].add(new int[] { u, w });
        }

        dfs(1, 0);
        System.out.println(maxDistance);
    }

    static void dfs(int node, long distance) {
        visited[node] = true;
        maxDistance = Math.max(maxDistance, distance);

        for (int[] next : graph[node]) {
            int nextNode = next[0];
            int weight = next[1];

            if (!visited[nextNode]) {
                dfs(nextNode, distance + weight);
            }
        }
    }
}