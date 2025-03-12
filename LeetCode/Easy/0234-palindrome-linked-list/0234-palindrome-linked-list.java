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

        ArrayDeque<Integer> numStack = new ArrayDeque<>();

        ListNode node = head;

        while (node != null) {
            numStack.push(node.val);
            node = node.next;
        }

        while (head != null) {
            if (head.val != numStack.poll()) {
                return false;
            }
            head = head.next;
        }
        return true;
    }
}