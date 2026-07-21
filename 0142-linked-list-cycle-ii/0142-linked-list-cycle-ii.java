/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        boolean isCycle = false;

        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if(slow == fast) {
                isCycle = true;
                break;
            }
        }

        // if there is no cycle return null
        if(!isCycle) { // isCycle = false condition
            return null;
        }

        // Reinitialize slow to head
        slow = head;
        // Loop until slow meets fast
        while(slow != fast) {
            // This time both slow & fast incr by 1
            slow = slow.next;
            fast = fast.next;
        }

        // Return either slow or fast -> both points to the starting node
        return slow;
    }
}