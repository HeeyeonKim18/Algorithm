package sparta_algorithm.secondweek.backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Test1068 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int[] tree = new int[n];

        for(int i = 0; i < tree.length; i++){
            tree[i] = Integer.parseInt(st.nextToken());
        }

        int r = Integer.parseInt(br.readLine());

        countLeafNodes(n, tree, r);
    }

    private static void countLeafNodes(int n, int[] tree, int r){
        // 트리 구성
        List<List<Integer>> t = new ArrayList<>();
        for(int i = 0; i < n; i++){
            t.add(new ArrayList<>());
        }

        int root = -1;
        for(int c = 0; c < n; c++){
            int parent = tree[c];
            if(parent == -1){
                root = c;
            }else{
                t.get(parent).add(c);
            }
        }
        if(r == root){
            System.out.println(0);
            return;
        }

        System.out.println(dfsCntLeaves(t, root, r));
    }

    private static int dfsCntLeaves(List<List<Integer>> tree, int node, int r){
        if(node == r) return 0;

        List<Integer> children = tree.get(node);
        if(children.isEmpty()) return 1;

        int leafCnt = 0;
        boolean isLeaf = true;
        for(int child : children){
            int result = dfsCntLeaves(tree, child, r);
            if(result > 0) isLeaf = false;
            leafCnt += result;
        }

        if(isLeaf) return 1;
        return leafCnt;
    }
    
}
