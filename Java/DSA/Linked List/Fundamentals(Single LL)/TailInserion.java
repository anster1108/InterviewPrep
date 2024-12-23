/*
	Given the head of a singly linked list and an integer X, insert a node with value X at the tail of the linked list and return the head of the modified list.

	The tail is the last node of the linked list.


	Example 1
	Input: head -> 1 -> 2 -> 3, X = 7
	Output: head -> 1 -> 2 -> 3 -> 7
	Explanation: 7 was added as the last node.

	Example 2
	Input: head, X = 0
	Output: head -> 0
	Explanation: 0 was added as the last/only node.
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

// TailInserion class
class TailInserion {
    // Function to insert a new node at the tail of the linked list
    public ListNode insertAtTail(ListNode head, int X) {
        if (head == null)
            return new ListNode(X);

        ListNode temp = head;
        // Traversing until the last node
        while (temp.next != null) {
            temp = temp.next;
        }

        ListNode newNode = new ListNode(X);
        temp.next = newNode;

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
        int[] arr = {10, 20, 30};
        int val = 40;
        ListNode head = new ListNode(arr[0]);
        head.next = new ListNode(arr[1]);
        head.next.next = new ListNode(arr[2]);

        // Print the original list
        System.out.print("Original List: ");
        printLL(head);

        // Create a TailInserion object
        TailInserion sol = new TailInserion();
        head = sol.insertAtTail(head, val);

        // Print the modified linked list
        System.out.print("List after inserting the given value at the tail: ");
        printLL(head);
    }
}