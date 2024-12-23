/*
	Linked List Traversal : Given the head of a singly Linked List. Traverse the entire Linked List and return its elements in an array in the order of their appearance.
*/

import java.io.*;

class ListNode {
    int val; 
    ListNode next; 
    ListNode(int data1) {
        val = data1;
        next = null;
    }

    ListNode(int data1, ListNode next1) {
        val = data1;
        next = next1;
    }
}


class Traversal {
     //Function for Linked List Traversal
    public List<Integer> LLTraversal(ListNode head) {
        //Storing a copy of the linked list
        ListNode temp = head;
        //To store the values sequentially
        List<Integer> ans = new ArrayList<>();
        
        //Keep traversing
        //Until null is encountered
        while (temp != null) {
            //Storing the values
            ans.add(temp.val);
            //Storing the address of the next node
            temp = temp.next;
        }
        //Return answer
        return ans;
    }
}

public class Main {
    public static void main(String[] args) {
        //Manual creation of nodes
        ListNode y1 = new ListNode(2);
        ListNode y2 = new ListNode(5);
        ListNode y3 = new ListNode(8);
        ListNode y4 = new ListNode(7);

        // Linking the nodes
        y1.next = y2;
        y2.next = y3;
        y3.next = y4;

        // Creating an instance of Traversal class
        Traversal Traversal = new Traversal();

        // Calling LLTraversal method 
        //To get the values
        List<Integer> result = Traversal.LLTraversal(y1);

        // Printing the result
        System.out.println("Linked List Values:");
        for (int val : result) {
            System.out.print(val + " ");
        }
        System.out.println();
    }
}
