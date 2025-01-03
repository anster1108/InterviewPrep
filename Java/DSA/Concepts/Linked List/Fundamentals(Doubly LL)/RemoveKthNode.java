/*
	Removing given node in DLL
		Given a node's reference within a doubly linked list, remove that node from the linked list while preserving the list's integrity.
		You will only be given the node's reference, not the head of the list. It is guaranteed that the given node will not be the head of the list.

	Example 1
		Input: head -> 1 <-> 3 <-> 5, node = 3
		Output: head -> 1 <-> 5
		Explanation: The referenced node with value 3 was removed.

	Example 2
		Input: head -> 1 <-> 3 <-> 7, node = 7
		Output: head -> 1 <-> 3
		Explanation: The referenced node with value 7 was removed.

	Example 3
		Input: head -> 1 <-> 5, node = 5
		Output: head -> 1
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

// RemoveKthNode class
class RemoveKthNode {
    /* Function to delete the given node 
    from doubly linked list */
    public void deleteGivenNode(ListNode node) {
        ListNode prev = node.prev;
        ListNode front = node.next;

        // Edge case if the given node is the tail node
        if (front == null) {
            prev.next = null;
            node.prev = null;
            return;
        }

        // Disconnect node 
        prev.next = front;
        front.prev = prev;

        // Set node's pointers to null
        node.next = null;
        node.prev = null;
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
        // Node to be deleted
        ListNode node = head.next.next;

        // Print the Original list
        System.out.print("Original List: ");
        printLL(head);

        // Create an instance of RemoveKthNode class
        RemoveKthNode sol = new RemoveKthNode();

        /* Function call to delete the given
        node from the doubly linked list */
        sol.deleteGivenNode(node);

        // Print the Modified list
        System.out.print("Modified list: ");
        printLL(head);
    }
}