//You are given the head of a linked list and a key. You have to delete the node that contains this given key
public class LinkedListExec {
    public static void main(String[] args) {
        LinkedList.LinkedListNode head = new LinkedList.LinkedListNode(1);
        head.next = new LinkedList.LinkedListNode(2);
        head.next.next = new LinkedList.LinkedListNode(3);
        head.next.next.next = new LinkedList.LinkedListNode(4);

        int key = 3;
        head = LinkedList.deleteNode(head, key);
        System.out.println(head.val+"->"+head.next.val+"->"+head.next.next.val);
    }
}

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
