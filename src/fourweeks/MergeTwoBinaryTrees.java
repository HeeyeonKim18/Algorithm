package fourweeks;

import java.util.Stack;

import fourweeks.common.TreeNode;

public class MergeTwoBinaryTrees {
    public static void main(String[] args) {
        TreeNode root1 = new TreeNode(1, new TreeNode(3, new TreeNode(5), null), new TreeNode(2));
        TreeNode root2 = new TreeNode(2, new TreeNode(1, null, new TreeNode(4)),
                new TreeNode(3, null, new TreeNode(7)));
        mergeTrees(root1, root2);
        mergeTreesR(root1, root2);
    }

    private static TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if (root1 == null)
            return root2;
        if (root2 == null)
            return root1;

        Stack<TreeNode[]> s = new Stack<>();
        s.push(new TreeNode[] { root1, root2 });

        while (!s.isEmpty()) {
            TreeNode[] nodes = s.pop();
            TreeNode n1 = nodes[0];
            TreeNode n2 = nodes[1];
            if (n2 == null)
                continue;

            n1.val += n2.val;

            if (n2.left != null) {
                if (n1.left == null) {
                    n1.left = n2.left;
                } else {
                    s.push(new TreeNode[] { n1.left, n2.left });
                }
            }

            if (n2.right != null) {
                if (n1.right == null) {
                    n1.right = n2.right;
                } else {
                    s.push(new TreeNode[] { n1.right, n2.right });
                }
            }
        }
        return root1;
    }

    private static TreeNode mergeTreesR(TreeNode root1, TreeNode root2) {
        if (root1 == null)
            return root2;
        if (root2 == null)
            return root1;

        root1.val += root2.val;
        root1.left = mergeTreesR(root1.left, root2.left);
        root1.right = mergeTreesR(root1.right, root2.right);

        return root1;
    }
}
