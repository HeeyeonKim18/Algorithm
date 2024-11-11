package leetcode.linkedlist;

public class PalindromeLinkedList1 {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
         
    }
    
    public boolean isPalindrome(ListNode head) {
        if(head == null) return true;
        
        ListNode fast = head, slow = head;
        
        while(fast.next != null && fast.next.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        
        ListNode firstHalfHead = head;
        ListNode secondHalfHead = reverse(slow.next);
        
        while(firstHalfHead != null && secondHalfHead != null){
            if(firstHalfHead.val != secondHalfHead.val) return false;
            firstHalfHead = firstHalfHead.next;
            secondHalfHead = secondHalfHead.next;
        }
        return true;
    }
    
    private ListNode reverse(ListNode head){
        ListNode newHead = null;
        while(head != null){
            ListNode next = head.next;
            head.next = newHead;
            newHead = head;
            head = next;
        }
        return newHead;
    }
}
