package fourweeks;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ContainDuplicate {
    public static void main(String[] args) {
        int[] nums = { 1, 2, 3, 4 };
        System.out.println(containDuplicate(nums));
        System.out.println(containDuplicate1(nums));
        System.out.println(containDuplicate2(nums));
    }

    private static boolean containDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i : nums) {
            if (set.contains(i))
                return true;
            set.add(i);
        }
        return false;
    }

    private static boolean containDuplicate1(int[] nums) {
        Arrays.sort(nums);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] == nums[i])
                return true;
        }
        return false;
    }

    private static boolean containDuplicate2(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i : nums) {
            set.add(i);
        }
        return set.size() < nums.length;
    }
}
