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
    public static boolean isPalindrome(ListNode head) {

        ArrayDeque<Integer> numStack = new ArrayDeque<>();

        ListNode node = head;

        while (node != null) {
            numStack.push(node.val);
            node = node.next;
        }

        while (!numStack.isEmpty() && numStack.size() > 1) {
            if (!numStack.pollFirst().equals(numStack.pollLast())) {
                return false;
            }
        }
        return true;
    }
}