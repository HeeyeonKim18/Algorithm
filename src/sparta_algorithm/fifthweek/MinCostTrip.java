package sparta_algorithm.fifthweek;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class MinCostTrip {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int r = sc.nextInt();
        sc.nextLine();

        List<Node>[] nodes = new ArrayList[n + 1];

        for (int i = 1; i <= n; i++) {
            nodes[i] = new ArrayList<>();
        }

        for (int i = 0; i < r; i++) {
            int from = sc.nextInt();
            int to = sc.nextInt();
            int cost = sc.nextInt();

            nodes[from].add(new Node(to, cost));
        }

        int start = sc.nextInt();
        int last = sc.nextInt();

        int result = dijkstra(nodes, n, start, last);
        System.out.println(result);
    }

    private static int dijkstra(List<Node>[] nodes, int n, int start, int last) {
        boolean[] visited = new boolean[n + 1];
        int[] dist = new int[n + 1];

        final int INF = Integer.MAX_VALUE;
        Arrays.fill(dist, INF);
        dist[start] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start, 0));

        while (!pq.isEmpty()) {
            int curIdx = pq.poll().index;

            if (visited[curIdx])
                continue;
            visited[curIdx] = true;

            for (Node next : nodes[curIdx]) {
                if (dist[curIdx] + next.cost < dist[next.index]) {
                    dist[next.index] = dist[curIdx] + next.cost;
                    pq.offer(new Node(next.index, dist[next.index]));
                }
            }
        }

        return dist[last];
    }

    static class Node implements Comparable<Node> {
        int index;
        int cost;

        public Node(int index, int cost) {
            this.index = index;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.cost, o.cost);
        }
    }
}
