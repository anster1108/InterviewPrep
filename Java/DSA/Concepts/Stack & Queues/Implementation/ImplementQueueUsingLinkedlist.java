/*
	Real Life Example
		Think of a line of cars waiting at a drive-thru. Each car is connected to the one in front of it, forming a chain. The car at the front is served first, and when it leaves, the next car in line becomes the new front. Cars continue to arrive at the end of the line, and each new arrival is connected to the last car. This way, the line can grow or shrink as needed, much like how a linked list dynamically adjusts its size without any fixed limit.

	Intuition
		Implementing a queue using a linked list leverages the dynamic memory allocation properties of linked lists. This allows the queue to grow and shrink as needed without a predetermined size. Each element in the queue is represented by a node in the linked list, and the queue is managed through pointers to the front and rear nodes, enabling efficient addition and removal of elements.

		Approaching the problem of implementing a queue using a linked list can be visualized through the drive-thru line of cars example. Each car represents a node in the linked list, with the front car corresponding to the front node and the last car to the rear node. When a new car arrives (enqueue operation), a new node is created and linked to the rear node, updating the rear pointer to this new node. When the front car is served and leaves (dequeue operation), the front pointer is updated to the next node in line. This dynamic linking allows the queue to efficiently grow and shrink, just as the line of cars adjusts with arrivals and departures.

	Approach
		Node Structure: Define a node that holds data and a pointer to the next node. This node is the basic building block of the linked list.
		
		Queue Initialization:
			Initialize the queue with pointers to both the front and rear of the queue. Set these pointers to null initially, indicating an empty queue.
			
			Maintain a counter to track the number of elements in the queue.
		Enqueue Operation (Adding an Element):
			Create a new node with the given data.
			
			If the queue is empty, set both the front and rear pointers to this new node.
			
			If the queue is not empty, link the current rear node to the new node and update the rear pointer to point to the new node.
		Dequeue Operation (Removing an Element):
			Check if the queue is empty. If it is, return an appropriate message or handle the empty condition.
			
			If the queue is not empty, move the front pointer to the next node and delete the old front node.
			
			If the queue becomes empty after removal, set the rear pointer to null.
		Peek Operation (Accessing the Front Element):
			Check if the queue is empty. If it is, return an appropriate message or handle the empty condition.
			
			If the queue is not empty, return the data of the front node without removing it.
		Size Operation:
			Return the value of the counter tracking the number of elements in the queue.
		IsEmpty Operation:
			Check if the front pointer is null. If it is, the queue is empty; otherwise, it is not.

	Complexity Analysis
		Time Complexity: O(1) because the time complexity for the push, pop, peek, size, and isEmpty operations is O(1).

		Space Complexity: O(N) where N is the number of elements of the stack.
*/
import java.util.*;

// Node structure
class Node {
    int val;
    Node next;
    Node(int d) {
        val = d;
        next = null;
    }
}

// Structure to represent queue
class LinkedListQueue {
    private Node start; // Start of the queue
    private Node end; // End of the queue
    private int size; // Size of the queue

    // Constructor
    public LinkedListQueue() {
        start = end = null;
        size = 0;
    }

    // Method to push an element in the queue
    public void push(int x) {
        // Creating a node
        Node element = new Node(x);
        
        // If it is the first element being pushed
        if (start == null) {
            // Initialize the pointers
            start = end = element;
        } else {
            end.next = element; // Updating the pointers
            end = element; // Updating the end
        }
        
        // Increment size by 1
        size++;
    }

    // Method to pop an element from the queue
    public int pop() {
        // If the queue is empty
        if (start == null) {
            return -1; // Pop operation cannot be performed
        }
        
        int value = start.val; // Get the front value
        Node temp = start; // Store the front temporarily
        start = start.next; // Update front to next node
        temp = null; // Delete old front node
        size--; // Decrement size
        
        return value; // Return data
    }

    // Method to get the front element in the queue
    public int peek() {
        // If the queue is empty
        if (start == null) {
            return -1; // Front element cannot be accessed
        }
        
        return start.val; // Return the front
    }

    // Method to check if the queue is empty
    public boolean isEmpty() {
        return (size == 0);
    }
}

class ImplementQueueUsingLinkedlist {
    public static void main(String[] args) {
        // Creating a queue
        LinkedListQueue q = new LinkedListQueue();

        // Array of commands
        String[] commands = {"LinkedListQueue", "push", "push", 
                             "peek", "pop", "isEmpty"};
        // Array of inputs
        int[][] inputs = {{}, {3}, {7}, {}, {}, {}};

        for (int i = 0; i < commands.length; ++i) {
            if (commands[i].equals("push")) {
                q.push(inputs[i][0]);
                System.out.print("null ");
            } else if (commands[i].equals("pop")) {
                System.out.print(q.pop() + " ");
            } else if (commands[i].equals("peek")) {
                System.out.print(q.peek() + " ");
            } else if (commands[i].equals("isEmpty")) {
                System.out.print((q.isEmpty() ? "true" : "false") + " ");
            } else if (commands[i].equals("LinkedListQueue")) {
                System.out.print("null ");
            }
        }
    }
}