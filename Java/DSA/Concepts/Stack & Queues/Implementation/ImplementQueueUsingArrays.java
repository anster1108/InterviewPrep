/*
	Intuition :
		Imagine you're managing a ticket counter at a busy theater. You have a limited number of tickets to sell, and you want to ensure the process is efficient and fair. To do this, you use a special system to keep track of which tickets have been sold and which are available, without having to rearrange them constantly. This system operates like a circular queue.

		The Ticket Counter (Queue): You have a counter with a fixed number of ticket slots, say 5 slots, arranged in a circle. Each slot can hold one ticket.

		Selling a Ticket (Enqueue Operation): When a customer arrives to buy a ticket, you place the ticket in the next available slot. Keep track of the position where the next ticket should be placed using a variable called rear. For example, if you have sold tickets to 3 customers, your counter might look like this: [T1, T2, T3, _, _], where T1, T2, and T3 represent sold tickets, and the next ticket will be placed in the fourth slot.

		Customer Leaving with a Ticket (Dequeue Operation): When a customer takes a ticket, you remove it from the slot at the front of the queue. Instead of shifting all the tickets forward, you just move the front pointer to the next slot. Continuing with our example, if the first customer takes their ticket, your counter now looks like this: [_, T2, T3, _, _], with the front pointing to the second slot.

		Handling Wrap-Around (Circular Array): When the rear or front reaches the end of the array, it wraps around to the beginning. This ensures that you make efficient use of the available slots without needing to shift tickets around. If you sell more tickets and the rear reaches the end, it wraps around like this: [T4, T5, T3, _, T1] with the rear and front properly adjusted using modular arithmetic.

		Checking Availability (IsEmpty and IsFull Operations): You need to check if there are any tickets left or if your counter is full. These checks ensure you manage the tickets efficiently.

	Approach :

		Declare an Array of a Particular Size: Declare an array to store the elements of the queue. The size of this array is determined when the queue is initialized.
		
		Define Variables:
			start: Tracks the index of the front element.
			
			end: Tracks the index of the last element.
			
			size: Keeps the current number of elements in the queue.
			
			capacity: The maximum number of elements the queue can hold.
			
			Push Operation (push(int x)): Check if the queue is full by comparing size and capacity. If not full, increment the rear using modular arithmetic to wrap around if necessary, then insert the element at the rear index. Increment the size.
			
			Pop Operation (pop()): Check if the queue is empty by comparing the size with 0. If not empty, return the element at the front index, then increment the front using modular arithmetic to wrap around if necessary. Decrement the size.
			
			Peek Operation (peek()): Check if the queue is empty. If not empty, return the element at the front index.
			
			IsEmpty Operation (isEmpty()): Check if the size is 0 to determine if the queue is empty.

	Complexity Analysis:
		Time Complexity: O(1) as all individual queue operations are taking constant time.

		Space Complexity: O(1) as the implementation uses a fixed size array.
*/
import java.util.*;

// Class implementing Queue using Arrays
class ImplementQueueUsingArrays {
    // Array to store queue elements
    int[] arr;
    // Indices for start and end of the queue
    int start, end;
    // Current size and maximum size of the queue
    int currSize, maxSize;

    // Constructor
    public ImplementQueueUsingArrays() {
        arr = new int[10];
        start = -1;
        end = -1;
        currSize = 0;
        maxSize = 10;
    }

    // Method to push an element into the queue
    public void push(int x) {
        // Check if the queue is full
        if (currSize == maxSize) {
            System.out.println("Queue is full\nExiting...");
            System.exit(1);
        }

        // If the queue is empty, initialize start and end
        if (end == -1) {
            start = 0;
            end = 0;
        } 
        else {
            // Circular increment of end
            end = (end + 1) % maxSize;
        }

        arr[end] = x;
        currSize++;
    }

    // Method to pop an element from the queue
    public int pop() {
        // Check if the queue is empty
        if (start == -1) {
            System.out.println("Queue Empty\nExiting...");
            System.exit(1);
        }
        int popped = arr[start];

        // If the queue has only one element, reset start and end
        if (currSize == 1) {
            start = -1;
            end = -1;
        } 
        else {
            // Circular increment of start
            start = (start + 1) % maxSize;
        }

        currSize--;
        return popped;
    }

    // Method to get the front element of the queue
    public int peek() {
        // Check if the queue is empty
        if (start == -1) {
            System.out.println("Queue is Empty");
            System.exit(1);
        }
        return arr[start];
    }

    // Method to determine whether the queue is empty
    public boolean isEmpty() {
        return (currSize == 0);
    }
}

class Main {
    public static void main(String[] args) {
        ImplementQueueUsingArrays queue = new ImplementQueueUsingArrays();

        String[] commands = {"ImplementQueueUsingArrays", "push", "push", 
                             "peek", "pop", "isEmpty"};
        int[][] inputs = {{}, {5}, {10}, {}, {}, {}};

        for (int i = 0; i < commands.length; ++i) {
            switch (commands[i]) {
                case "push":
                    queue.push(inputs[i][0]);
                    System.out.print("null ");
                    break;
                case "pop":
                    System.out.print(queue.pop() + " ");
                    break;
                case "peek":
                    System.out.print(queue.peek() + " ");
                    break;
                case "isEmpty":
                    System.out.print(queue.isEmpty() ? "true " : "false ");
                    break;
                case "ImplementQueueUsingArrays":
                    System.out.print("null ");
                    break;
            }
        }
    }
}