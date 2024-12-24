package sparta_algorithm.thirdweek;

import java.util.LinkedList;
import java.util.Queue;

public class BfsTest {
     // 방문처리에 사용 할 배열선언
	static boolean[] vistied = new boolean[11];
	// 그림예시 그래프의 연결상태를 2차원 배열로 표현
	static int[][] graph = {{}, {2,5,9}, {1,3}, {2,4}, {3}, {1,6,8}, {5,7}, {6}, {5}, {1,10}, {9}};

    public static void main(String[] args) {
        bfs_queue(1);
    }

    private static void bfs_queue(int start){
        Queue<Integer> queue = new LinkedList<>();
        // 시작 노드 큐에 추가 및 방문 처리리
        queue.offer(start);
        vistied[start] = true;

        while(!queue.isEmpty()){
            int cur = queue.poll();
            vistied[cur] = true;
            System.out.print(cur + " ");

            for(int neighbor : graph[cur]){
                if(!vistied[neighbor]){
                    queue.offer(neighbor);
                }
            }
        }
    }
}
