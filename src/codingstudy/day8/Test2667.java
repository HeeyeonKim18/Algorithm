package codingstudy.day8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class Test2667 {
    static int[][] map;
    static boolean[][] visited;
    static List<Integer> list = new ArrayList<>();
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        map = new int[n][n];

        for(int i = 0; i < n; i++){
            String s = br.readLine();
            for(int j = 0; j < n; j++){
                map[i][j] = s.charAt(j) - '0';
            }
        }

        StringBuilder sb = new StringBuilder();

        visited = new boolean[n][n];
        int[] dr = {-1, +1, 0, 0};
        int[] dc = {0, 0, -1, +1};


        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(!visited[i][j] && map[i][j] == 1)dfs(i, j, n, dr, dc);
            }
        }

        Collections.sort(list);
        sb.append(list.size()).append("\n");
        for(int i : list){
            sb.append(i).append("\n");
        }
        System.out.println(sb);
        
    }

    private static void dfs(int row, int col, int n, int[] dr, int[] dc){
        Stack<int[]> stack = new Stack<>();

        stack.push(new int[]{row,col});
        visited[row][col] = true;
        int count = 1;

        while(!stack.isEmpty()){
            int[] cur = stack.pop();
            int first = cur[0];
            int second = cur[1];
            for(int i = 0; i < 4; i++){
                int f = first + dr[i];
                int s = second + dc[i];
                if(f >= 0 && f < n && s >= 0 && s < n && map[f][s] == 1 && !visited[f][s]){
                    count++;
                    stack.push(new int[]{f, s});
                    visited[f][s] = true;
                }
            }
        }
        
        if(count > 0) list.add(count);

    }
}
