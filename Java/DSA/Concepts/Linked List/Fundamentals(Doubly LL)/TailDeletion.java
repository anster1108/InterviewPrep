/*
	Delete Tail of DLL
		Given the head of a doubly linked list, remove the node at the tail of the linked list and return the head of the modified list.
		The tail is the last node of the linked list.

	Example 1
		Input: head -> 1 <-> 2 <-> 3
		Output: head -> 1 <-> 2
		Explanation: The node with value 3 was removed.

	Example 2
		Input: head -> 7
		Output: head
		Explanation: Note that the head has null value after the removal.
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

// TailDeletion class
class TailDeletion {
    // Function to delete the tail of a doubly linked list
    public ListNode deleteTail(ListNode head) {
        if (head == null || head.next == null) {
            return null;  
        }
        
        // Navigate to the tail of the linked list
        ListNode tail = head;
        while (tail.next != null) {
            tail = tail.next;
        }
        
        // Update the pointers
        ListNode newTail = tail.prev;
        newTail.next = null;
        tail.prev = null;
        
        // Return head of modified list
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

        // Create an instance of TailDeletion class
        TailDeletion sol = new TailDeletion();

        // Function call to delete the tail of the doubly linked list
        head = sol.deleteTail(head);

        // Print the Modified list
        System.out.print("Modified list: ");
        printLL(head);
    }
}