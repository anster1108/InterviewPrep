/*
	Delete the middle node in LL
		Given the head of a non-empty singly linked list containing integers, delete the middle node of the linked list. Return the head of the modified linked list.

		The middle node of a linked list of size n is the ⌊n / 2⌋th node from the start using 0-based indexing, where ⌊x⌋ denotes the largest integer less than or equal to x.

		Example 1
			Input: head -> 1 -> 2 -> 3 -> 4 -> 5
			Output: head -> 1 -> 2 -> 4 -> 5
			Explanation: n = 5.
			⌊n / 2⌋ = 2, therefore middle node has index 2 and so the node with value 3 was deleted.

		Example 2
			Input: head -> 7 -> 6 -> 5 -> 4
			Output: head -> 7 -> 6 -> 4
			Explanation: n = 4.
			⌊n / 2⌋ = 2, therefore middle node has index 2 and so the node with value 5 was deleted.

		Brute : 
			Time Complexity: O(N + N/2) because the loop traverses the entire linked list once to count the total number of nodes then the loop iterates halfway through the linked list to reach the middle node. Hence, the time complexity is O(N + N/2) ~ O(N).

			Space Complexity: O(1) because the code uses a constant amount of extra space regardless of the size of the linked list. It doesn't use any additional data structures in proportion to the input size.

			Code:
				public ListNode deleteMiddle(ListNode head) {
			        // Edge case: if the list is empty or has only one node, return null
			        if (head == null || head.next == null) {
			            return null;
			        }

			        // Temporary node to traverse
			        ListNode temp = head;
			        
			        // Variable to store number of nodes
			        int n = 0;
			        
			        // Loop to count the number of nodes in the linked list
			        while (temp != null) {
			            n++;
			            temp = temp.next;
			        }
			        
			        // Index of the middle node
			        int middleIndex = n / 2;
			        
			        // Reset temporary node 
			        // to beginning of linked list
			        temp = head;
			        
			        // Loop to find the node just before the middle node
			        for (int i = 1; i < middleIndex; i++) {
			            temp = temp.next;
			        }
			        
			        // If the middle node is found
			        if (temp.next != null) {
			            // Create pointer to the middle node
			            ListNode middle = temp.next;
			            
			            // Adjust pointers to skip middle node
			            temp.next = temp.next.next;
			            
			            // Free the memory allocated to the middle node 
			            middle = null;
			        }
			        
			        // Return head
			        return head;
			    }
*/

import java.util.*;

// Definition of singly linked list:
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

class DeleteMiddleNode {
    // Function to delete the middle node of a linked list
    public ListNode deleteMiddle(ListNode head) {
        /* If the list is empty or has only one node,
         * return null as there is no middle node to delete */
        if (head == null || head.next == null) {
            return null;
        }

        // Initialize slow and fast pointers
        ListNode slow = head;
        ListNode fast = head.next.next;

        // Move 'fast' pointer twice as fast as 'slow'
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Delete the middle node by skipping it
        slow.next = slow.next.next;
        return head;
    }

    // Function to print the linked list
    public static void printLL(ListNode head) {
        ListNode temp = head;
        while (temp != null) {
            System.out.print(temp.val + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // Creating a sample linked list: 
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        
        // Display the original linked list
        System.out.print("Original Linked List: ");
        printLL(head);

        // Deleting the middle node
        DeleteMiddleNode DeleteMiddleNode = new DeleteMiddleNode();
        head = DeleteMiddleNode.deleteMiddle(head);

        // Displaying the updated linked list
        System.out.print("Updated Linked List: ");
        printLL(head);
    }
}

/*
	Time Complexity: O(N/2) because the code traverses the linked list using the Tortoise and Hare approach. The code increments both 'slow' and 'fast' pointers at different rates, effectively covering about half the list before reaching the midpoint, hence the time complexity of the algorithm is O(N/2) ~ O(N).

	Space Complexity: O(1) because the code uses a constant amount of extra space regardless of the size of the input (linked list). It doesn't use any additional data structures in proportion to the input size.
*/