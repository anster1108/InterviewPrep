/*
	Delete all occurrences of a key in DLL
		Given the head of a doubly linked list and an integer target. Delete all nodes in the linked list with the value target and return the head of the modified linked list.

		Example 1
			Input: head -> 1 <-> 2 <-> 3 <-> 1 <-> 4, target = 1
			Output: head -> 2 <-> 3 <-> 4
			Explanation: All nodes with the value 1 were removed.

		Example 2
			Input: head -> 2 <-> 3 <-> -1 <-> 4 <-> 2, target = 2
			Output: head -> 3 <-> -1 <-> 4
			Explanation: All nodes with the value 2 were removed.
			Note that the value of head is changed.

		Example 3
			Input: head -> 7 <-> 7 <-> 7 <-> 7, target = 7
			Output:head


	Complexity Analysis
		Time Complexity: O(N) because the linked list is traversed only once. Here, N represents the number of nodes in the linked list.

		Space Complexity: O(1) because no extra space used.
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

class DeleteAllOccurenceOfTarget {
    // Function to delete all occurrences of a target value
    public ListNode deleteAllOccurrences(ListNode head, int target) {
        ListNode temp = head;

        while (temp != null) {
            if (temp.val == target) {
                // Update head if needed
                if (temp == head) {
                    head = temp.next;
                }

                ListNode nextNode = temp.next;
                ListNode prevNode = temp.prev;

                // Update previous node's next
                if (nextNode != null) {
                    nextNode.prev = prevNode;
                }

                // Update next node's previous
                if (prevNode != null) {
                    prevNode.next = nextNode;
                }

                // Delete the current node
                temp = nextNode;
            } else {
                temp = temp.next;
            }
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
        // Creating doubly linked list
        ListNode head = newNode(1);
        head.next = newNode(2);
        head.next.prev = head;
        head.next.next = newNode(3);
        head.next.next.prev = head.next;
        head.next.next.next = newNode(2);
        head.next.next.next.prev = head.next.next;
        head.next.next.next.next = newNode(4);
        head.next.next.next.next.prev = head.next.next.next;
        head.next.next.next.next.next = newNode(2);
        head.next.next.next.next.next.prev = head.next.next.next.next;
        head.next.next.next.next.next.next = newNode(5);
        head.next.next.next.next.next.next.prev = head.next.next.next.next.next;

        // Print original list
        System.out.print("Original list: ");
        printList(head);

        // Delete all occurrences of 2
        DeleteAllOccurenceOfTarget sol = new DeleteAllOccurenceOfTarget();
        head = sol.deleteAllOccurrences(head, 2);

        // Print modified list
        System.out.print("Modified list: ");
        printList(head);
    }
}
