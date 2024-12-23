/*
	Reverse a LL
		Given the head of a singly linked list. Reverse the given linked list and return the head of the modified list.

	Example 1
		Input: head -> 1 -> 2 -> 3 -> 4 -> 5
		Output: head -> 5 -> 4 -> 3 -> 2 -> 1
		Explanation: All the links are reversed and the head now points to the last node of the original list.

	Example 2
		Input: head -> 6 -> 8
		Output: head -> 8 -> 6
		Explanation: All the links are reversed and the head now points to the last node of the original list.
		This can be seen like: 6 <- 8 <- head.
	
	Example 3
		Input: head -> 1
		Output: head -> 1
*/
import java.util.*;

// Definition of singly linked list
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

class ReverseLL {
    /*Function to reverse a linked list
    Using the 3-pointer approach*/
    public ListNode reverseList(ListNode head) {
        /*Initialize 'temp' at
        head of linked list*/
        ListNode temp = head;
        
        /*Initialize pointer 'prev' to NULL,
        representing the previous node*/
        ListNode prev = null;
        
        /*Traverse the list, continue till
        'temp' reaches the end (NULL)*/
        while (temp != null) {
            /* Store the next node in
            'front' to preserve the reference*/
            ListNode front = temp.next;
            
            /*Reverse the direction of the
            current node's 'next' pointer
            to point to 'prev'*/
            temp.next = prev;
            
            /*Move 'prev' to the current
            node for the next iteration*/
            prev = temp;
            
            /*Move 'temp' to the 'front' node
            advancing the traversal*/
            temp = front;
        }
        
        /*Return the new head of
        the reversed linked list*/
        return prev;
    }
}

// Function to print the linked list
public static void printLinkedList(ListNode head) {
    ListNode temp = head;
    while (temp != null) {
        System.out.print(temp.val + " ");
        temp = temp.next;
    }
    System.out.println();
}

public static void main(String[] args) {
    // Create a linked list with
    // Values 1, 3, 2, and 4
    ListNode head = new ListNode(1);
    head.next = new ListNode(3);
    head.next.next = new ListNode(2);
    head.next.next.next = new ListNode(4);

    // Print the original linked list
    System.out.print("Original Linked List: ");
    printLinkedList(head);

    // ReverseLL instance
    ReverseLL sol = new ReverseLL();
    // Reverse the linked list
    head = sol.reverseList(head);

    // Print the reversed linked list
    System.out.print("Reversed Linked List: ");
    printLinkedList(head);
}
