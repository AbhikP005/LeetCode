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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        // Base Case
        if(list1 == null || list2 == null) {
            return list1 == null ? list2 : list1;
        }

        // h1.val <= h2.val
        if(list1.val <= list2.val) {
            // Recursive call for h1.next, h2
            list1.next = mergeTwoLists(list1.next, list2);
            return list1;
        } else {
            // Recursive call for h1, h2.next
            list2.next = mergeTwoLists(list1, list2.next);
            return list2;
        }
    }
}