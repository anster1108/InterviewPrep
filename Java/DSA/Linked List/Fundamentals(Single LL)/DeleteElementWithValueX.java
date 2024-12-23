import java.util.*;

// Definition of singly linked list
class ListNode {
    int val;
    ListNode next;

    ListNode(int data1) {
        val = data1;
        next = null;
    }

    ListNode(int data1, ListNode next1) {
        val = data1;
        next = next1;
    }
}

// ValueXElementDeletion class
class ValueXElementDeletion {
    // To delete a node with a specific value in a linked list
    public ListNode deleteNodeWithValueX(ListNode head, int X) {
        // Check if list is empty
        if (head == null)
            return head;

        // If first node has target value, delete
        if (head.val == X) {
            head = head.next;
            return head;
        }

        ListNode temp = head;
        ListNode prev = null;

        /* Traverse the list to find 
        the node with the target value */
        while (temp != null) {
            if (temp.val == X) {
                // Adjust the pointers
                prev.next = temp.next;
                return head;
            }
            prev = temp;
            temp = temp.next;
        }

        return head;
    }
}

// Main class
class Main {
    // Helper Function to print the linked list
    private static void printLL(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // Create a linked list from an array
        int[] arr = {0, 1, 2};
        int X = 1;
        ListNode head = new ListNode(arr[0]);
        head.next = new ListNode(arr[1]);
        head.next.next = new ListNode(arr[2]);

        // Print the original list
        System.out.print("Original List: ");
        printLL(head);

        // Create a ValueXElementDeletion object
        ValueXElementDeletion sol = new ValueXElementDeletion();
        head = sol.deleteNodeWithValueX(head, X);

        // Print the modified linked list
        System.out.print("List after deleting the given value: ");
        printLL(head);
    }
}