package fourweeks;

import fourweeks.common.TreeNode;

public class ConvertSortedArrayToBinarySearchTree {
    public static void main(String[] args) {
        int[] nums = { -10, -3, 0, 5, 9 };
        sortedArrayToBST(nums);
    }

    private static TreeNode sortedArrayToBST(int[] nums) {
        return toBinary(nums, 0, nums.length - 1);
    }

    private static TreeNode toBinary(int[] nums, int left, int right) {
        if (left > right)
            return null;

        int mid = (left + right) / 2;
        TreeNode root = new TreeNode(nums[mid]);

        root.left = toBinary(nums, left, mid - 1);
        root.right = toBinary(nums, mid + 1, right);

        return root;
    }
}
