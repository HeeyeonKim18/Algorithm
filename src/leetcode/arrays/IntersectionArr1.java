package Algorithm.src.leetcode.arrays;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class IntersectionArr1 {
    public static void main(String[] args) {
        int[] nums1 = {1,2,2,1};
        int[] nums2 = {2,2};

        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int n = nums1.length, m = nums2.length;
        int i = 0, j = 0;

        List<Integer> list = new ArrayList<>();
        while(i < n && j < m){
            int a = nums1[i], b = nums2[j];
            if(a==b){
                list.add(a);
                i++;
                j++;
            }else if(a < b){
                i++;
            }else{
                j++;
            }
        }
        list.stream().mapToInt(Integer::intValue).toArray();
    }
}
