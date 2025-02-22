/*
	Real Life Example
	Consider a stack of plates in a cafeteria. Each time a plate is added, it is placed on top of the stack, and when a plate is taken, it is removed from the top. This ensures that the last plate added is the first one to be used. If this stack of plates were managed using a linked list, each plate would be a node in the list, dynamically linked to the one below it. This structure allows adding or removing plates without worrying about a fixed capacity or the need to shuffle plates around, mimicking the behavior of a real-world stack with dynamic flexibility.

	Intuition
	Implementing a stack using a linked list offers several advantages over using an array. Linked lists provide dynamic size flexibility, allowing the stack to grow and shrink as needed without worrying about predefined capacity or memory wastage. Each node in the linked list contains data and a reference to the next node, enabling efficient constant-time operations for both push and pop. This eliminates the risk of stack overflow and avoids the need for costly resizing operations, making linked lists an ideal choice for managing the dynamic nature of stack operations.

	Approaching the problem of implementing a stack using a linked list can be likened to managing the stack of plates in the cafeteria example. Each plate represents a node in the linked list, and the top plate corresponds to the top node. To add a plate (push operation), a new node is created and placed on top of the stack, pointing to the previous top node. To remove a plate (pop operation), the top node is removed, and the next node in line becomes the new top. This dynamic linking and unlinking process allows the stack to grow and shrink efficiently, without any predefined capacity, just as the stack of plates can adjust to the number of plates being added or taken away.

	Approach
		Node Structure:
			Define a node with:
				An integer to store data.
				A pointer to the next node.
				A constructor to initialize data and the next pointer.
		Stack Structure:
			Define a stack with:
				A pointer to the top node.
				An integer to keep track of the size.
				A constructor to initialize the top pointer and size.
		Push Operation:
			Create a new node with the given data & set the new node's next pointer to the current top node.
			Update the top pointer to the new node. Increment the size.
		Pop Operation:
			Check if the stack is empty. If it is, return an error value (e.g., -1).
			Store the data of the top node & update the top pointer to the next node.
			Delete the old top node & decrement the size. Return the stored data.
		Peek Operation:
			Check if the stack is empty. If it is, return an error value (e.g., -1). Otherwise, return the data of the top node.
		Is Empty Operation:
			Check if the top pointer is null. Return true if the top pointer is null, otherwise false.
		Size Operation:
			Return the size of the stack.
		Print Stack:
			Traverse from the top node and print each node's data until reaching the end of the list.
	Complexity Analysis
		Time Complexity: O(1) for push, pop, size,isEmpty, peek operations.

		Space Complexity: O(N) because the stack requires space proportional to the number of elements it stores.
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

// Structure to represent stack
class LinkedListStack {
    private Node head; // Top of Stack
    private int size; // Size

    // Constructor
    public LinkedListStack() {
        head = null;
        size = 0;
    }

    // Method to push an element onto the stack
    public void push(int x) {
        // Creating a node
        Node element = new Node(x);
        
        element.next = head; // Updating the pointers
        head = element; // Updating the top
        
        // Increment size by 1
        size++;
    }

    // Method to pop an element from the stack
    public int pop() {
        // If the stack is empty
        if (head == null) {
            return -1; // Pop operation cannot be performed
        }
        
        int value = head.val; // Get the top value
        Node temp = head; // Store the top temporarily
        head = head.next; // Update top to next node
        temp = null; // Delete old top node
        size--; // Decrement size
        
        return value; // Return data
    }

    // Method to get the top element of the stack
    public int top() {
        // If the stack is empty
        if (head == null) {
            return -1; // Top element cannot be accessed
        }
        
        return head.val; // Return the top
    }

    // Method to check if the stack is empty
    public boolean isEmpty() {
        return (size == 0);
    }
}

class ImplementStackUsingLinkedlist{
    public static void main(String[] args) {
        // Creating a stack
        LinkedListStack st = new LinkedListStack();

        // Array of commands
        String[] commands = {"LinkedListStack", "push", "push", 
                             "pop", "top", "isEmpty"};
        // Array of inputs
        int[][] inputs = {{}, {3}, {7}, {}, {}, {}};

        for (int i = 0; i < commands.length; ++i) {
            if (commands[i].equals("push")) {
                st.push(inputs[i][0]);
                System.out.print("null ");
            } else if (commands[i].equals("pop")) {
                System.out.print(st.pop() + " ");
            } else if (commands[i].equals("top")) {
                System.out.print(st.top() + " ");
            } else if (commands[i].equals("isEmpty")) {
                System.out.print((st.isEmpty() ? "true" : "false") + " ");
            } else if (commands[i].equals("LinkedListStack")) {
                System.out.print("null ");
            }
        }
    }
}