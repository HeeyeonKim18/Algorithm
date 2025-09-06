package fourweeks;

import java.util.Arrays;
import java.util.Deque;
import java.util.List;
import java.util.ArrayDeque;
import java.util.ArrayList;

import fourweeks.common.Node;

public class NAryTreePreOrderTraversal {
    public static void main(String[] args) {
        Node root = new Node(1, Arrays.asList(
                new Node(3, Arrays.asList(
                        new Node(5, new ArrayList<>()),
                        new Node(6, new ArrayList<>()))),
                new Node(2, new ArrayList<>()),
                new Node(4, new ArrayList<>())));

        List<Integer> list = preorder(root);
        for (Integer i : list) {
            System.out.print(i + " ");
        }

        System.out.println();

        List<Integer> listRecur = preorderRecursive(root);
        for (Integer j : listRecur) {
            System.out.print(j + " ");
        }
    }

    private static List<Integer> preorder(Node root) {
        Deque<Node> stack = new ArrayDeque<>();
        List<Integer> result = new ArrayList<>();

        if (root == null)
            return result;

        stack.push(root);

        while (!stack.isEmpty()) {
            Node n = stack.poll();
            List<Node> l = n.children;

            result.add(n.val);

            for (int i = l.size() - 1; i >= 0; i--) {
                stack.push(l.get(i));
            }
        }

        return result;
    }

    private static List<Integer> preorderRecursive(Node root) {
        List<Integer> result = new ArrayList<>();
        preorderHelper(root, result);
        return result;
    }

    private static void preorderHelper(Node root, List<Integer> result) {
        if (root == null)
            return;

        result.add(root.val);

        for (Node child : root.children) {
            preorderHelper(child, result);
        }
    }
}
