/*
	Insertion at the head of LL
		Example 1
			Input: head -> 1 -> 2 -> 3, X = 7
			Output: head -> 7 -> 1 -> 2 -> 3
			Explanation: 7 was added as the 1st node.
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

// HeadInsertion class
class HeadInsertion {
    // Function to insert at head
    public ListNode insertAtHead(ListNode head, int X) {
        // Creating a new node 
        ListNode newnode = new ListNode(X);
        
        /* Making next of newly created node to 
        point to the head of the LinkedList */
        newnode.next = head;
        
        // Making newly created node as head
        head = newnode;
        
        // Return the head of modified list
        return head;
    }
}

// Main class
class Main {
    // Helper method to print the linked list
    private static void printLL(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.println();
    }
    
    public static void main(String[] args) {
        // Create a linked list from an array
        int[] arr = {20, 30, 40};
        int X= 10;
        ListNode head = new ListNode(arr[0]);
        head.next = new ListNode(arr[1]);
        head.next.next = new ListNode(arr[2]);

        // Print the original list
        System.out.print("Original List: ");
        printLL(head);

        // Create a HeadInsertion object
        HeadInsertion sol = new HeadInsertion();
        head = sol.insertAtHead(head, X);

        // Print the modified linked list
        System.out.print("List after inserting the given value at head: ");
        printLL(head);
    }
}