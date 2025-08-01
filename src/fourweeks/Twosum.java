package fourweeks;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Twosum{
    public static void main(String[] args){
        int[] nums = {3,2,4};
        int target = 6;

        int[] result = twoSum(nums, target);
        for (int i : result) {
            System.out.print(i + " ");
        }
    }

    public static int[] twoSum(int[] nums, int target){
        Map<Integer, Integer > map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if(map.containsKey(complement)){
                return new int[]{map.get(complement), i};
            }
            map.put(nums[i], i);
        }

        return new int[]{-1, -1};
    }
}