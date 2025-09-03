package fourweeks;

import fourweeks.common.TreeNode;

public class BalancedBinaryTree {
    public static void main(String[] args) {
        TreeNode node = new TreeNode(3, new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(7)));
        System.out.println(isBalanced(node));
    }

    // 각각의 루트 기준에서 자식 노드가 1을 넘어선 안된다.
    private static boolean isBalanced(TreeNode root) {
        return height(root) != -1;
    }

    private static int height(TreeNode node) {
        if (node == null)
            return 0;

        int lh = height(node.left);
        if (lh == -1)
            return -1;

        int rh = height(node.right);
        if (rh == -1)
            return -1;

        if (Math.abs(lh - rh) > 1)
            return -1;

        return Math.max(lh, rh) + 1;
    }

}
