package fourweeks;

import java.util.LinkedList;
import java.util.Queue;

import fourweeks.common.TreeNode;

public class SymmetricTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1, new TreeNode(2, null, new TreeNode(3)), new TreeNode(2, null, new TreeNode(3)));
        System.out.println(isSymmetric(root));
        System.out.println(isSymmetricR(root));
    }

    private static boolean isSymmetric(TreeNode root) {
        if (root == null)
            return true;

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root.left);
        q.offer(root.right);

        while (!q.isEmpty()) {
            TreeNode a = q.poll();
            TreeNode b = q.poll();

            if (a == null && b == null)
                continue;
            if (a == null || b == null)
                return false;
            if (a.val != b.val)
                return false;

            q.offer(a.left);
            q.offer(b.right);
            q.offer(a.right);
            q.offer(b.left);
        }
        return true;
    }

    private static boolean isSymmetricR(TreeNode root) {
        return root == null || mirror(root.left, root.right);
    }

    private static boolean mirror(TreeNode a, TreeNode b) {
        if (a == null && b == null)
            return true;
        if (a == null || b == null)
            return false;
        if (a.val != b.val)
            return false;

        return mirror(a.left, b.right) && mirror(a.right, b.left);
    }
}
