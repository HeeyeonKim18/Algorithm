package fourweeks;

public class BinarySearch {
    public static void main(String[] args) {
        int[] nums = { -1, 0, 3, 5, 9, 12 };
        int target = 2;
        System.out.println(search(nums, target));
    }

    private static int search(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;

        while (start <= end) {
            // overflow 방지
            int mid = start + (end - start) / 2;
            // target과 nums[mid]가 동일한 경우
            if (nums[mid] == target)
                return mid;
            // target 값이 더 클 경우 start 값을 mid + 1로 변경
            else if (nums[mid] < target) {
                start = mid + 1;
                // target 값이 작을 경우 end 값을 mid - 1 로 변경
            } else {
                end = mid - 1;
            }
        }
        return -1;
    }
}
