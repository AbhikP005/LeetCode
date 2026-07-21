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
    public ListNode middleNode(ListNode head) {
        // Slow-Fast pointer Approach - Both innitialized to head
        ListNode slow = head;
        ListNode fast = head;

        // Loop until fast != null (EVEN CASE) & fast.next != null (ODD CASE)
        while(fast != null && fast.next != null) {
            // Update slow by 1, fast by 2
            slow = slow.next;
            fast = fast.next.next;
        }

        // the slow points the middle after the loop
        return slow;
    }
}