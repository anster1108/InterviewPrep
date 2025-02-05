/*CheckBalancedBinaryTree
	Check for balanced binary tree
		Given a binary tree root, find if it is height-balanced or not.

		A tree is height-balanced if the difference between the heights of left and right subtrees is not more than one for all nodes of the tree. 

	Balance Binary Tree Formula :- Height(left side) - Height(right side) <= 1 

	Brute Force : 
		private int findHeight(TreeNode root){
			if(root == null){
				return 0;
			}

			int leftHeight = findHeight(root.left);
			int rightHeight = findHeight(root.right);
			return 1 + Math.max(leftHeight, rightHeight); 
		}

		public boolean isBalanced(TreeNode root) {
        	if(root == null){
				return true;
        	}

        	int leftHeight = getHeight(root.left);
        	int rightHeight = getHeight(root.right);
			
			if( Math.abs(leftHeight - rightHeight) <= 1 
				&& isBalanced(root.left) 
				&& isBalanced(root.right)
			){
				return true;
			}

        	return false;
		}

	Time Complexity: O(N^2) where N is the number of nodes in the Binary Tree. For each node in the Binary Tree, all other nodes are traversed to calculate its height, resulting in a nested traversal structure, leading to O(N) operations for each of the N nodes, hence O(N * N) = O(N^2).

	Space Complexity: O(1) as no additional data structures or memory is allocated.

*/
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int data;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int val) { data = val; left = null; right = null; }
 * }
 **/

class CheckBalancedBinaryTree {
    /**
     * Checks if the binary tree is balanced.
     * A binary tree is considered balanced if the height difference between
     * the left and right subtrees of every node is at most 1.
     * 
     * @param root The root node of the binary tree.
     * @return true if the tree is balanced, false otherwise.
     */
    public boolean isBalanced(TreeNode root) {
        // Call the recursive helper method to check balance status.
        // If the heightDifference() returns -1, the tree is unbalanced.
        return dfsHeight(root) != -1;
    }

    /**
     * Recursive method to calculate the height of the tree.
     * Returns -1 if the tree is unbalanced, otherwise returns the height of the tree.
     * 
     * @param root The current node of the tree.
     * @return The height of the tree if balanced, -1 if unbalanced.
     */
    private int dfsHeight(TreeNode root) {
        // Base case: If the current node is null, the height of an empty tree is 0.
        if (root == null) return 0;

        // Recursively calculate the height of the left subtree.
        int leftHeight = dfsHeight(root.left);
        // If the left subtree is unbalanced, propagate the unbalance status.
        if (leftHeight == -1) return -1;

        // Recursively calculate the height of the right subtree.
        int rightHeight = dfsHeight(root.right);
        // If the right subtree is unbalanced, propagate the unbalance status.
        if (rightHeight == -1) return -1;

        // Check if the difference in height between the left and right subtrees is greater than 1.
        // If the difference is greater, the tree is unbalanced.
        if (Math.abs(leftHeight - rightHeight) > 1) return -1;

        // Return the height of the tree rooted at the current node.
        return Math.max(leftHeight, rightHeight) + 1;
    }
}

// Main class for testing the CheckBalancedBinaryTree class
public class Main {
    public static void main(String[] args) {
        // Creating a sample binary tree
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.left.right.right = new TreeNode(6);
        root.left.right.right.right = new TreeNode(7);

        // Creating an instance of the CheckBalancedBinaryTree class
        CheckBalancedBinaryTree CheckBalancedBinaryTree = new CheckBalancedBinaryTree();

        // Checking if the tree is balanced
        if (CheckBalancedBinaryTree.isBalanced(root)) {
            System.out.println("The tree is balanced.");
        } else {
            System.out.println("The tree is not balanced.");
        }
    }
}
