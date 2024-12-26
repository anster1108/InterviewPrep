/*
	Add one to a number represented by LL
		Given the head of a singly linked list representing a positive integer number. Each node of the linked list represents a digit of the number, with the 1st node containing the leftmost digit of the number and so on. The task is to add one to the value represented by the linked list and return the head of a linked list containing the final value.

		The number will contain no leading zeroes except when the value represented is zero itself.

	Example 1
		Input: head -> 1 -> 2 -> 3
		Output: head -> 1 -> 2 -> 4
		Explanation: The number represented by the linked list = 123.
		123 + 1 = 124.

	Example 2
		Input: head -> 9 -> 9
		Output: head -> 1 -> 0 -> 0
		Explanation: The number represented by the linked list = 99.
		99 + 1 = 100.
	Example 3
		Input: head -> 9
		Output: head -> 1 -> 0
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

class AddOneToLL {
    // Function to reverse the linked list
    public ListNode reverseList(ListNode head) {
        // Initialize pointers
        ListNode prev = null;
        ListNode current = head;
        ListNode next = null;
        
        while (current != null) {
            // Store next node
            next = current.next;
            // Reverse the link
            current.next = prev;
            // Move prev to current
            prev = current;
            // Move current to next
            current = next;
        }
        
        return prev;
    }
    
    // Function to add one to Linked List
    public ListNode addOne(ListNode head) {
        // Reverse the linked list
        head = reverseList(head);
        
        // Create a dummy node
        ListNode current = head;
        // Initialize carry with 1
        int carry = 1;  
        
        while (current != null) {
            /* Sum the current node's value 
            and the carry */
            int sum = current.val + carry;
            // Update carry
            carry = sum / 10;
            // Update the node's value
            current.val = sum % 10;
            
            /* If no carry left
            break the loop */
            if (carry == 0) {
                break;
            }
            
            /* If we've reached the end of the list
            and there's still a carry,
            add a new node with the carry value */
            if (current.next == null && carry != 0) {
                current.next = new ListNode(carry);
                break;
            }
            
            // Move to the next node
            current = current.next;
        }
        
        // Reverse the list 
        head = reverseList(head);
        
        // New head
        return head;
    }
}

// Function to print the linked list
public static void printList(ListNode head) {
    while (head != null) {
        System.out.print(head.val + " ");
        head = head.next;
    }
    System.out.println();
}

public static void main(String[] args) {
    // Creation of Linked List
    ListNode head1 = new ListNode(1);
    head1.next = new ListNode(2);
    head1.next.next = new ListNode(3);

    // AddOneToLL instance
    AddOneToLL AddOneToLL = new AddOneToLL();
    head1 = AddOneToLL.addOne(head1);
    System.out.print("Result after adding one: ");
    printList(head1);
}
