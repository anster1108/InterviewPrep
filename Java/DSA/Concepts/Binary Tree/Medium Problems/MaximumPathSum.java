/*
	Maximum path sum
		In a binary tree, a path is a list of nodes where there is an edge between every pair of neighbouring nodes. A node may only make a single appearance in the sequence. The total of each node's values along a path is its path sum. Return the largest path sum of all non-empty paths given the root of a binary tree.

		Note: The path does not have to go via the root.
*/
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int data;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int val) { data = val; left = null, right = null; }
 * }
 **/

class MaximumPathSum {
	int maxi;

    /* Recursive function to find the maximum path sum
     for a given subtree rooted at 'root'
     The variable 'maxi' is a reference parameter
     updated to store the maximum path sum encountered */
    int findMaxPathSum(TreeNode root, int max) {
        // Base case: If the current node is null, return 0
        if (root == null) {
            return 0;
        }

        // Calculate the maximum path sum
        // for the left and right subtrees
        int leftMaxPath = Math.max(0, findMaxPathSum(root.left, max));
        int rightMaxPath = Math.max(0, findMaxPathSum(root.right, max));

        // Update the overall maximum
        // path sum including the current node
        maxi = Math.max(maxi, leftMaxPath + rightMaxPath + root.data);

        /* Return the maximum sum considering
        only one branch (either left or right)
        along with the current node */
        return Math.max(leftMaxPath, rightMaxPath) + root.data;
    }

    // Function to find the maximum
    // path sum for the entire binary tree
    public int maxPathSum(TreeNode root) {
        // Initialize maxi to the
        // minimum possible integer value
        maxi = Integer.MIN_VALUE;

        // Call the recursive function to
        // find the maximum path sum
        findMaxPathSum(root, maxi);

        // Return the final maximum path sum
        return maxi;
    }

    public static void main(String[] args) {
        // Creating a sample binary tree
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.left.right.right = new TreeNode(6);
        root.left.right.right.right = new TreeNode(7);

        // Creating an instance of the MaximumPathSum class
        MaximumPathSum MaximumPathSum = new MaximumPathSum();

        // Finding and printing the maximum path sum
        int maxPathSum = MaximumPathSum.maxPathSum(root);
        System.out.println("Maximum Path Sum: " + maxPathSum);
    }
}
