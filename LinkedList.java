//You are given the head of a linked list and a key. You have to delete the node that contains this given key

public class LinkedListNode {
    int val;
    LinkedListNode next;

    public LinkedListNode(int val) {
        this.val = val;
    }
}

public class LinkedList {

    public static LinkedListNode deleteNode(LinkedListNode head, int key) {
        // Special case: the head node contains the key
        if (head.val == key) {
            return head.next;  // Remove the head node and return the new head
        }

        LinkedListNode prev = head;
        LinkedListNode curr = head.next;
        while (curr != null) {
            if (curr.val == key) {
                prev.next = curr.next;  // Skip the current node by updating the next pointer of the previous node
                return head;  // Return the head of the modified list
            }
            prev = curr;
            curr = curr.next;
        }

        // The key was not found in the list
        return head;
    }

}
