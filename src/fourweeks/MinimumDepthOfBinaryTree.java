package fourweeks;

import java.util.LinkedList;
import java.util.Queue;

import fourweeks.common.TreeNode;

public class MinimumDepthOfBinaryTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3, new TreeNode(9, new TreeNode(11), new TreeNode(8)),
                new TreeNode(20, new TreeNode(15), new TreeNode(7)));
        System.out.println(minDepth(root));
        System.out.println(minDepthBFS(root));
    }

    private static int minDepth(TreeNode root) {
        if (root == null)
            return 0;

        if (root.left == null && root.right == null)
            return 1;
        if (root.left == null)
            return minDepth(root.right) + 1;
        if (root.right == null)
            return minDepth(root.left) + 1;

        return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
    }

    private static int minDepthBFS(TreeNode root) {
        if (root == null)
            return 0;

        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(root, 1));

        while (!q.isEmpty()) {
            Pair p = q.poll();
            TreeNode n = p.node;
            int d = p.depth;

            if (n.left == null && n.right == null)
                return d;
            if (n.left != null) {
                q.add(new Pair(n.left, d + 1));
            }
            if (n.right != null) {
                q.add(new Pair(n.right, d + 1));
            }
        }
        return 0;
    }

    private static class Pair {
        TreeNode node;
        int depth;

        Pair(TreeNode node, int depth) {
            this.node = node;
            this.depth = depth;
        }
    }
}
