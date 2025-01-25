/*
	Postorder Traversal
	
	Example : 
               1
             /   \
            2     3
                 /  \
                4    6
               /
              5

    Output : 2, 5, 4, 6, 3, 1
*/

import java.util.ArrayList;
import java.util.List;

// TreeNode structure for the binary tree
class TreeNode {
    int data;
    TreeNode left;
    TreeNode right;

    // Constructor to initialize the TreeNode with a value
    TreeNode(int val) {
        data = val;
        left = null;
        right = null;
    }
}

class PostorderTraversal {
    // Function to perform postorder traversal recursively
    private void recursivePostorder(TreeNode root, List<Integer> arr) {
        // Base case: if root is null, return
        if (root == null) {
            return;
        }
        // Traverse left subtree
        recursivePostorder(root.left, arr);
        // Traverse right subtree
        recursivePostorder(root.right, arr);
        // Visit the TreeNode (append TreeNode's data to the array)
        arr.add(root.data);
    }

    // Function to get the postorder traversal of a binary tree
    public List<Integer> postorder(TreeNode root) {
        // Create a list to store the traversal result
        List<Integer> arr = new ArrayList<>();
        // Perform postorder traversal starting from the root
        recursivePostorder(root, arr);
        // Return the postorder traversal result
        return arr;
    }
}

// Function to print the elements of a list
public class Main {
    static void printList(List<Integer> list) {
        // Iterate through the list and print each element
        for (int num : list) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // Creating a sample binary tree
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        PostorderTraversal sol = new PostorderTraversal();
        // Getting postorder traversal
        List<Integer> result = sol.postorder(root);

        // Printing the postorder traversal result
        System.out.print("Postorder traversal: ");
        printList(result);
    }
}
/*
    Complexity Analysis :
        Time Complexity: O(N) where N is the number of nodes in the binary tree, as each node of the binary tree is visited exactly once.

        Space Complexity: O(N) where N is the number of nodes in the binary tree, as an additional space for the array is allocated to store the values of all ‘N’ nodes of the binary tree.
*/