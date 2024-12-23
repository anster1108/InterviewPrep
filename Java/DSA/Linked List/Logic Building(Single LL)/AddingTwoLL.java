/*
	Add two numbers in LL
		Given two non-empty linked lists l1 and l2 which represent two non-negative integers.
		The digits are stored in reverse order with each node storing one digit.

		Add two numbers and return the sum as a linked list.

		The sum Linked List will be in reverse order as well.
		The Two given Linked Lists represent numbers without any leading zeros, except when the number is zero itself.

	Example 1
		Input: l1 = head -> 5 -> 4, l2 = head -> 4

		Output: head -> 9 -> 4

		Explanation: l1 = 45, l2 = 4.

		l1 + l2 = 45 + 4 = 49.

	Example 2
		Input: l1 = head -> 4 -> 5 -> 6, l2 = head -> 1 -> 2 -> 3

		Output: head -> 5 -> 7 -> 9

		Explanation: l1 = 654, l2 = 321.

		l1 + l2 = 654 + 321 = 975.

	Example 3
		Input: l1 = head -> 1, l2 = head -> 8 -> 7

		Output: head -> 9 -> 7
*/

import java.util.*;

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

class AddingTwoLL {
    // Function to add two numbers as linked list
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        /* Dummy node to act as the
        starting point of the result list */
        ListNode dummy = new ListNode(0);
        /* Temp pointer to build
        the result list */
        ListNode temp = dummy;
        // Initialize carry
        int carry = 0;

        /* Iterate while there are nodes in l1 or l2,
        or there's a carry to process */
        while (l1 != null || l2 != null || carry != 0) {
            int sum = 0;

            /* Add the value from l1
            if available */
            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }

            /* Add the value from l2
            if available */
            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }

            // Add the carry
            sum += carry;
            // Update the carry
            carry = sum / 10;

            /* Create a new node with the digit value
            and attach it to the result list */
            ListNode node = new ListNode(sum % 10);
            temp.next = node;
            /* Move to the
            next position in the result list */
            temp = temp.next;
        }
        /* Return the result list
        skipping the dummy node */
        return dummy.next;
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
    // Manual creation of linked list
    ListNode l1 = new ListNode(2, new ListNode(4, new ListNode(3)));
    ListNode l2 = new ListNode(5, new ListNode(6, new ListNode(4)));

    // Instance of AddingTwoLL class
    AddingTwoLL AddingTwoLL = new AddingTwoLL();
    ListNode result = AddingTwoLL.addTwoNumbers(l1, l2);

    // Print the result
    printList(result);
}
