/*
	Find the intersection point of Y LL

		Given the heads of two linked lists A and B, containing positive integers. Find the node at which the two linked lists intersect. If they do intersect, return the node at which the intersection begins, otherwise return null.

		The Linked List will not contain any cycles. The linked lists must retain their original structure, given as per the input, after the function returns.

		Note: for custom input, the following parameters are required(your program is not provided with these parameters):

			intersectVal - The value of the node where the intersection occurs. This is -1 if there is no intersected node.
			
			skipA - The number of nodes to skip ahead in listA (starting from the head) to get to the intersected node(-1 if no intersection).
		
			skipB - The number of nodes to skip ahead in listB (starting from the head) to get to the intersected node(-1 if no intersection).
	
			listA - The first linked list.
		
			listB - The second linked list.

		Example 1
			Input: listA: intersectVal = 4, skipA = 3, skipB = 2, head -> 1 -> 2 -> 3 -> 4 -> 5, listB: head -> 7 -> 8 -> 4 -> 5
			Output(value at returned node is displayed): 4
			Explanation: The two lists have nodes with values 4 and 5 as their tails.

		Example 2
			Input: listA: intersectVal = -1, skipA = -1, skipB = -1, head -> 1 -> 2 -> 3, listB: head -> 8 -> 9
			Output(value at returned node is displayed): null
			Explanation: The two lists do not intersect.



	Brute :
		Complexity Analysis
			Time Complexity: O(Mx N), where 'M' is the number of nodes in list A and 'N' is the number of nodes in list B. This is because, for each node in list B, we iterate through the entire list A to check if there is an intersection. In the worst-case scenario, if there is no intersection, this results in a nested loop structure where each node in list B is compared with every node in list A, leading to O(MxN) operations.

			Space Complexity: O(1) This is because no additional data structures are used that scale with the size of the input. We only use a few pointers to traverse the lists, and these require a constant amount of space regardless of the size of the input lists.

		Code:

			public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		        // Traverse the second list
		        while (headB != null) {
		            // For each node in the second list, 
		            // Traverse the first list
		            ListNode temp = headA;
		            while (temp != null) {
		                // If the current node 
		                // Of the first list is the 
		                // Same as the current node of 
		                // The second list
		                if (temp == headB) 
		                    // Intersection node
		                    return headB;
		                // Move to the next node 
		                // In the first list
		                temp = temp.next;
		            }
		            // Move to the next node 
		            // In the second list
		            headB = headB.next;
		        }
		        // No intersection found
		        return null;
		    }
	Better : 
		Complexity Analysis
			Time Complexity: O(N+M) The reason for this time complexity is that we first iterate through all nodes in the first list, which takes O(N) time. After that, we iterate through all nodes in the second list, which takes O(m) time. Therefore, the total time complexity is O(N+M).

			Space Complexity: O(N) The reason for this space complexity is that we use an unordered_set to store the addresses of all nodes in the first list. The space required for this set depends on the number of nodes in the first list, which is O(N).

		Code :

		 	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		        // Create a hash set to store the nodes
		        // Of the first list
		        HashSet<ListNode> nodes_set = new HashSet<>();

		        // Traverse the first linked list
		        // And add all its nodes to the set
		        while (headA != null) {
		            nodes_set.add(headA);
		            headA = headA.next;
		        }

		        // Traverse the second linked list
		        // And check for intersection
		        while (headB != null) {
		            // If a node from the second list is found in the set,
		            // It means there is an intersection
		            if (nodes_set.contains(headB)) {
		                return headB;
		            }
		            headB = headB.next;
		        }

		        // No intersection found, return null
		        return null;
		    }
*/

class ListNode {
    int val;
    ListNode next;

    ListNode() {
        val = 0;
        next = null;
    }

    ListNode(int data1) {
        val = data1;
        next = null;
    }

    ListNode(int data1, ListNode next1) {
        val = data1;
        next = next1;
    }
}

class FindIntersection {
    // Function to find the intersection node of two linked lists
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        // Initialize two pointers, d1 and d2
        // To the heads of the two lists
        ListNode d1 = headA;
        ListNode d2 = headB;

        // Traverse both lists until the pointers meet
        while (d1 != d2) {
            // Move pointer d1 to the head
            // Of the second list if it reaches
            // The end of the first list
            d1 = (d1 == null) ? headB : d1.next;
            // Move pointer d2 to the head
            // Of the first list if it reaches
            // The end of the second list
            d2 = (d2 == null) ? headA : d2.next;
        }

        // Return the intersection node
        return d1;
    }
}

// Utility function to insert a node at the end of the linked list
void insertNode(ListNode head, int val) {
    // Create a new node with the given value
    ListNode newNode = new ListNode(val);
    // If the list is empty, set the new node as the head
    if (head == null) {
        head = newNode;
        return;
    }
    // Otherwise, traverse to the end of the list
    ListNode temp = head;
    while (temp.next != null) temp = temp.next;
    // Insert the new node at the end of the list
    temp.next = newNode;
}

// Utility function to print the linked list
void printList(ListNode head) {
    // Traverse the list
    while (head.next != null) {
        // Print the value of each node followed by an arrow
        System.out.print(head.val + "->");
        head = head.next;
    }
    // Print the value of the last node
    System.out.println(head.val);
}

public class Main {
    public static void main(String[] args) {
        // Creation of the first list
        ListNode head1 = null;
        insertNode(head1, 1);
        insertNode(head1, 3);
        insertNode(head1, 1);
        insertNode(head1, 2);
        insertNode(head1, 4);

        // Create an intersection
        ListNode intersection = head1.next.next.next;

        // Creation of the second list
        ListNode head2 = null;
        insertNode(head2, 3);
        head2.next = intersection;

        // Printing the lists
        System.out.print("List1: ");
        printList(head1);
        System.out.print("List2: ");
        printList(head2);

        // Checking if an intersection is present
        FindIntersection sol = new FindIntersection();
        ListNode answerNode = sol.getIntersectionNode(head1, head2);
        if (answerNode == null)
            System.out.println("No intersection");
        else
            System.out.println("The intersection point is " + answerNode.val);
    }
}

/*
	Complexity Analysis
		Time Complexity: O(2 x max(length of list1, length of list2)) This is because the algorithm traverses each linked list entirely, ensuring that both pointers traverse the entire length of both lists. The maximum number of steps required is twice the length of the longer list, accounting for the difference in their lengths.

		Space Complexity: O(1) The algorithm uses only a fixed amount of extra space, as it relies solely on pointer manipulation within the existing lists. No additional data structures are required, making the space complexity constant.
*/
