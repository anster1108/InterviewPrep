/*
	Using two Stacks where push operation is O(N)
	
		Real Life Example
			To better visualize this problem imagine a line of people waiting to get tickets for a movie. The first person who arrives at the counter is the first one to get the ticket, just like in a queue. Now, if there are two large boxes, one for placing and another for reversing the order of tickets, the first box can be used to collect tickets from people in the order they arrive. When it's time to issue the tickets, they can be transferred to the second box to reverse their order, ensuring the first person to arrive is the first one to get the ticket, simulating the behavior of a queue using stacks.

		Intuition
			The goal is to implement a queue using stacks, which naturally follow Last In, First Out (LIFO) order. To achieve the First In, First Out (FIFO) order of a queue, the idea is to use two stacks. By pushing elements onto one stack and then transferring them to another stack before popping, the order of elements is reversed twice. This ensures that the first element pushed onto the stack is the first one to be popped, thus mimicking a queue's behavior.

		Approach
			Use Two Stacks: Maintain two stacks, stack1 and stack2.

			Push Operation:
				Transfer all elements from stack1 to stack2.
				Add the new element to stack1.
				Transfer all elements back from stack2 to stack1.
				This ensures the new element is always at the front for the next pop operation.

			Pop Operation: Remove and return the top element from stack1.
			
			Top Operation: Return the top element of stack1 without removing it.
			
			Size Operation: Return the size of stack1.

		Complexity Analysis:
			Time Complexity: O(N) where N is the number of elements.

			Space Complexity: O(2N) because, in the worst case, both the input and output stacks can each hold up to N elements, totalling 2N elements. Here N is the size of the stack.
*/
import java.util.*;

class StackQueue {
    private Stack<Integer> st1, st2;

    // Constructor
    public StackQueue() {
        st1 = new Stack<>();
        st2 = new Stack<>();
    }

    // Method to push elements in the queue
    public void push(int x) {
        /* Pop out elements from the first stack 
        and push on top of the second stack */
        while (!st1.isEmpty()) {
            st2.push(st1.pop());
        }

        // Insert the desired element
        st1.push(x);

        /* Pop out elements from the second stack 
        and push back on top of the first stack */
        while (!st2.isEmpty()) {
            st1.push(st2.pop());
        }
    }

    // Method to pop element from the queue
    public int pop() {
        // Edge case
        if (st1.isEmpty()) {
            System.out.println("Stack is empty");
            return -1; // Representing empty stack
        }

        // Get the top element
        int topElement = st1.pop(); // Perform the pop operation

        return topElement; // Return the popped value
    }

    // Method to get the front element from the queue 
    public int peek() {
        // Edge case
        if (st1.isEmpty()) {
            System.out.println("Stack is empty");
            return -1; // Representing empty stack
        }

        // Return the top element
        return st1.peek();
    }

    // Method to find whether the queue is empty
    public boolean isEmpty() {
        return st1.isEmpty();
    }
}

class ImplementQueueUsingStack {
    public static void main(String[] args) {
        StackQueue q = new StackQueue();

        // List of commands
        String[] commands = {"StackQueue", "push", "push", 
                             "pop", "peek", "isEmpty"};
        // List of inputs
        int[][] inputs = {{}, {4}, {8}, {}, {}, {}};

        for (int i = 0; i < commands.length; i++) {
            if (commands[i].equals("push")) {
                q.push(inputs[i][0]);
                System.out.print("null ");
            } else if (commands[i].equals("pop")) {
                System.out.print(q.pop() + " ");
            } else if (commands[i].equals("peek")) {
                System.out.print(q.peek() + " ");
            } else if (commands[i].equals("isEmpty")) {
                System.out.print((q.isEmpty() ? "true" : "false") + " ");
            } else if (commands[i].equals("StackQueue")) {
                System.out.print("null ");
            }
        }
    }
}