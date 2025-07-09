package fourweeks;

// You are given the heads of two sorted linked lists list1 and list2.
// Merge the two lists into one sorted list. The list should be made by splicing together the nodes of the first two lists.
// Return the head of the merged linked list.
public class MergeTwoSortedLists {
    public static void main(String[] args) {
        ListNode node1 = new ListNode(1, new ListNode(2, new ListNode(4)));
        ListNode node2 = new ListNode(1, new ListNode(3, new ListNode(4)));
        MergeTwoSortedLists(node1, node2);
    }

    private static ListNode MergeTwoSortedLists(ListNode list1, ListNode list2){
        ListNode result = new ListNode();
        ListNode dummy = result;
        while(list1 != null && list2 != null){
            if(list1.val > list2.val){
                dummy.next = list2;
                list2 = list2.next;
            }else{
                dummy.next = list1;
                list1 = list1.next;
            }
            dummy = dummy.next;        
        }

        dummy.next = (list1 != null) ? list1:list2;
        return result.next;
    }

    public static class ListNode{
        int val;
        ListNode next;
        ListNode(){}
        ListNode(int val){ this.val = val; }
        ListNode(int val, ListNode next){ this.val = val; this.next = next; }
    }
}
