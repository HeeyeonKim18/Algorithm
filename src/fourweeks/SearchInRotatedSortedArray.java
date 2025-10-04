package fourweeks;

public class SearchInRotatedSortedArray {
    public static void main(String[] args) {
        System.out.println(search(new int[] { 0, 1, 2, 3, 4, 5, 6, 7 }, 3));
        ;
    }

    // 요구 조건 : 시간복잡도가 O(log n) => BinarySearch
    private static int search(int[] nums, int target) {

        int n = nums.length;
        int p = findPivot(nums);

        if (nums[p] <= target && target <= nums[n - 1]) {
            return binarySearch(nums, p, n - 1, target);
        } else {
            return binarySearch(nums, 0, p - 1, target);
        }

    }

    static int binarySearch(int[] nums, int low, int high, int target) {
        while (low < high) {
            int mid = low + (high - low) / 2;

            if (nums[mid] == target)
                return mid;

            else if (nums[mid] > target)
                high = mid - 1;

            else
                low = mid + 1;
        }

        return -1;
    }

    static int findPivot(int[] nums) {
        int left = 0, right = nums.length - 1;

        if (nums[left] <= nums[right])
            return 0;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] > nums[right])
                left = mid + 1;
            else
                right = mid;
        }
        return left;
    }
}
