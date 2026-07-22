/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        // Edge case
        if(head == null) {
            return null;
        }

        // Hashmap to store the old values and new values
        HashMap<Node, Node> m = new HashMap<>();

        // setting newHead
        Node newHead = new Node(head.val);
        // setting oldtemp, newTemp variables
        Node oldTemp = head.next;
        Node newTemp = newHead;

        // put head and newhead values to the map
        m.put(head, newHead);


        while(oldTemp != null) {
            // copyNode consist of values of copied nodes
            Node copyNode = new Node(oldTemp.val);
            // map oldTemp and copyNode
            m.put(oldTemp, copyNode);

            // connect the newTemp->next to copyNode
            newTemp.next = copyNode;

            // update oldTemp and newTemp
            oldTemp = oldTemp.next;
            newTemp = newTemp.next;
        }

        // set oldTemp and new temp to head and newHead
        oldTemp = head;
        newTemp = newHead;

        while(oldTemp != null) {
            // connect newTemp->random to oldtemp_.random
            newTemp.random = m.get(oldTemp.random);

            // update oldTemp, newTemp
            oldTemp = oldTemp.next;
            newTemp = newTemp.next;
        }

        return newHead;
    }
}