/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};
*/

class Solution {
    public Node flatten(Node head) {
        // Edge case
        if(head == null) {
            return head;
        }

        // curr variable creation
        Node curr = head;
        while(curr != null) {
            // if child exist
            if(curr.child != null) {
                Node next = curr.next; // for future need

                curr.next = flatten(curr.child); // recursive call
                curr.next.prev = curr; // bothway connection
                // make sure flattened
                curr.child = null;

                // update curr to the last node of the flattened list
                while(curr.next != null) {
                    curr = curr.next;
                }

                // check if next pointer created for future need is valid -> then connect to curr bothways
                if(next != null) {
                    curr.next = next;
                    next.prev = curr;
                }

            }

            // curr updation for the top first loop
            curr = curr.next;

        }

        return head;
    }
}