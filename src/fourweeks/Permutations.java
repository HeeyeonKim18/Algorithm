package fourweeks;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Permutations {
    public static void main(String[] args) {
        permute(new int[] { 1, 2, 3 });
        permuteSwap(new int[] { 1, 2, 4 });
    }

    private static List<List<Integer>> permute(int[] nums) {
        Arrays.sort(nums); // 중복된 수를 처리
        List<List<Integer>> res = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        Deque<Integer> path = new ArrayDeque<>();
        dfs(nums, used, path, res);
        return res;
    }

    private static void dfs(int[] nums, boolean[] used, Deque<Integer> path, List<List<Integer>> res) {
        if (path.size() == nums.length) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (used[i])
                continue;
            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1])
                continue;

            used[i] = true;
            path.addLast(nums[i]);
            dfs(nums, used, path, res);
            path.removeLast();
            used[i] = false;
        }
    }

    private static List<List<Integer>> permuteSwap(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        backtrack(nums, 0, res);
        return res;
    }

    private static void backtrack(int[] a, int idx, List<List<Integer>> res) {
        if (idx == a.length) {
            List<Integer> one = new ArrayList<>(a.length);
            for (int v : a)
                one.add(v);
            res.add(one);
            return;
        }

        Set<Integer> usedAtLevel = new HashSet<>();
        for (int i = idx; i < a.length; i++) {
            if (!usedAtLevel.add(a[i]))
                continue;
            swap(a, idx, i);
            backtrack(a, idx + 1, res);
            swap(a, idx, i);
        }
    }

    private static void swap(int[] a, int i, int j) {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }
}