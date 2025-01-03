/*
	Insert before given node in DLL
		Given a node's reference within a doubly linked list and an integer X, insert a node with value X before the given node in the linked list while preserving the list's integrity.
		You will only be given the node's reference, not the head of the list. It is guaranteed that the given node will not be the head of the list.

	Example 1
		Input: head -> 1 <-> 2 <-> 6, node = 2, X = 7
		Output: head -> 1 <-> 7 <-> 2 <-> 6
		Explanation: Note that the head was not given to the function.

	Example 2
		Input: head -> 7 <-> 5 <-> 5, node = 5 (node 3), X = 10
		Output: head -> 7 <-> 5 <-> 10 <-> 5
		Explanation: The last node with value 5 was referenced, thus the new node was added before the last node.

	Example 3
		Input: head -> 7 <-> 6 <-> 5, node = 5, X = 10
		Output: head -> 7 <-> 6 <-> 10 <-> 5
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

// InserionBeforeGivenNode class
class InserionBeforeGivenNode {
    /* Function to insert a new node before
    given node in a doubly linked list */
    public void insertBeforeGivenNode(ListNode node, int X) {
        // Get node before the given node
        ListNode prev = node.prev;

        // Create new node
        ListNode newNode = new ListNode(X, node, prev);

        // Connect newNode
        prev.next = newNode;
        node.prev = newNode;

        // void function to just update
        return;
    }
}

// Class main 
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
        int[] nums = {1, 2, 4, 5};

        // Creating the doubly linked list from given array
        ListNode head = arrayToLinkedList(nums);

        // Node before which the new node must be inserted
        ListNode node = head.next.next;

        // Print the Original list
        System.out.print("Original List: ");
        printLL(head);

        // Create an instance of InserionBeforeGivenNode class
        InserionBeforeGivenNode sol = new InserionBeforeGivenNode();

        /* Function call to insert a new node before
        given node in a doubly linked list */
        sol.insertBeforeGivenNode(node, 3);

        // Print the Modified list
        System.out.print("Modified list: ");
        printLL(head);
    }
}