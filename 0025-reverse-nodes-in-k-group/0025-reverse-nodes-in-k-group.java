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
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode temp = head;
        int cnt = 0;

        // Check if K nodes exist or not
        while(cnt < k) {
            if(temp == null) return head;

            temp = temp.next; // update temp
            cnt ++; // update cnt
        }

        // Recursively call rest of the LL
        ListNode prevNode = reverseKGroup(temp, k);

        // Reinnitialize temp and cnt 
        temp = head;
        cnt = 0;

        // Reverse all current group and connect them to prevNode
        while(cnt < k) {
            ListNode next = temp.next;
            temp.next = prevNode;

            prevNode = temp; // update prevNode
            temp = next; // update temp

            cnt ++; // update cnt
        }

        return prevNode;
    }
}