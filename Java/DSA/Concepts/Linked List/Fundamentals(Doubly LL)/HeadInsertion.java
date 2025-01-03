/*
	Insert node before head in DLL
		Given the head of a doubly linked list and an integer X, insert a node with value X before the head of the linked list and return the head of the modified list.
	
	Example 1
		Input: head -> 1 <-> 2 <-> 3, X = 3
		Output: head -> 3 <-> 1 <-> 2 <-> 3
		Explanation: 3 was added before the 1st node. Note that the head's value is changed.

	Example 2
		Input: head -> 5, X = 7
		Output: head -> 7 <-> 5

	Example 3
		Input: head -> 2 <-> 3, X = 10
		Output:head -> 10 <-> 2 <-> 3
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

// HeadInsertion class
class HeadInsertion {
    /* Function to insert a node before 
    head in a doubly linked list */
    public ListNode insertBeforeHead(ListNode head, int X) {
        // Create new node which will be the new head
        ListNode newHead = new ListNode(X, head, null);

        // Point the current head back to new one
        head.prev = newHead;

        return newHead; // Return new head
    }
}

// Main class
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
        int[] nums = {2, 3, 4, 5};

        // Creating the doubly linked list from given array
        ListNode head = arrayToLinkedList(nums);

        // Print the Original list
        System.out.print("Original List: ");
        printLL(head);

        // Create an instance of HeadInsertion class
        HeadInsertion sol = new HeadInsertion();

        /* Function call to insert a node before 
        head in a doubly linked list */
        head = sol.insertBeforeHead(head, 1);

        // Print the Modified list
        System.out.print("Modified list: ");
        printLL(head);
    }
}