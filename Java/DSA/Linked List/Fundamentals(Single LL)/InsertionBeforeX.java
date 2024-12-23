/*
	Given the head of a singly linked list and two integers X and val, insert a node with value val before the node with value X in the linked list and return the head of the modified list.

	Example 1
		Input: head -> 1 -> 2 -> 3, X = 2, val = 5
		Output: head -> 1 -> 5 -> 2 -> 3
		Explanation: The node with value 5 was added before the node with value 2

	Example 2
		Input: head -> 1 -> 2 -> 3, X = 7, val = 5
		Output: head -> 1 -> 2 -> 3
		Explanation: No node was added as X was not found in the list.
*/
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

// InsertionBeforeX class
class InsertionBeforeX {
    // Function to insert a new node before the given node
    public ListNode insertBeforeX(ListNode head, int X, int val) {
        if (head == null) {
            return null;
        }

        /* Insert at the beginning if the
        value matches the head's data */
        if (head.val == X)
            return new ListNode(val, head);

        ListNode temp = head;
        while (temp.next != null) {
            /* Insert at the current position if 
            the next node has the desired value */
            if (temp.next.val == X) {
                ListNode newNode = new ListNode(val, temp.next);
                temp.next = newNode;
                break;
            }
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
    
    // main method
    public static void main(String[] args) {
        // Create a linked list from an array
        int[] arr = {1, 2, 4, 5};
        int X = 4, val = 3;
        ListNode head = new ListNode(arr[0]);
        head.next = new ListNode(arr[1]);
        head.next.next = new ListNode(arr[2]);

        // Print the original list
        System.out.print("Original List: ");
        printLL(head);

        // Create a InsertionBeforeX object
        InsertionBeforeX sol = new InsertionBeforeX();
        head = sol.insertBeforeX(head, X, val);

        // Print the modified linked list
        System.out.print("List after inserting a new node before the given node: ");
        printLL(head);
    }
}