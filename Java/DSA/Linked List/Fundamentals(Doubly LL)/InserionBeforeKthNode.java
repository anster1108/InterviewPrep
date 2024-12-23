/*
	Insert node before (kth node) in DLL
		Given the head of a doubly linked list and two integers X and K, insert a new node with value X, before the Kth node of the linked list and return the head of the modified linked list.

	Example 1
		Input: head -> 1 <-> 3 <-> 5, X = 7, K = 2
		Output: head -> 1 <-> 7 <-> 3 <-> 5
		Explanation: A node with value 7 was added before the 2nd node.

	Example 2
		Input: head -> 5, X = 7, K = 1
		Output: head -> 7 <-> 5
		Explanation: A node with value 7 was added, note that the head was changed.

	Example 3
		Input: head -> 4 <-> 5, X = 10, K = 2
		Output: head -> 4 <-> 10 <-> 5
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

// InserionBeforeKthNode class
class InserionBeforeKthNode {
    /* Function to insert a node before the
    Kth node in a doubly linked list */
    public ListNode insertBeforeKthPosition(ListNode head, int X, int K) {
        // If node has to be inserted before the head
        if (K == 1) {
            ListNode newHead = new ListNode(X, head, null);
            head.prev = newHead;
            return newHead;
        }

        // Temporary pointer 
        ListNode temp = head;

        // Reach Kth node
        int count = 0;
        while (temp != null) {
            count++;

            // If Kth node is reached, Break out of the loop
            if (count == K) break;

            // Otherwise Keep moving temp forward
            temp = temp.next;
        }

        // Track the node 
        ListNode prev = temp.prev;

        // Create new node with data as X
        ListNode newNode = new ListNode(X, temp, prev);

        // Join new node 
        prev.next = newNode;
        temp.prev = newNode;

        // Return head 
        return head;
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
        int[] nums = {1, 2, 3, 5};

        // Creating the doubly linked list from given array
        ListNode head = arrayToLinkedList(nums);

        // Print the Original list
        System.out.print("Original List: ");
        printLL(head);

        // Create an instance of InserionBeforeKthNode class
        InserionBeforeKthNode sol = new InserionBeforeKthNode();

        /* Function call to insert a node before the
        Kth node in a doubly linked list */
        head = sol.insertBeforeKthPosition(head, 4, 4);

        // Print the Modified list
        System.out.print("Modified list: ");
        printLL(head);
    }
}