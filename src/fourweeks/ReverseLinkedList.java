package fourweeks;

public class ReverseLinkedList {

    // 단일 연결 리스트 노드 클래스 정의
    public static class ListNode {
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

    public static void main(String[] args) {
        // 예제: 1 -> 2 -> 3 -> 4 -> 5
        ListNode head = new ListNode(1,
                new ListNode(2,
                        new ListNode(3,
                                new ListNode(4,
                                        new ListNode(5)))));

        System.out.println("Original List:");
        printList(head);

        // 리스트 뒤집기
        ListNode reversedHead = reverseList(head);

        System.out.println("Reversed List:");
        printList(reversedHead);
    }

    // 연결 리스트를 뒤집는 메서드
    public static ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;

        while (curr != null) {
            ListNode next = curr.next; // 다음 노드 저장
            curr.next = prev; // 현재 노드의 next를 이전 노드로 변경
            prev = curr; // prev를 현재 노드로 이동
            curr = next; // curr을 다음 노드로 이동
        }
        return prev; // 새로운 head 반환
    }

    // 연결 리스트 출력 유틸리티
    public static void printList(ListNode head) {
        ListNode curr = head;
        while (curr != null) {
            System.out.print(curr.val);
            if (curr.next != null) {
                System.out.print(" -> ");
            }
            curr = curr.next;
        }
        System.out.println();
    }
}