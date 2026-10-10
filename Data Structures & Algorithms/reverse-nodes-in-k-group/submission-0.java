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

        ListNode newNode = reverseLinkedList(front);

        front.next = head;
        head.next = null;

        return newNode;
    }

    private ListNode getKthElement(ListNode head, int k) {
        ListNode temp = head;
        for(int i=0; i<k-1; i++) {
            if(temp == null) return null;
            temp = temp.next;
        }

        return temp;
    }
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode temp = head;
        ListNode prevNode = null, nextNode = null;

        while(temp != null) {
            ListNode kthElement = getKthElement(temp, k);
            if(kthElement == null) {
                if(prevNode != null) {
                    prevNode.next = temp;
                }
                break;
            }

            nextNode = kthElement.next;

            kthElement.next = null;
            reverseLinkedList(temp);

            if(temp == head) {
                head = kthElement;
            } else {
                prevNode.next = kthElement;
            }

            prevNode = temp;
            temp = nextNode;
        }

        return head;
    }
}
