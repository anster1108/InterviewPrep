/*
	Delete head of DLL
		Given the head of a doubly linked list, remove the node at the head of the linked list and return the head of the modified list.
		The head is the first node of the linked list.

	Example 1
		Input: head -> 1 <-> 2 <-> 3

		Output: head -> 2 <-> 3

		Explanation: The node with value 1 was removed.

	Example 2
		Input: head -> 7

		Output: head

		Explanation: Note that the head has null value after the removal.

	Example 3
		Input: head -> 2 <-> 4

		Output:	head -> 4
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

// HeadDeletion class
class HeadDeletion {
    // Function to delete the head of the doubly linked list
    public ListNode deleteHead(ListNode head) {
        if (head == null || head.next == null)
            return null; // Return null if the list is empty or has one node
        
        // Store current head as 'prev'
        ListNode prev = head;
        // Move 'head' to next node
        head = head.next;

        // Set 'prev' pointer
        head.prev = null;

        // Set 'next' pointer
        prev.next = null;

        // Return new head
        return head;
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
        int[] nums = {1, 2, 3, 4, 5};

        // Creating the doubly linked list from given array
        ListNode head = arrayToLinkedList(nums);

        // Print the Original list
        System.out.print("Original List: ");
        printLL(head);

        // Create an instance of HeadDeletion class
        HeadDeletion sol = new HeadDeletion();

        // Function call to delete the head of the doubly linked list
        head = sol.deleteHead(head);

        // Print the Modified list
        System.out.print("Modified list: ");
        printLL(head);
    }
}