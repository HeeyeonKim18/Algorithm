package fourweeks;

import java.util.Stack;

import fourweeks.common.TreeNode;

/**
 * 3가지 방법이 있다.
 * DFS, 재귀, BFS
 */
public class MaximumDepthOfBinaryTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3, new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(7)));
        TreeNode root1 = new TreeNode(3, null, new TreeNode(2));
        System.out.println(maxDepth(root));
        System.out.println(maxDepth(root1));
        System.out.println(recursive(root));
        System.out.println(recursive(root1));
    }

    private static int maxDepth(TreeNode root) {
        if (root == null)
            return 0;

        int max = 0;
        Stack<Pair> stack = new Stack<>();
        stack.push(new Pair(root, 1));

        while (!stack.isEmpty()) {
            Pair cur = stack.pop();
            TreeNode node = cur.node;
            int depth = cur.depth;
            if (node == null)
                continue;

            max = Math.max(max, depth);

            if (node.left != null) {
                stack.push(new Pair(node.left, depth + 1));
            }
            if (node.right != null) {
                stack.push(new Pair(node.right, depth + 1));
            }
        }
        return max;
    }

    static class Pair {
        TreeNode node;
        int depth;

        Pair(TreeNode n, int d) {
            node = n;
            depth = d;
        }
    }

    private static int recursive(TreeNode root) {
        if (root == null)
            return 0;
        return 1 + Math.max(recursive(root.left), recursive(root.right));
    }
}
