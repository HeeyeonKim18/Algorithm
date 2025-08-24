package fourweeks;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import fourweeks.common.TreeNode;

public class BinaryTreeLevelOrderTraversal {
    public static void main(String[] args) {
        TreeNode node = new TreeNode(3, new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(7)));
        List<List<Integer>> list = levelOrder(node);
        for (List<Integer> list2 : list) {
            System.out.print("[");
            for (Integer i : list2) {
                System.out.print(i + " ");
            }
            System.out.println("]");
        }
    }

    private static List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null)
            return Collections.emptyList();

        List<List<Integer>> result = new ArrayList<>();
        int level = 0;
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(root, level));

        while (!q.isEmpty()) {
            Pair pair = q.poll();
            TreeNode node = pair.node;
            int nodeLevel = pair.level;

            if (result.size() == nodeLevel) {
                result.add(new ArrayList<>());
            }
            result.get(nodeLevel).add(node.val);

            if (node.left != null)
                q.offer(new Pair(node.left, nodeLevel + 1));
            if (node.right != null)
                q.offer(new Pair(node.right, nodeLevel + 1));

        }
        return result;
    }

    static class Pair {
        TreeNode node;
        int level;

        Pair(TreeNode node, int level) {
            this.node = node;
            this.level = level;
        }
    }
}
