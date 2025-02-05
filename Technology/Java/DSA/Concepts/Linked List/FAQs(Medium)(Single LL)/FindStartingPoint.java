/*
	Find the starting point in LL
		Given the head of a singly linked list, the task is to find the starting point of a loop in the linked list if it exists. Return the starting node if a loop exists; otherwise, return null.

		A loop exists in a linked list if some node in the list can be reached again by continuously following the next pointer. Internally, pos denotes the index (0-based) of the node from where the loop starts.

		Note that pos is not passed as a parameter.

	Brute : 
		Time Complexity: O(N) The algorithm goes through the entire linked list once, with 'N' representing the total number of nodes. As a result, the time complexity is linear, or O(N).

		Space Complexity: O(N) The algorithm utilizes a hash map to store the nodes it encounters. This hash map can store up to 'N' nodes, where 'N' is the total number of nodes in the list. Therefore, the space complexity is O(N) because of the additional space used by the hash map.

		Code :
			public ListNode findStartingPoint(ListNode head) {
		        // Use temp to traverse the linked list
		        ListNode temp = head;
		        
		        // HashMap to store all visited nodes
		        HashMap<ListNode, Integer> map = new HashMap<>();
		        
		        // Traverse the list using temp
		        while (temp != null) {
		            // Check if temp has been encountered again
		            if (map.containsKey(temp)) {
		                // A loop is detected hence return temp
		                return temp;
		            }
		            // Store temp as visited
		            map.put(temp, 1);
		            // Move to the next node
		            temp = temp.next;
		        }

		        // If no loop is detected, return null
		        return null;
		    }
*/
//Definition of singly linked list:
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


class FindStartingPoint {
    public ListNode findStartingPoint(ListNode head) {
        // Initialize a slow and fast 
        // pointers to the head of the list
        ListNode slow = head;
        ListNode fast = head;

        // Phase 1: Detect the loop
        while (fast != null && fast.next != null) {
            
            // Move slow one step
            slow = slow.next;
            
            // Move fast two steps
            fast = fast.next.next;

            // If slow and fast meet,
            // a loop is detected
            if (slow == fast) {
                
                // Reset the slow pointer
                // to the head of the list
                slow = head;

                // Phase 2: Find the first node of the loop
                while (slow != fast) {
                    
                    // Move slow and fast one step
                    // at a time
                    slow = slow.next;
                    fast = fast.next;

                    // When slow and fast meet again,
                    // it's the first node of the loop
                }
                
                // Return the first node of the loop
                return slow;
            }
        }
        
        // If no loop is found, return null
        return null;
    }
}

public class Main {
    public static void main(String[] args) {
        // Create a sample linked list with a loop
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        node1.next = node2;
        ListNode node3 = new ListNode(3);
        node2.next = node3;
        ListNode node4 = new ListNode(4);
        node3.next = node4;
        ListNode node5 = new ListNode(5);
        node4.next = node5;

        // Make a loop from node5 to node2
        node5.next = node2;

        // Set the head of the linked list
        ListNode head = node1;

        // Detect the loop in the linked list
        FindStartingPoint sol = new FindStartingPoint();
        ListNode loopStartNode = sol.findStartingPoint(head);

        if (loopStartNode != null) {
            System.out.println("Loop detected. Starting node of the loop is: " + loopStartNode.val);
        } else {
            System.out.println("No loop detected in the linked list.");
        }
    }
}

/*
	Time Complexity: O(N) The code examines each node in the linked list exactly once, where 'N' is the total number of nodes. This results in a linear time complexity, O(N), as the traversal through the list is direct and sequential.

	Space Complexity: O(1) The code uses a fixed amount of extra space, regardless of the size of the linked list. This is accomplished by employing two pointers, slow and fast, to detect the loop. Since no additional data structures are used that depend on the size of the list, the space complexity remains constant, O(1).
*/