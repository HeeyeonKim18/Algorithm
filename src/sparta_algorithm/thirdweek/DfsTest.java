package sparta_algorithm.thirdweek;

import java.util.Stack;

public class DfsTest {

    // 방문처리에 사용 할 배열선언
	static boolean[] vistied = new boolean[11];
	static boolean[] stackVistied = new boolean[11];
	// 그림예시 그래프의 연결상태를 2차원 배열로 표현
	static int[][] graph = {{}, {2,5,9}, {1,3}, {2,4}, {3}, {1,6,8}, {5,7}, {6}, {5}, {1,10}, {9}};

    public static void main(String[] args) {
        System.out.println("recursive = >");
        recursiveDfs(1);
        System.out.println("\nstack => ");
        stackDfs(1);
    }

    private static void recursiveDfs(int idx){
        if(vistied[idx]) return;

        vistied[idx] = true;
        System.out.print(idx + " ");

        for(int node : graph[idx]){
            if(!vistied[node]) recursiveDfs(node);
        }
    }

    private static void stackDfs(int idx){
        Stack<Integer> stack = new Stack<>();

        stack.push(idx);

        while(!stack.isEmpty()){
            int cur = stack.pop();
            System.out.print(cur + " ");
            stackVistied[cur] = true;

            for(int i:graph[cur]){
                if(!stackVistied[i]){
                    stack.push(i);
                }
            }
        }
    }
}
