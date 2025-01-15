/*
    Intuition
        Imagine you're working in a library, and there's a special shelf dedicated to books that are being frequently accessed. This shelf operates on a Last-In-First-Out (LIFO) principle, meaning the last book you put on the shelf is the first one you'll take off. This shelf can be thought of as a stack, and the following operations will help manage the books on this shelf.

        Push Operation (push(int x)): Think of adding a book to the top of the stack. Every time a new book arrives, you place it on the topmost spot available on the shelf. For instance, if the current stack of books is [Book1, Book2], and Book3 arrives, you place Book3 on top. The stack now looks like [Book1, Book2, Book3].

        Pop Operation (pop()): This operation is like removing the topmost book from the stack. The book that was last added (the one on the top) is the one you take off the shelf. Continuing with our example, if you perform a pop() operation, you remove Book3 from the stack. The stack now looks like [Book1, Book2].

        Top Operation (top()): Sometimes you just want to know which book is on top without removing it. The top() operation allows you to peek at the topmost book. If your stack is [Book1, Book2, Book3], calling top() will tell you that Book3 is on the top without removing it from the stack.

        IsEmpty Operation (isEmpty()): Before adding or removing books, you might want to check if the shelf is empty. The isEmpty() operation checks whether there are any books on the shelf. If there are no books, it returns true; otherwise, it returns false.

    Approach
        Declare an Array of Particular Size:
            We need to initialize an array that will hold the elements of the stack. The size of the array is defined when the stack is created.

        Define a Variable “Top” and Initialize It as -1:
            The top variable keeps track of the index of the last added element in the stack. Initializing it to -1 indicates that the stack is empty.

        Push Operation (push(int x)):
            To push an element onto the stack, we increment the top index by one and insert the element at this position in the array. If the stack is full (i.e., top is equal to the last index of the array), we throw a stack overflow exception.

        Pop Operation (pop()):
            To pop an element from the stack, we check if the stack is not empty by ensuring top is not equal to -1. If the stack is empty, we throw a stack underflow exception. If the stack is not empty, we return the element at the top index and then decrement the top index by one.

        Top Operation (top()):
            To get the top element without removing it, we check if the stack is not empty. If the stack is empty, we throw an exception. If the stack is not empty, we return the element at the top index.

        IsEmpty Operation (isEmpty()):
            To check if the stack is empty, we simply check if the top index is -1.

        Size Operation (size()):
            To get the current size of the stack, we return top + 1.

    Complexity Analysis
        Time Complexity: O(1) because the individual stack operations take O(1).

        Space Complexity: O(N) for using a stack which is equivalent to the size of the array.
*/

import java.util.*;

class ImplementStackUsingArrays {
    // Array to hold elements
    private int[] stackArray;
    // Maximum capacity
    private int capacity;
    // Index of top element
    private int topIndex;

    // Constructor
    public ImplementStackUsingArrays(int size) {
        capacity = size;
        stackArray = new int[capacity];
        // Initialize stack as empty
        topIndex = -1;
    }

    public ImplementStackUsingArrays() {
        this(1000);
    }

    // Pushes element x 
    public void push(int x) {
        if (topIndex >= capacity - 1) {
            System.out.println("Stack overflow");
            return;
        }
        stackArray[++topIndex] = x;
    }

    // Removes and returns top element
    public int pop() {
        if (isEmpty()) {
            System.out.println("Stack is empty");
            // Return invalid value
            return -1;
        }
        return stackArray[topIndex--];
    }

    // Returns top element
    public int top() {
        if (isEmpty()) {
            System.out.println("Stack is empty");
            return -1;
        }
        return stackArray[topIndex];
    }

    /* Returns true if the 
       stack is empty, false otherwise */
    public boolean isEmpty() {
        return topIndex == -1;
    }

    // Main function
    public static void main(String[] args) {
        ImplementStackUsingArrays stack = new ImplementStackUsingArrays();
        List<String> commands = Arrays.asList("ImplementStackUsingArrays", "push", "push", "top", "pop", "isEmpty");
        List<List<Integer>> inputs = Arrays.asList(Arrays.asList(), Arrays.asList(5), Arrays.asList(10), Arrays.asList(), Arrays.asList(), Arrays.asList());

        for (int i = 0; i < commands.size(); ++i) {
            switch (commands.get(i)) {
                case "push":
                    stack.push(inputs.get(i).get(0));
                    System.out.print("null ");
                    break;
                case "pop":
                    System.out.print(stack.pop() + " ");
                    break;
                case "top":
                    System.out.print(stack.top() + " ");
                    break;
                case "isEmpty":
                    System.out.print((stack.isEmpty() ? "true" : "false") + " ");
                    break;
                case "ImplementStackUsingArrays":
                    System.out.print("null ");
                    break;
            }
        }
    }
}
