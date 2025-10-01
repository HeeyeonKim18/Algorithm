package fourweeks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Subsets {
    static int n = 1;

    public static void main(String[] args) {
        subsets(new int[] { 1, 2, 3 });
        subsets(new int[] { 2, 3, 5, 7 });
    }

    private static List<List<Integer>> subsets(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        backtrack(nums, 0, new ArrayList<>(), res);

        return res;
    }

    private static void backtrack(int[] nums, int start, List<Integer> path, List<List<Integer>> res) {
        res.add(new ArrayList<>(path));

        for (int i = start; i < nums.length; i++) {
            if (i > start && nums[i] == nums[i - 1])
                continue;
            path.add(nums[i]);
            backtrack(nums, i + 1, path, res);
            path.remove(path.size() - 1);
        }
    }
}
