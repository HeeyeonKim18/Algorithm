package fourweeks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class IntersectionOfTwoArrays {
    public static void main(String[] args) {
        int[] nums1 = { 1, 2, 2, 1 };
        int[] nums2 = { 2, 2 };
        int[] result = intersect(nums1, nums2);
        for (int i : result) {
            System.out.print(i + " ");
        }
    }

    private static int[] intersect(int[] nums1, int[] nums2) {
        // sort
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int n1 = nums1.length;
        int n2 = nums2.length;

        int i = 0;
        int j = 0;
        int k = 0;
        while (i < n1 && j < n2) {
            if (nums1[i] == nums2[j]) {
                nums1[k++] = nums1[i];
                i++;
                j++;
            } else if (nums1[i] < nums2[j]) {
                i++;
            } else {
                j++;
            }
        }

        return Arrays.copyOfRange(nums1, 0, k);
    }

    private static int[] intersect1(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums1) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums2.length; i++) {
            if (map.containsKey(nums2[i]) && map.get(nums2[i]) > 0) {
                map.replace(nums2[i], map.get(nums2[i]) - 1);
                list.add(nums2[i]);
            }
        }
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}
