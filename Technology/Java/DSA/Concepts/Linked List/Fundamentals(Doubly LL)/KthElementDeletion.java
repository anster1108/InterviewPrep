/*
	Delete Kth Element of DLL
		Given the head of a doubly linked list and an integer k, remove the node at the kth position of the linked list and return the head of the modified list.

	Example 1
		Input: head -> 2 <-> 5 <-> 7 <-> 9, k = 2
		Output: head -> 2 <-> 7 <-> 9
		Explanation: The node with value 5 was removed.

	Example 2
		Input: head -> 2 <-> 5 <-> 7, k = 1
		Output: head -> 5 <-> 7
		Explanation: The node with value 2 was removed, note that the head was modified.

	Example 3
		Input: head -> 2 <-> 5 <-> 7, k = 3
		Output: head -> 2 <-> 5
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

// KthElementDeletion class
class KthElementDeletion {
    // Function to remove the Kth element
    public ListNode deleteKthElement(ListNode head, int k) {
        // If the list is empty, return null
        if (head == null) 
            return null;
    
        int count = 0;
        ListNode kNode = head;

        // Traverse the list
        while (kNode != null) {
            count++;
            if (count == k) break;
            kNode = kNode.next;
        }

        // If k is larger than the list size
        if (kNode == null) return head; 
        
        // Update the pointers
        ListNode prev = kNode.prev;
        ListNode front = kNode.next;

        // If node to be deleted is the only node in the list
        if (prev == null && front == null) {
            return null;
        }
        
        // If node to be deleted is head of the list
        else if (prev == null) {
            head = front;
            front.prev = null;
        }
        
        // If node to be deleted is tail of the list
        else if (front == null) {
            prev.next = null;
        }
        
        // If node to be deleted is in the middle of the list
        else {
            prev.next = front;
            front.prev = prev;
        }

        // Return modified list head
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
        int k = 2;

        // Creating the doubly linked list from given array
        ListNode head = arrayToLinkedList(nums);

        // Print the Original list
        System.out.print("Original List: ");
        printLL(head);

        // Create an instance of KthElementDeletion class
        KthElementDeletion sol = new KthElementDeletion();

        // Function call to delete the kth Node of the doubly linked list
        head = sol.deleteKthElement(head, k);

        // Print the Modified list
        System.out.print("Modified list: ");
        printLL(head);
    }
}