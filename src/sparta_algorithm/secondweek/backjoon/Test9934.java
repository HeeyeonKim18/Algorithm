package sparta_algorithm.secondweek.backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Test9934 {

    static List<List<Integer>> levels;
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int k = Integer.parseInt(br.readLine());

        String[] input = br.readLine().split(" ");
        int[] nums = new int[input.length];
        for (int i = 0; i < input.length; i++) {
            nums[i] = Integer.parseInt(input[i]);
        }

        levels = new ArrayList<>();
        for(int i = 0; i < k; i++){
            levels.add(new ArrayList<>());
        }

        buildTree(nums, 0, nums.length - 1, 0);

        for (List<Integer> level : levels) {
            for(int value :level){
                System.out.print(value + " ");
            }
            System.out.println();
        }
    }

    public static void buildTree(int[] nums, int start, int end, int depth){
        if(start > end) return;

        int mid = (start + end) / 2;
        levels.get(depth).add(nums[mid]);

        buildTree(nums, start, mid - 1, depth + 1);
        buildTree(nums, mid + 1, end, depth + 1);
    }
}
