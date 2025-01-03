/*
	Remove Nth node from the back of the LL
		Given the head of a singly linked list and an integer n. Remove the nth node from the back of the linked List and return the head of the modified list. The value of n will always be less than or equal to the number of nodes in the linked list.

	Example 1
		Input: head -> 1 -> 2 -> 3 -> 4 -> 5, n = 2
		Output: head -> 1 -> 2 -> 3 -> 5
		Explanation: The 2nd node from the back was the node with value 4.

	Example 2
		Input: head -> 5 -> 4 -> 3 -> 2 -> 1, n = 5
		Output: head -> 4 -> 3 -> 2 -> 1
		Explanation: The 5th node from the back is the first node.

	Example 3
	Input: head -> 9 -> 8 -> 7, n = 1
	Output : head -> 9 -> 8

	Brute Force : 
		public ListNode removeNthFromEnd(ListNode head, int n) {
	        if (head == null) {
	            return null;
	        }
	        int cnt = 0;
	        ListNode temp = head;

	        // Count the number of nodes
	        while (temp != null) {
	            cnt++;
	            temp = temp.next;
	        }

	        // If N equals the total number of nodes delete the head
	        if (cnt == n) {
	            ListNode newHead = head.next;
	            return newHead;
	        }

	        // Calculate the position of the node to delete (res) 
	        int res = cnt - n;
	        temp = head;

	        // Traverse to the node just before the one to delete
	        while (temp != null) {
	            res--;
	            if (res == 0) {
	                break;
	            }
	            temp = temp.next;
	        }

	        // Delete the Nth node from the end
	        ListNode delNode = temp.next;
	        temp.next = temp.next.next;
	        return head;
	    }
*/
import java.util.*;

// Definition of Single Linked List
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

class RemoveNthNode {
    // Function to remove the nth node from end
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // Creating pointers
        ListNode fastp = head;
        ListNode slowp = head;

        /* Move the fastp pointer 
        N nodes ahead */
        for (int i = 0; i < n; i++) {
            fastp = fastp.next;
        }

        /* If fastp becomes NULL
        the Nth node from the 
        end is the head */
        if (fastp == null) {
            return head.next;
        }

        /* Move both pointers 
        Until fastp reaches the end */
        while (fastp.next != null) {
            fastp = fastp.next;
            slowp = slowp.next;
        }

        // Delete the Nth node from the end
        ListNode delNode = slowp.next;
        slowp.next = slowp.next.next;
        return head;
    }
}

// Function to print the linked list
public static void printLL(ListNode head) {
    while (head != null) {
        System.out.print(head.val + " ");
        head = head.next;
    }
    System.out.println();
}

public static void main(String[] args) {
    List<Integer> arr = Arrays.asList(1, 2, 3, 4, 5);
    int N = 3;
    // Creation of linked list
    ListNode head = new ListNode(arr.get(0));
    head.next = new ListNode(arr.get(1));
    head.next.next = new ListNode(arr.get(2));
    head.next.next.next = new ListNode(arr.get(3));
    head.next.next.next.next = new ListNode(arr.get(4));

    // RemoveNthNode instance
    RemoveNthNode sol = new RemoveNthNode();
    head = sol.removeNthFromEnd(head, N);
    printLL(head);
}
