/*
	Preorder Traversal
		Travel Node then travel the left side of the tree and once done we move the right side of it

    Example : 
               1
             /   \
            2     3
                 /  \
                4    6
               /
              5

    Output : 1, 2, 3, 4, 5, 6

	Iterative Solution : We use a stack here, LIFO structure, will submit right first and then left, so that left side goes first.

		public List<Integer> preorder(TreeNode root) {
	        List<Integer> ans = new ArrayList<>();
	        if (root == null) {
            	return;
        	}

			Stack<TreeNode> st = new Stack<>();
			st.push(root)
			if(!st.isEmpty()){
				root = st.pop();

				ans.add(root.data);

				if (root.right == null) {
					st.push(root.right);
				}
	
				if (root.left == null) {
					st.push(root.left);
				}
			}

	        return ans;
	    }

*/
import java.util.ArrayList;
import java.util.List;

// Definition for a binary tree node
public class TreeNode {
    int data;
    TreeNode left;
    TreeNode right;

    // Constructor to initialize a node with a value
    TreeNode(int val) {
        this.data = val;
        this.left = null;
        this.right = null;
    }
}

class PreorderTraversal {
    // Helper function to perform preorder traversal
    private void func(TreeNode node, List<Integer> ans) {
        // If the current node is null, return (base case for recursion)
        if (node == null) {
            return;
        }

        // Append the current node's value to the list
        ans.add(node.data);
        // Recursively traverse the left subtree
        func(node.left, ans);
        // Recursively traverse the right subtree
        func(node.right, ans);
    }

    // Function to initiate preorder traversal and return the resulting list
    public List<Integer> preorder(TreeNode root) {
        // Create an empty list to store preorder traversal values
        List<Integer> ans = new ArrayList<>();
        // Call the helper function with the root node and the list
        func(root, ans);
        // Return the resulting list containing preorder traversal values
        return ans;
    }

    // Main method to test the preorder traversal
    public static void main(String[] args) {
        // Creating a sample binary tree
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        // Create an instance of the PreorderTraversal class
        PreorderTraversal PreorderTraversal = new PreorderTraversal();
        // Getting preorder traversal
        List<Integer> result = PreorderTraversal.preorder(root);

        // Displaying the preorder traversal result
        System.out.print("Preorder Traversal: ");
        for (int val : result) {
            System.out.print(val + " ");
        }
        System.out.println();
    }
}
