package fourweeks;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

import fourweeks.common.TreeNode;

public class DiameterOfBinaryTree {

    private static int ans; // 지름(간선수);

    public static void main(String[] args) {
        TreeNode node = new TreeNode(1, new TreeNode(2, new TreeNode(4), new TreeNode(5)), new TreeNode(3));
        System.out.println(diameterOfBinaryTree(node));
        System.out.println(diameterOfBinaryTreeStack(node));
    }

    private static int diameterOfBinaryTree(TreeNode root) {
        ans = 0;
        depth(root);
        return ans;
    }

    private static int depth(TreeNode root) {
        if (root == null)
            return 0;

        int ld = depth(root.left);
        int rd = depth(root.right);

        ans = Math.max(ans, ld + rd);

        return Math.max(ld, rd) + 1;
    }

    private static int diameterOfBinaryTreeStack(TreeNode root) {
        if (root == null)
            return 0;

        Deque<Frame> stack = new ArrayDeque<>();
        Map<TreeNode, Integer> depth = new HashMap<>();
        int ans1 = 0;

        stack.push(new Frame(root, false));
        while (!stack.isEmpty()) {
            Frame f = stack.pop();
            TreeNode n = f.node;
            if (n == null)
                continue;

            if (!f.visited) {
                stack.push(new Frame(n, true));
                stack.push(new Frame(n.right, false));
                stack.push(new Frame(n.left, false));
            } else {
                int ld = depth.getOrDefault(n.left, 0);
                int rd = depth.getOrDefault(n.right, 0);
                ans1 = Math.max(ans1, ld + rd);
                depth.put(n, Math.max(ld, rd) + 1);
            }
        }
        return ans1;

    }

    static class Frame {
        TreeNode node;
        boolean visited;

        Frame(TreeNode n, boolean v) {
            node = n;
            visited = v;
        }
    }
}
