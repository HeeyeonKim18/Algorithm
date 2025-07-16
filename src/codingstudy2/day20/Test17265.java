package codingstudy2.day20;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 연산 결과, 최소값과 최대값 구하기
 * 
 */
public class Test17265 {

    static char[][] map;
    static int max = 0;
    static int min = 0;
    static boolean[][] visited;
    static int[] dr = {1, 0, 0};
    static int[] dc = {0, +1, -1};
    static int n;
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        map = new char[n][n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < n; j++) {
                map[i][j] = st.nextToken().charAt(0);
            }
        }

        visited = new boolean[n][n];

        for(int i = 0; i < n; i++){
            if(Character.isDigit(map[0][i])){
                dfs(i);
            }
        }
    }

    static void dfs(int y){
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0, 1});
        visited[0][y] = true;

        while(!q.isEmpty()){
            int[] input = q.poll();
            int r = input[0];
            int c = input[1];

            for(int i = 0; i < 3; i++){
                int rr = r + dr[i];
                int cc = c + dc[i];
                if(rr >= 0 && cc >= 0 && rr < n && cc < n && !visited[rr][cc]){
                    
                }
            }
        }
    }
}
