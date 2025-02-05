/*
	Intuition:
		Imagine you have a box (queue) that can only be accessed from one side. You want to use this box to simulate a stack, where the last item you put in is the first one you take out. This is like stacking plates: you put a plate on top and when you need a plate, you take the top one. Here's how we can achieve this with our box:

		Pushing Items: When you want to push an item onto the stack, you put it in the box (queue) and then move all the other items in the box (queue) to the back of the new item. This way, the new item is always at the front, simulating the top of the stack. For example, if the box currently has plates A, B, C, and you want to add D, you put D in the box and then rearrange so that D is at the front followed by A, B, C.

		Popping Items: To pop an item, you simply take out the item at the front of the box (queue). This is like taking the top plate off the stack. In our example, popping would remove D, leaving A, B, C in the box.

		Top Item: To see the top item without removing it, you look at the item at the front of the box (queue). In our example, peeking would show D.

		Checking if Stack is Empty: To check if the stack is empty, you just check if the box (queue) is empty.

	Approach:

		Data Structure Used: A single queue will be used to store the elements.
	
		Push(x): Insert the element x into the queue. Rearrange the elements in the queue to maintain the stack order by:
			
			Running a loop that iterates size() - 1 times, where size() is the current number of elements in the queue.
			
			In each iteration, remove the front element and add it back to the rear of the queue. This ensures that the most recently added element is always at the front of the queue.
	
		Pop(): Remove and return the front element of the queue, which corresponds to the top of the stack.
		
		isEmpty(): Return true if the queue is empty, and false otherwise.

	Complexity Analysis:
		Time Complexity:
			Push operation: O(n) (where n is the number of elements in the queue at that time) because every time an element is pushed, all the elements in the queue are popped from front and pushed in the back again.

			Pop operation: O(1) as constant operations are performed.

			Top operation: O(1) as constant operations are performed.

			IsEmpty operation: O(1) as constant operations are performed.

		Space Complexity: O(k) for storing k elements in the queue.
*/
import java.util.*;

// Stack implementation using Queue
class QueueStack {
    // Queue
    Queue<Integer> q = new LinkedList<>();

    // Method to push element in the stack
    public void push(int x) {
        // Get size
        int s = q.size();
        // Add element
        q.add(x);

        // Move elements before new element to back
        for (int i = 0; i < s; i++) {
            q.add(q.poll());
        }
    }

    // Method to pop element from stack
    public int pop() {
        // Get front element
        int n = q.peek();
        // Remove front element
        q.poll();
        // Return removed element
        return n;
    }

    // Method to return the top of stack
    public int top() {
        // Return front element
        return q.peek();
    }

    // Method to check if the stack is empty
    public boolean isEmpty() {
        return q.isEmpty();
    }
}

// ImplementStackUsingQueues class
class ImplementStackUsingQueues {
    public static void main(String[] args) {
        QueueStack st = new QueueStack();
        
        // Array of commands
        String[] commands = {"QueueStack", "push", "push", 
                             "pop", "top", "isEmpty"};
        int[][] inputs = {{}, {4}, {8}, {}, {}, {}};

        for (int i = 0; i < commands.length; ++i) {
            switch (commands[i]) {
                case "push":
                    st.push(inputs[i][0]);
                    System.out.print("null ");
                    break;
                case "pop":
                    System.out.print(st.pop() + " ");
                    break;
                case "top":
                    System.out.print(st.top() + " ");
                    break;
                case "isEmpty":
                    System.out.print(st.isEmpty() ? "true " : "false ");
                    break;
                case "QueueStack":
                    System.out.print("null ");
                    break;
            }
        }
    }
}