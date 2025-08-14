package fourweeks;

import java.util.Stack;

public class PalindromeLinkedList {
    public static void main(String[] args) {
        ListNode node = new ListNode(1, new ListNode(2, new ListNode(2, new ListNode(1))));
        isPalidrome(node);

    }

    static boolean isPalidrome(ListNode head) {
        if (head == null | head.next == null)
            return true;

        ListNode fast = head;
        ListNode slow = head;
        Stack<Integer> stack = new Stack<>();

        while (fast != null && fast.next != null) {
            stack.push(slow.val);
            slow = slow.next;
            fast = fast.next.next;
        }

        if (fast != null) {
            slow = slow.next;
        }

        while (slow != null) {
            if (stack.isEmpty() && stack.pop() != slow.val)
                return false;
            slow = slow.next;
        }
        return true;
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
