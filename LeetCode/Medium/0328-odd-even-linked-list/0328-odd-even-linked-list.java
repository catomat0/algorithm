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

    public ListNode oddEvenList(ListNode head) {
        // 공백 리스트의 예외 처리
        if (head == null) {
            return null;
        }

        ListNode oddNode = head;
        ListNode evenNode = head.next;
        
        // 짝-진행 리스트의 맨 앞 노드를 따로 저장하여 while 문의 진행에 따른 위치가 아닌 짝-진행 리스트의 맨 앞 노드 지칭
        ListNode evenHead = evenNode;
        
        // 짝-진행 리스트가 최종 리스트의 마지막에 연결되기 때문에 evenNode 와 다음 노드가 null 이 아닐 때까지 진행
        while (evenNode != null && evenNode.next != null) {
            // 홀-짝 위치 노드의 연결
            oddNode.next = oddNode.next.next;
            evenNode.next = evenNode.next.next;
            // 홀-짝 노드의 진행
            oddNode = oddNode.next;
            evenNode = evenNode.next;
        }
        // (홀-진행 연결 노드의) 다음이 (짝-진행 연결 노드)의 시작과 연결
        oddNode.next = evenHead;
        
        return head;

    }
}