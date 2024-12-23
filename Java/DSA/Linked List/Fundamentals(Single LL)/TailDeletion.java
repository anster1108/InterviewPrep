/*
	Deletion of the tail of LL

		Given the head of a singly linked list, delete the tail of the linked list and return the head of the modified list.
        The tail is the last node of the linked list.

    	Example 1
            Input: head -> 1 -> 2 -> 3

            Output: head -> 1 -> 2

            Explanation: The last node was removed.

*/

import java.util.*;

// Node structure
class ListNode {
    int val;
    ListNode next;

    ListNode() {
        val = 0;
        next = null;
    }

    ListNode(int data1) {
        val = data1;
        next = null;
    }

    ListNode(int data1, ListNode next1) {
        val = data1;
        next = next1;
    }
}

class TailDeletion {
    // Function to delete the head node of the linked list
    public ListNode deleteHead(ListNode head) {
        // If the list is empty or has only one node
        if (head == null || head.next == null) {
            return null; // Return null
        }

        // Temporary pointer
        ListNode temp = head;

        /* Traverse to the second last 
        node in the list */
        while (temp.next.next != null) {
            temp = temp.next;
        }

        // Delete the last node
        temp.next = null;

        // Return head of modified list
        return head;
    }
}

class Main {
    private static void printList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
        System.out.println();
    }

    // Function to insert a new node at the beginning of the linked list
    public static ListNode insertAtHead(ListNode head, int data) {
        ListNode newNode = new ListNode(data);
        newNode.next = head;
        head = newNode;
        return head;
    }
    
    
    public static void main(String[] args) {
        // Create a linked list
        ListNode head = null;
        head = insertAtHead(head, 3);
        head = insertAtHead(head, 2);
        head = insertAtHead(head, 1);

        System.out.print("Original list: ");
        printList(head);
        
        // Creating an instance of TailDeletion Class
        TailDeletion sol = new TailDeletion();
        
        // Function call to delete the head node
        head = sol.deleteHead(head);

        System.out.print("List after deleting head: ");
        printList(head);
    }
}