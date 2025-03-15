/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {

        // 공백 리스트 예외 처리
        if (head == null) return null;

        // 헤드 포인터 노드 초기화
        ListNode root = new ListNode(0);
        root.next = head;

        ListNode start = root;
        for (int i = 0; i < left - 1; i++) { // 변경 시작 지점으로 포인터 노드 시점 변경
            start = start.next;
        }
        ListNode end = start.next;

        // right <-> left 노드의 스왑을 통해서 해당 범위의 연결 리스트 뒤집기
        for (int i = 0; i < right - left; i++) {
            // start 노드 기준 다음 노드부터 변경하기에 스왑되는 노드 저장
            ListNode tmp = start.next;
            // 연결 스왑되는 노드들의 연결 해제 + 뒷 노드의 연결
            start.next = end.next;
            end.next = end.next.next;
            start.next.next = tmp;
        }

        return root.next; // 헤드 포인터 노드 제외 후 리턴
    }
}