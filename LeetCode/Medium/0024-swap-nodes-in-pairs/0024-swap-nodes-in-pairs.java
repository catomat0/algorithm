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
    public ListNode swapPairs(ListNode head) {
        // 헤드포인터 노드 선언 (깡통)
        ListNode node = new ListNode(0);
        ListNode root = node;
        
        // 1번 노드를 가르키는 헤드포인터 위치 설정
        node.next = head;

        while (node.next != null && node.next.next != null) {
            // 헤드 포인터 기준 / 1번 노드 - 2번 노드 시작
            ListNode front = node.next;
            ListNode back = node.next.next;
            // 순서 스왑
            front.next = back.next;
            node.next = back;
            node.next.next = front;
            // 커플 단위로 시작
            node = node.next.next;
        }
        // 헤드 포인터 노드 제외 후 리턴
        return root.next;
    }
}