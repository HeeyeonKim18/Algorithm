package fourweeks;

import java.util.LinkedList;
import java.util.Queue;

import fourweeks.common.TreeNode;

public class SameTree {
    public static void main(String[] args) {
        TreeNode p = new TreeNode(1, new TreeNode(2), new TreeNode(3));
        TreeNode q = new TreeNode(1, new TreeNode(2), new TreeNode(3));
        System.out.println(isSameTree(p, q));
        System.out.println(isSameTreeBfs(p, q));
    }

    private static boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null)
            return true;
        if (p == null || q == null)
            return false;
        if (p.val != q.val)
            return false;

        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

    private static boolean isSameTreeBfs(TreeNode p, TreeNode q) {
        Queue<TreeNode[]> queue = new LinkedList<>();
        queue.add(new TreeNode[] { p, q });

        while (!queue.isEmpty()) {
            TreeNode[] nodes = queue.poll();
            TreeNode n1 = nodes[0];
            TreeNode n2 = nodes[1];

            if (n1 == null && n2 == null)
                continue;
            if (n1 == null || n2 == null)
                return false;
            if (n1.val != n2.val)
                return false;

            queue.add(new TreeNode[] { n1.left, n2.left });
            queue.add(new TreeNode[] { n1.right, n2.right });
        }
        return true;
    }

}
