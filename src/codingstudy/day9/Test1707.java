package codingstudy.day9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class Test1707 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        while(t-- > 0){
            String[] input = br.readLine().split(" ");
            int v = Integer.parseInt(input[0]);
            int e = Integer.parseInt(input[1]);
            ArrayList<Integer>[] nums = new ArrayList[v+1];

            for(int i = 1; i <= v; i++){
                nums[i] = new ArrayList<>();
            }

            int[] color = new int[v + 1];
            Arrays.fill(color, -1);

            for(int i = 0; i < e; i++){
                String[] nodes = br.readLine().split(" ");
                int one = Integer.parseInt(nodes[0]);
                int two = Integer.parseInt(nodes[1]);

                nums[one].add(two);
                nums[two].add(one);
            }

            boolean isBipartite = true;

            for(int i = 1; i <= v; i++){
                if(color[i] == -1) {
                    if(!search(i, nums, color)){
                        isBipartite = false;
                        break;
                    }
                }
            }
            sb.append(isBipartite ? "YES":"NO").append("\n");
        }
        System.out.println(sb);
    }

    private static boolean search(int idx, ArrayList<Integer>[] nums, int[] color){
        Stack<Integer> stack = new Stack<>();
        stack.push(idx);
        color[idx] = 0;

        while(!stack.isEmpty()){
            int cur = stack.pop();

            for(int next:nums[cur]){
                if(color[next] == -1){
                    color[next] = 1 - color[cur];
                    stack.push(next);
                }else if(color[next] == color[cur]){
                    return false;
                }
            }
        }
        return true;
    }
}
