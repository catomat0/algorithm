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
    /**
     * -stack 활용하여 문제해결-
     * -> 왜 - 단방향 연결리스트를 통한 덧셈을 실행 후 오름수가 뒤로 넘어가니 계산을 하고 스택에 저장하면 넘김 수를 뒤로 넘기는
     * == 일반적인 연산을 뒤에서 해서 오름 수를 앞자리로 전달하는 것이 아닌 뒷 자리로 넘기기 때문에 스택(후입선출)을 사용하여 푸는 방식
     *
     * -> 수정 - 어차피 오름수를 뒤로 넘긴다면 단방향 연결리스트의 방향과 동일하게 노드를 차례로 연산하고 넘겨 바로 노드에 저장
     * 과정과 속도 : 일의 자리부터 연산 시작해서 리버스 << (우월) 맨 윗자리부터 연산 시작해서 오름 수를 뒤로 넘기는 것
     * 연결리스트의 사용 이유?
     * ++ 연결리스트는 수정에 용이 -> 인덱스를 사용하기 위해 사이즈를 측정하는 것은 사용하는 의미가 없음 -> 배열 개념에 얽매이지 말자
     */

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = null, tail = null;
        int carry = 0;

        while (l1 != null || l2 != null || carry > 0) {
            int sum = carry;
            if (l1 != null) { sum += l1.val; l1 = l1.next; }
            if (l2 != null) { sum += l2.val; l2 = l2.next; }

            carry = sum / 10;
            ListNode newNode = new ListNode(sum % 10);

            if (head == null) {  // 첫 노드 설정
                head = newNode;
                tail = newNode;
            } else {  // 다음 노드 추가
                tail.next = newNode;
                tail = newNode;
            }
        }

        return head;
    }
}