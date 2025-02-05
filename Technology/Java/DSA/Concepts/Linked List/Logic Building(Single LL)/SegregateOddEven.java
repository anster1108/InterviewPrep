/*
	Segregate odd and even nodes in LL
		Given the head of a singly linked list. Group all the nodes with odd indices followed by all the nodes with even indices and return the reordered list.

		Consider the 1st node to have index 1 and so on. The relative order of the elements inside the odd and even group must remain the same as the given input.

	Example 1
		Input: head -> 1 -> 2 -> 3 -> 4 -> 5
		Output: head -> 1 -> 3 -> 5 -> 2 -> 4
		Explanation: The nodes with odd indices are 1, 3, 5 and the ones with even indices are 2, 4.

	Example 2
		Input: head -> 4 -> 3 -> 2 -> 1
		Output: head -> 4 -> 2 -> 3 -> 1
		Explanation: The nodes with odd indices are 4, 2 and the ones with even indices are 3, 1.

	Example 3
		Input: head -> 1
		Output: head -> 1


	Brute Force :

		 public ListNode oddEvenList(ListNode head) {
	        // Check if list is empty or has only one node
	        if (head == null || head.next == null)
	            return head;

	        // To store values
	        List<Integer> array = new ArrayList<>();   
	        ListNode temp = head;

	        //Traverse the list, skipping one node, and store values in the vector
	        while (temp != null && temp.next != null) {
	            array.add(temp.val);
	            temp = temp.next.next;
	        }

	        // If there's an even number of nodes, add the value of the last node
	        if (temp != null)
	            array.add(temp.val);

	        // Reset temp 
	        temp = head.next;

	        // Traverse the list again, skipping one node,and store values in the vector
	        while (temp != null && temp.next != null) {
	            array.add(temp.val);
	            temp = temp.next.next;
	        }

	       // If there's an odd number of nodes, add the value of the last node
	        if (temp != null)
	            array.add(temp.val);

	        // Reset temp 
	        temp = head;
	        int i = 0;

	        // Update node values 
	        while (temp != null) {
	            temp.val = array.get(i);
	            temp = temp.next;
	            i++;
	        }

	        return head;
	    }
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

class SegregateOddEven {
    // Function to rearrange nodes
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null)
            return head;

        /*Initialize pointers for odd 
        and even nodes and keep 
        track of the first even node*/
        ListNode odd = head;
        ListNode even = head.next;
        ListNode firstEven = head.next;

        // Rearranging nodes
        while (even != null && even.next != null) {
            odd.next = odd.next.next;
            even.next = even.next.next;
            odd = odd.next;
            even = even.next;
        }

        /* Connect the last odd 
       node to the first even node*/
        odd.next = firstEven;

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

// Main function
public static void main(String[] args) {
    // Create a linked list with given values
    int[] arr = {1, 3, 4, 2, 5, 6};
    ListNode head = new ListNode(arr[0]);
    head.next = new ListNode(arr[1]);
    head.next.next = new ListNode(arr[2]);
    head.next.next.next = new ListNode(arr[3]);
    head.next.next.next.next = new ListNode(arr[4]);
    head.next.next.next.next.next = new ListNode(arr[5]);

    // Print the original linked list
    System.out.println("Original Linked List: ");
    printLL(head);

    // Rearrange the list and print it
    SegregateOddEven SegregateOddEven = new SegregateOddEven();
    head = SegregateOddEven.oddEvenList(head);
    System.out.println("New Linked List: ");
    printLL(head);
}

