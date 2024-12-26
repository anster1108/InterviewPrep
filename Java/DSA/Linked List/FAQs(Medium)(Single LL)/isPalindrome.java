/*
	Check if LL is palindrome or not
		Given the head of a singly linked list representing a positive integer number. Each node of the linked list represents a digit of the number, with the 1st node containing the leftmost digit of the number and so on. Check whether the linked list values form a palindrome or not. Return true if it forms a palindrome, otherwise, return false.
		A palindrome is a sequence that reads the same forward and backwards.

	Example 1
		Input: head -> 3 -> 7 -> 5 -> 7 -> 3
		Output: true
		Explanation: 37573 is a palindrome.

	Example 2
		Input: head -> 1 -> 1 -> 2 -> 1
		Output: false
		Explanation: 1121 is not a palindrome.

	Example 3
		Input: head -> 9 -> 9 -> 9 -> 9
		Output: 1


	Brute Force :
		public boolean isPalindrome(ListNode head) {
	        // Create an empty stack to store values
	        Stack<Integer> stack = new Stack<>();
	        
	        // Initialize temporary pointer to the head of the linked list
	        ListNode temp = head;
	        
	        // Traverse the linked list and push values onto the stack
	        while (temp != null) {
	            // Push the data from the current node onto the stack
	            stack.push(temp.val);
	            
	            // Move to the next node
	            temp = temp.next;
	        }
	        
	        // Reset temporary pointer back to the head of the linked list
	        temp = head;
	        
	        // Compare values by popping from the stack and checking against linked list nodes
	        while (temp != null) {
	            if (temp.val != stack.pop()) {
	                // If values don't match,it's not a palindrome
	                return false;
	            }
	            
	            // Move to the next node in the linked list
	            temp = temp.next;
	        }
	        
	        // If all values match, it's a palindrome
	        return true;
	    }

	Time Complexity: O(2xN) because we need to traverse the linked list twice: once to push the values onto the stack and once more to pop the values and compare them with the nodes in the linked list. Here, N represents the number of nodes in the linked list. Even though it's O(2xN), it effectively simplifies to O(N).

	Space Complexity: O(N) We use a stack to store the values of the linked list. In the worst-case scenario, the stack will hold all N values from the linked list, essentially storing the entire list.
*/
import java.util.*;

class ListNode {
    int val;
    ListNode next;

    // Constructor with no parameters
    ListNode() {
        val = 0;
        next = null;
    }

    // Constructor with one parameter
    ListNode(int data1) {
        val = data1;
        next = null;
    }

    // Constructor with two parameters
    ListNode(int data1, ListNode next1) {
        val = data1;
        next = next1;
    }
}

class IsPalindrome {

    /*Function to reverse a linked list
    using the recursive approach*/
    private ListNode reverseLinkedList(ListNode head) {
        /* Check if the list is empty
        or has only one node*/
        if (head == null || head.next == null) {
            /*No change is needed;
            return the current head*/
            return head;
        }

        /*Reverse the remaining 
        part of the list and get the new head*/
        ListNode newHead = reverseLinkedList(head.next);

        /*Store the next node in 'front'
        to reverse the link*/
        ListNode front = head.next;

        /*Update the 'next' pointer of 'front' to
        point to the current head, effectively
        reversing the link direction*/
        front.next = head;

       /* Set the 'next' pointer of the
        current head to 'null' to
        break the original link*/
        head.next = null;

        /*Return the new head obtained
        from the recursion*/
        return newHead;
    }

    public boolean isPalindrome(ListNode head) {
        /*Check if the linked list is empty
        or has only one node*/
        if (head == null || head.next == null) {
            // It's a palindrome by definition
            return true;
        }

        /* Initialize two pointers, slow and fast,
        to find the middle of the linked list*/
        ListNode slow = head;
        ListNode fast = head;

        /* Traverse the linked list to find the
        middle using slow and fast pointers*/
        while (fast.next != null && fast.next.next != null) {
            // Move slow pointer one step
            slow = slow.next;

            // Move fast pointer two steps
            fast = fast.next.next;
        }

        /*Reverse the second half of the
        linked list starting from the middle*/
        ListNode newHead = reverseLinkedList(slow.next);

        // Pointer to the first half
        ListNode first = head;

        // Pointer to the reversed second half
        ListNode second = newHead;
        while (second != null) {
            /*Compare data values of 
            nodes from both halves.
            If values do not match,
            the list is not a palindrome*/
            if (first.val != second.val) {
                /*Reverse the second half 
                back to its original state*/
                reverseLinkedList(newHead);

                // Not a palindrome
                return false;
            }

            // Move the first pointer
            first = first.next;

            // Move the second pointer
            second = second.next;
        }

        /*Reverse the second half
        back to its original state*/
        reverseLinkedList(newHead);

        // Linked List is a palindrome
        return true;
    }
}
/*
	Time Complexity: O(2xN) The algorithm involves traversing the linked list twice. The first traversal finds the middle and reverses the second half, while the second traversal compares elements from both halves. Since each traversal covers N/2 elements, the total time complexity is O(N/2 + N/2 + N/2 + N/2), which simplifies to O(2N), ultimately reducing to O(N).
	Space Complexity: O(1) This approach uses a constant amount of additional space, regardless of the linked list's size. It does not require any extra data structures that depend on the input size, resulting in a space complexity of O(1).
*/

class Main {
    static void printLinkedList(ListNode head) {
        ListNode temp = head;
        while (temp != null) {
            System.out.print(temp.val + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        /*Create a linked list with values 1, 5, 2, 5, and 1 (15251, a palindrome)*/
        ListNode head = new ListNode(1);
        head.next = new ListNode(5);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(5);
        head.next.next.next.next = new ListNode(1);

        // Print the original linked list
        System.out.print("Original Linked List: ");
        printLinkedList(head);

        // Check if the linked list is a palindrome
        IsPalindrome IsPalindrome = new IsPalindrome();
        if (IsPalindrome.isPalindrome(head)) {
            System.out.println("The linked list is a palindrome.");
        } else {
            System.out.println("The linked list is not a palindrome.");
        }
    }
}