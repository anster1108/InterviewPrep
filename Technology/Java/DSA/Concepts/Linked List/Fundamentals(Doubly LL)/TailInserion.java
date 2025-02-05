/*
	Insert node before tail in DLL
		Given the head of a doubly linked list and an integer X, insert a node with value X before the tail of the linked list and return the head of the modified list.

	Example 1
		Input: head -> 1 <-> 2 <-> 4, X = 3
		Output: head -> 1 <-> 2 <-> 3 <-> 4
		Explanation: 3 was added before the last node.

	Example 2
		Input: head -> 4, X = 6
		Output: head -> 6 <-> 4
		Explanation: 6 was added before 4, note that the head was changed as a result.

	Example 3
		Input: head -> 4 <-> 5, X = 6
		Output: head -> 4 <-> 6 <-> 5
*/
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

// TailInserion class
class TailInserion {
    // Function to insert a node before tail of a doubly linked list
    public ListNode insertBeforeTail(ListNode head, int X) {
        // Edge case
        if (head.next == null) {
            // Create new node with data as X
            ListNode newHead = new ListNode(X, head, null);
            head.prev = newHead;
            return newHead;
        }

        // Create pointer tail
        ListNode tail = head;
        while (tail.next != null) {
            tail = tail.next;
        }

        // Keep track of node before tail using prev
        ListNode prev = tail.prev;

        // Create new node with value X
        ListNode newNode = new ListNode(X, tail, prev);

        // Join the new node
        prev.next = newNode;
        tail.prev = newNode;

        // Return updated linked list
        return head;
    }
}

// Main method
class Main {
    // Helper Function to convert an array to a doubly linked list
    private static ListNode arrayToLinkedList(int[] nums) {
        // If array is empty, return null
        if (nums.length == 0) return null;

        // Create head node with first element of the array
        ListNode head = new ListNode(nums[0]);
        // Initialize 'prev' to the head node
        ListNode prev = head;

        for (int i = 1; i < nums.length; i++) {
            // Create a new node
            ListNode temp = new ListNode(nums[i], null, prev);
            // Update 'next' pointer
            prev.next = temp;
            // Move 'prev' to newly created node
            prev = temp;
        }

        // Return head
        return head;
    }

    // Helper Function to print the linked list
    private static void printLL(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.println();
    }
    
    // main method
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 5};

        // Creating the doubly linked list from given array
        ListNode head = arrayToLinkedList(nums);

        // Print the Original list
        System.out.print("Original List: ");
        printLL(head);

        // Create an instance of TailInserion class
        TailInserion sol = new TailInserion();

        /* Function call to insert a node
        before tail of a doubly linked list */
        head = sol.insertBeforeTail(head, 4);

        // Print the Modified list
        System.out.print("Modified list: ");
        printLL(head);
    }
}