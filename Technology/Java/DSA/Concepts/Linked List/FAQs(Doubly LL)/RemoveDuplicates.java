/*
	Remove duplicated from sorted DLL
		Given the head of a doubly linked list with its values sorted in non-decreasing order. Remove all duplicate occurrences of any value in the list so that only distinct values are present in the list.

		Return the head of the modified linked list.

	Example 1
		Input: head -> 1 <-> 1 <-> 3 <-> 3 <-> 4 <-> 5
		Output: head -> 1 <-> 3 <-> 4 <-> 5
		Explanation: head -> 1 <-> 1 <-> 3 <-> 3 <-> 4 <-> 5
		The underlined nodes were deleted to get the desired result.

	Example 2
		Input: head -> 1 <-> 1 <-> 1 <-> 1 <-> 1 <-> 2
		Output: head -> 1 <-> 2
		Explanation: head -> 1 <-> 1 <-> 1 <-> 1 <-> 1 <-> 2
		The underlined nodes were deleted to get the desired result.

	Time Complexity: O(n) and not O(n^2) because each node in the doubly linked list is visited exactly once. The outer loop traverses each distinct node, and the inner loop skips over consecutive duplicates in a single pass, ensuring a total linear traversal of the list. Thus the combined process does not create nested iterations and remains efficient.


	Space Complexity: O(1) no extra space is used.
*/

import java.util.*;

// Definition of doubly linked list
class ListNode {
    int val;
    ListNode next;
    ListNode prev;
    ListNode() {
        val = 0;
        next = null;
        prev = null;
    }
    ListNode(int data1) {
        val = data1;
        next = null;
        prev = null;
    }
    ListNode(int data1, ListNode next1, ListNode prev1) {
        val = data1;
        next = next1;
        prev = prev1;
    }
}

class RemoveDuplicates {
    // To remove duplicates from a sorted doubly linked list
    public ListNode removeDuplicates(ListNode head) {
        ListNode temp = head;

        // Traverse the list
        while (temp != null && temp.next != null) {
            ListNode nextNode = temp.next;

            // Remove all duplicate nodes
            while (nextNode != null && nextNode.val == temp.val) {
                // Store the duplicate node
                ListNode duplicate = nextNode;
                // Move to the next node
                nextNode = nextNode.next;
                // Delete the duplicate node
                duplicate = null;
            }

            /* Link the current node 
               to the next non-duplicate node */
            temp.next = nextNode;
            /* Update previous pointer 
               of next non-duplicate node */
            if (nextNode != null) {
                nextNode.prev = temp;
            }

            // Move to the next node
            temp = temp.next;
        }

        return head;
    }
}

// Function to print doubly linked list
public class Main {
    public static void printList(ListNode head) {
        ListNode temp = head;
        while (temp != null) {
            System.out.print(temp.val + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    // Helper function to create a new node
    public static ListNode newNode(int data) {
        return new ListNode(data);
    }

    public static void main(String[] args) {
        // Creating a sorted doubly linked list:
        ListNode head = newNode(1);
        head.next = newNode(2);
        head.next.prev = head;
        head.next.next = newNode(2);
        head.next.next.prev = head.next;
        head.next.next.next = newNode(3);
        head.next.next.next.prev = head.next.next;
        head.next.next.next.next = newNode(4);
        head.next.next.next.next.prev = head.next.next.next;
        head.next.next.next.next.next = newNode(4);
        head.next.next.next.next.next.prev = head.next.next.next.next;
        head.next.next.next.next.next.next = newNode(5);
        head.next.next.next.next.next.next.prev = head.next.next.next.next.next;

        // Print original list
        System.out.print("Original list: ");
        printList(head);

        // Remove duplicates
        RemoveDuplicates sol = new RemoveDuplicates();
        head = sol.removeDuplicates(head);

        // Print modified list
        System.out.print("Modified list: ");
        printList(head);
    }
}
