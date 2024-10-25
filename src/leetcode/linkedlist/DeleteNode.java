package leetcode.linkedlist;

import java.util.LinkedList;

public class DeleteNode {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    
    }
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
