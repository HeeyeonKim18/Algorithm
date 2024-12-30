package sparta_algorithm.fifthweek;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Dijkstra {

    static ArrayList<Node>[] graph;

    public static void main(String[] args) {
        int n = 5; // 정점 개수 (1-based index)
        graph = new ArrayList[n + 1]; // 정점 개수에 맞게 그래프 초기화

        for (int i = 0; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        graph[1].add(new Node(2, 10));
        graph[2].add(new Node(3, 1));
        graph[2].add(new Node(4, 2));
        graph[4].add(new Node(2, 3));
        graph[4].add(new Node(3, 9));
        graph[3].add(new Node(5, 4));
        graph[5].add(new Node(3, 6));
        graph[5].add(new Node(1, 7));
        graph[1].add(new Node(4, 5));
        graph[4].add(new Node(5, 2));
 
        dijkstra(n, 1);
    }

    private static void dijkstra(int n, int start){
        boolean[] visited = new boolean[n+1];
        int[] dist = new int[n+1];
        final int INF = Integer.MAX_VALUE;

        Arrays.fill(dist, INF);
        dist[start] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start, 0));

        while(!pq.isEmpty()){
            int nowVertex = pq.poll().index;

            if(visited[nowVertex]) continue;
            visited[nowVertex] = true;

            for(Node next: graph[nowVertex]){
                if(dist[next.index] > dist[nowVertex] + next.cost){
                    dist[next.index] = dist[nowVertex] + next.cost;
                    pq.offer(new Node(next.index, dist[next.index]));
                }
            }
        }

        for(int i = 1; i <= n; i++){
            if(dist[i] == INF) System.out.print(0 + " ");
            else System.out.print(dist[i] + " ");
        }
    }

    static class Node implements Comparable<Node>{
        int index;
        int cost;

        public Node(int index, int cost){
            this.index = index;
            this.cost = cost;
        }

        // 가중치 중심으로 우선순위가 정해지기 때문에 compareTo 오버라이딩
        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.cost, o.cost);
        }
    }
}

