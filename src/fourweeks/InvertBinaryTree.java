package fourweeks;

import java.util.Stack;

import fourweeks.common.TreeNode;

public class InvertBinaryTree {
    public static void main(String[] args) {
        TreeNode node = new TreeNode(4, new TreeNode(2, new TreeNode(1), new TreeNode(3)),
                new TreeNode(7, new TreeNode(6), new TreeNode(9)));
        System.out.println(invertTree(node));
        System.out.println(invertTreeR(node));
    }

    private static TreeNode invertTree(TreeNode root) {
        if (root == null)
            return root;

        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);

        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();

            TreeNode leftNode = node.left;
            TreeNode rightNode = node.right;

            node.left = rightNode;
            node.right = leftNode;

            if (node.left != null) {
                stack.push(node.left);
            }

            if (node.right != null) {
                stack.push(node.right);
            }

        }
        return root;
    }

    private static TreeNode invertTreeR(TreeNode root) {
        if (root == null)
            return null;

        TreeNode left = invertTreeR(root.left);
        TreeNode right = invertTreeR(root.right);

        root.left = right;
        root.right = left;

        return root;
    }

}
