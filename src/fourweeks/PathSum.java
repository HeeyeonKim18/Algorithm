package fourweeks;

import java.util.Stack;

import fourweeks.common.TreeNode;

public class PathSum {
    public static void main(String[] args) {
        TreeNode node = new TreeNode(5,
                new TreeNode(4,
                        new TreeNode(11,
                                new TreeNode(7),
                                new TreeNode(2)),
                        null),
                new TreeNode(8,
                        new TreeNode(13),
                        new TreeNode(4, null, new TreeNode(1))));
        int target = 22;
        System.out.println(hasPathSum(node, target));
    }

    private static boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null)
            return false;

        Stack<Node> s = new Stack<>();
        s.push(new Node(root, root.val));

        while (!s.isEmpty()) {
            Node node = s.pop();
            TreeNode treeNode = node.treeNode;
            int sum = node.sum;

            if (treeNode.left != null) {
                s.push(new Node(treeNode.left, sum + treeNode.left.val));
            }

            if (treeNode.right != null) {
                s.push(new Node(treeNode.right, sum + treeNode.right.val));
            }

            if (treeNode.left == null && treeNode.right == null) {
                if (sum == targetSum)
                    return true;
            }

        }
        return false;
    }

    static class Node {
        TreeNode treeNode;
        int sum;

        Node(TreeNode node, int sum) {
            this.treeNode = node;
            this.sum = sum;
        }
    }
}
