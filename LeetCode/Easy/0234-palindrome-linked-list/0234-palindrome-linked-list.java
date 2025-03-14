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
    public boolean isPalindrome(ListNode head) {

        ListNode node = head;
        int size = 0;
        StringBuilder front = new StringBuilder();
        StringBuilder rear = new StringBuilder();

        // size
        while (node != null) {
            size++;
            node = node.next;
        }

        // front
        node = head;
        for (int i = 0; i < size / 2; i++) {
            front.append(node.val);
            node = node.next;
        }
        // 홀수 사이즈 예외 처리 (중앙 값 제외) / node는 중앙 위치 중
        if (size % 2 == 1) {
            node = node.next;
        }

        // rear
        while (node != null) {
            rear.append(node.val);
            node = node.next;
        }

        // rear - front
        return front.compareTo(rear.reverse()) == 0;
    }
}