/*
	Given the head of a singly linked list and two integers X and K, insert a node with value X as the kth node of the linked list and return the head of the modified list.

	Example 1
		Input: head -> 1 -> 2 -> 3, X = 5, K = 2
		Output: head -> 1 -> 5 -> 2 -> 3

	Example 2
		Input: head, X = 7, K = 1
		Output: head -> 7
		Explanation: Note that the value of the head was changed.

	Example 3
		Input: head -> 1 -> 2, X = 15, K = 3
		Output: head -> 1 -> 2 -> 15
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

// KthElementInsertion class
class KthElementInsertion {
    // Function to insert a new node at the kth position 
    public ListNode insertAtKthPosition(ListNode head, int X, int K) {
        /* If the linked list is empty 
        and k is 1, insert the 
        new node as the head */
        if (head == null) {
            if (K == 1)
                return new ListNode(X);
            else
                return head;
        }

        /* If K is 1, insert the new
        node at the beginning 
        of the linked list */
        if (K == 1)
            return new ListNode(X, head);

        int cnt = 0;
        ListNode temp = head;

        /* Traverse the linked list 
        to find the node at position k-1 */
        while (temp != null) {
            cnt++;
            if (cnt == K - 1) {
                /* Insert the new node after the node 
                at position k-1 */
                ListNode newNode = new ListNode(X, temp.next);
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
    // Helper Method to print the linked list
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
        int[] arr = {10, 30, 40};
        int X = 20, K = 2;
        ListNode head = new ListNode(arr[0]);
        head.next = new ListNode(arr[1]);
        head.next.next = new ListNode(arr[2]);

        // Print the original list
        System.out.print("Original List: ");
        printLL(head);

        // Create a KthElementInsertion object
        KthElementInsertion sol = new KthElementInsertion();
        head = sol.insertAtKthPosition(head, X, K);

        // Print the modified linked list
        System.out.print("List after inserting the given value at the Kth position: ");
        printLL(head);
    }
}
