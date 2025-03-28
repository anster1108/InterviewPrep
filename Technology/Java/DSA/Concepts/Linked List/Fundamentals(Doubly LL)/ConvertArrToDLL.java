/*
	Convert Array to DLL
		Given an array nums, convert it into a doubly linked list and return the head of the list.

	Example 1
		Input: nums = [1, 2, 3, 4]
		Output: head -> 1 <-> 2 <-> 3 <-> 4
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

// ConvertArrToDLL class
class ConvertArrToDLL {
    // Function to convert an array to a doubly linked list
    public ListNode arrayToLinkedList(int[] nums) {
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
}

// Main Class
class Main {
    // Helper function to print the linked list
    private static void printLL(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.println();
    }
    
    // main method
    public static void main(String[] args) {
        // Declare nums as a 1D array
        int[] nums = {1, 2, 3, 4, 5};

        // Create an instance of ConvertArrToDLL class
        ConvertArrToDLL sol = new ConvertArrToDLL();

        // Function call to convert an array to a doubly linked list
        ListNode head = sol.arrayToLinkedList(nums);

        // Print the doubly linked list
        System.out.println("The doubly linked list is: ");
        printLL(head);
    }
}