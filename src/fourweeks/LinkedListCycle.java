package fourweeks;

public class LinkedListCycle {
    public static void main(String[] args) {
        // 예제 1: 사이클 없는 리스트
        ListNode node3 = new ListNode(3);
        ListNode node2 = new ListNode(2, node3);
        ListNode node1 = new ListNode(1, node2);
        node3.next = null; // 끝

        System.out.println("예제 1 (사이클 없음): " + hasCycle(node1)); // false 기대

        // 예제 2: 사이클 있는 리스트
        ListNode node6 = new ListNode(6);
        ListNode node5 = new ListNode(5, node6);
        ListNode node4 = new ListNode(4, node5);
        node6.next = node4; // 사이클 생성 (6 -> 4)

        System.out.println("예제 2 (사이클 있음): " + hasCycle(node4)); // true 기대

        // 예제 3: 노드 1개, 사이클 없음
        ListNode singleNode = new ListNode(10);
        System.out.println("예제 3 (노드 1개, 사이클 없음): " + hasCycle(singleNode)); // false 기대

        // 예제 4: 노드 1개, 자기자신을 가리키는 사이클
        singleNode.next = singleNode;
        System.out.println("예제 4 (노드 1개, 사이클 있음): " + hasCycle(singleNode)); // true 기대
    }

    private static boolean hasCycle(ListNode head){
        if(head == null || head.next == null) return false;
        ListNode fastPointer = head.next;
        ListNode slowPointer = head;
        while(fastPointer != null && fastPointer.next != null){
            if(fastPointer == slowPointer) return true;
            fastPointer = fastPointer.next.next;
            slowPointer = slowPointer.next;
        }
        return false;
    }
    public static class ListNode{
        int val;
        ListNode next;
        ListNode(){}
        ListNode(int val){ this.val = val; }
        ListNode(int val, ListNode next){ this.val = val; this.next = next; }
    }
}
