/*
	Sort a LL of 0's 1's and 2's
		Given the head of a singly linked list consisting of only 0, 1 or 2. Sort the given linked list and return the head of the modified list. Do it in-place by changing the links between the nodes without creating new nodes.


	Example 1
		Input: head -> 1 -> 0 -> 2 -> 0 -> 1
		Output: head -> 0 -> 0 -> 1 -> 1 -> 2
		Explanation: The values after sorting are [0, 0, 1, 1, 2].

	Example 2
		Input: head -> 1 -> 1 -> 1 -> 0
		Output: head -> 0 -> 1 -> 1 -> 1
		Explanation: The values after sorting are [0, 1, 1, 1].

	Example 3
		Input: head -> 2 -> 2 -> 1 -> 2
		Output : head -> 1 -> 2 -> 2 -> 2

	Brute Force : 
		public ListNode sortList(ListNode head) {
	        // Initialize counts
	        int c0 = 0, c1 = 0, c2 = 0;
	        ListNode temp = head;

	        // Count the number of 0s, 1s, and 2s in the list
	        while (temp != null) {
	            if (temp.val == 0)
	                c0++;
	            else if (temp.val == 1)
	                c1++;
	            else if (temp.val == 2)
	                c2++;
	            temp = temp.next;
	        }

	        temp = head;

	        // Reassign values to the nodes based on the counts 
	        while (temp != null) {
	            if (c0 > 0) {
	                temp.val = 0;
	                c0--;
	            } else if (c1 > 0) {
	                temp.val = 1;
	                c1--;
	            } else if (c2 > 0) {
	                temp.val = 2;
	                c2--;
	            }
	            temp = temp.next;
	        }

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

class Sort012 {
    // Function to sort the linked list
    public ListNode sortList(ListNode head) {
        /* If the list is empty or has only one 
           node, return as it is already sorted */
        if (head == null || head.next == null)
            return head;

        // Dummy nodes to point to heads of 
        // three lists
        ListNode zeroHead = new ListNode(-1);
        ListNode oneHead = new ListNode(-1);
        ListNode twoHead = new ListNode(-1);

        // Pointers to current last nodes of 
        // three lists
        ListNode zero = zeroHead;
        ListNode one = oneHead;
        ListNode two = twoHead;
        ListNode temp = head;

        /* Traverse the original list 
           and distribute the nodes 
           into three lists */
        while (temp != null) {
            if (temp.val == 0) {
                zero.next = temp;
                zero = temp;
            } else if (temp.val == 1) {
                one.next = temp;
                one = temp;
            } else if (temp.val == 2) {
                two.next = temp;
                two = temp;
            }
            temp = temp.next;
        }

        // Connect the three lists together
        zero.next = (oneHead.next != null) ? oneHead.next : twoHead.next;
        one.next = twoHead.next;
        two.next = null;

        // New head of the sorted list
        ListNode newHead = zeroHead.next;

        // Delete dummy nodes
        return newHead;
    }
}

// Helper function to print linked list
public class Main {
    public static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.println();
    }

    // Helper function to create a new node
    public static ListNode newNode(int data) {
        return new ListNode(data);
    }

    public static void main(String[] args) {
        // Creating a linked list
        ListNode head = newNode(1);
        head.next = newNode(2);
        head.next.next = newNode(0);
        head.next.next.next = newNode(1);
        head.next.next.next.next = newNode(2);
        head.next.next.next.next.next = newNode(0);
        head.next.next.next.next.next.next = newNode(1);

        // Print original list
        System.out.print("Original list: ");
        printList(head);

        // Sort the list
        Sort012 sol = new Sort012();
        head = sol.sortList(head);

        // Print sorted list
        System.out.print("Sorted list: ");
        printList(head);
    }
}
