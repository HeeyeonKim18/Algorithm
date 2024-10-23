package Algorithm.src.leetcode.arrays;
/*
    Given two integer arrays nums1 and nums2, 
    return an array of their intersection. 
    Each element in the result must appear as many times as 
    it shows in both arrays and you may return the result in any order.
    
    Example 1:
    Input: nums1 = [1,2,2,1], nums2 = [2,2]
    Output: [2,2]
    
    Example 2:
    Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
    Output: [4,9]
    Explanation: [9,4] is also accepted.
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class IntersectionArr {
    public static void main(String[] args) {
        int[] nums1 = { 4, 9, 5 };
        int[] nums2 = { 9,4,9,8,4 };
        
        List<Integer> list = new ArrayList<>();
        
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums1.length; i++) {
            map.put(nums1[i], map.getOrDefault(nums1[i], 0) + 1);
        }

        for (int i = 0; i < nums2.length; i++) {
            if(map.containsKey(nums2[i]) && map.get(nums2[i]) > 0){
                list.add(nums2[i]);
                map.replace(nums2[i], map.get(nums2[i]) - 1);
                System.out.println(nums2[i] + " : " + map.get(nums2[i]));
            }
        }
        list.stream().mapToInt(Integer::intValue).toArray();
    }
}