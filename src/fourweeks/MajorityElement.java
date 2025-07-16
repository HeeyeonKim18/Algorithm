package fourweeks;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * The majority element is the element that appears more than ⌊n / 2⌋ times.
 * You may assume that the majority element always exists in the array.
 */
public class MajorityElement {
    public static void main(String[] args) {
        int[] nums = { 1, 2, 2, 1, 1, 2, 2 };
        System.out.println(majorityElement(nums));
        System.out.println(majorityElement1(nums));
        System.out.println(majorityElement2(nums));
    }

    private static int majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        int max = Integer.MIN_VALUE;
        int maxNum = 1;
        for (int i : map.keySet()) {
            if (max < map.get(i)) {
                max = map.get(i);
                maxNum = i;
            }
        }
        return maxNum;
    }

    // 배열의 절반을 넘겨야 majority라고 하는 조건 때문에
    // 해당 알고리즘을 사용할 수 있음
    private static int majorityElement1(int[] nums) {
        int candidate = 0;
        int count = 0;

        for (int num : nums) {
            if (count == 0) {
                candidate = num;
            }

            count += (num == candidate) ? 1 : -1;
        }

        return candidate;
    }

    // 조건에 배열 길이가 절반이 넘게 등장한다는 조건이 있기 때문에
    // 정렬 후 인덱스 n/2자리에 무조건 존재
    private static int majorityElement2(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        return nums[n / 2];
    }

}
