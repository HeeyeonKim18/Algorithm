package fourweeks;

public class IntersectionOfTwoLinkedList {
    public static void main(String[] args) {
        ListNode shareNode = new ListNode(3, new ListNode(1));
        ListNode node = new ListNode(1, new ListNode(2, shareNode));
        System.out.println(shareNode == node.next.next);

    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null)
            return null;

        ListNode pA = headA, pB = headB;
        while (pA != pB) {
            pA = (pA == null) ? headB : pA.next;
            pB = (pB == null) ? headA : pB.next;
        }
        return pA;
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
