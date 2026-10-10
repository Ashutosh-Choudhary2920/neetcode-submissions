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
    private ListNode reverseLinkedList(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }

        ListNode front = head.next;

        ListNode newHead = reverseLinkedList(front);

        front.next = head;
        head.next = null;

        return newHead;
    }

    public ListNode reverseBetween(ListNode head, int leftIndex, int rightIndex) {
        ListNode temp = head, left = head, right = head, prevLeft = null, nextRight = null;

        for(int i=0; i<leftIndex-1; i++) {
            prevLeft = left;
            left = left.next;
        }

        for(int i=0; i<rightIndex-1; i++) {
            right = right.next;
        }

        nextRight = right.next;


        // for(int i=0; i<rightIndex-1; i++) {
        //     if(i == leftIndex-3) {
        //         prevLeft = temp;
        //     } else if(i == leftIndex-2) {
        //         left = temp.next;
        //     }
        //     temp = temp.next;
        // }


        // right = temp;
        // nextRight = right.next;

        right.next = null;
        reverseLinkedList(left);

        if(left == head) {
            head = right;
        } else {
            prevLeft.next = right;
        }
        left.next = nextRight;
        return head;

    }
}