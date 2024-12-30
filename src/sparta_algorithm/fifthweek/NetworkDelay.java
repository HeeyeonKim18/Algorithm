package sparta_algorithm.fifthweek;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class NetworkDelay {
    static ArrayList<Node>[] times;

    public static void main(String[] args) {
        int n = 4;
        int k = 2;

        times = new ArrayList[n+1];

        for (int i = 0; i <= n; i++) {
            times[i] = new ArrayList<>();
        }

        times[2].add(new Node(1, 1));
        times[2].add(new Node(3, 1));
        times[3].add(new Node(4, 1));

        System.out.println(dijkstra(n, k));;
    }

    private static int dijkstra(int n, int start){
        boolean[] visited = new boolean[n+1];
        int[] dist = new int[n+1];
        final int INF = Integer.MAX_VALUE;

        Arrays.fill(dist, INF);
        dist[start] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start, 0));

        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            int idx = cur.index;

            if(visited[idx]) continue;
            visited[idx] = true;

            for (Node next : times[idx]) {
                int newIdx = next.index;
                int newCost = dist[idx] + next.cost;
                if(newCost < dist[newIdx]){
                    dist[newIdx] = newCost;
                    pq.offer(new Node(newIdx, dist[newIdx]));
                }
            }
        }

        int max = Integer.MIN_VALUE;
        for(int i = 1; i < dist.length; i++){
            if(dist[i] == INF) return -1;
            max = Integer.max(dist[i], max);
        }
        return max;
    }

    static class Node implements Comparable<Node>{
        int index;
        int cost;

        public Node(int index, int cost){
            this.index = index;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.cost, o.cost);
        }
    }
}
