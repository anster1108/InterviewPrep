/*
	Diameter of Binary Tree
		Given the root of a binary tree, return the length of the diameter of the tree.

		The diameter of a binary tree is the length of the longest path between any two nodes in the tree. It may or may not pass through the root.

	Diameter = Left Subtree Height + Right Subtree Height

	Brute Force :
		class DiameterOfBinaryTree {
		    int diameter;
		    int calculateHeight(TreeNode root){
		        if(root == null) return 0;

		        int leftHeight = calculateHeight(root.left);
		        int rightHeight = calculateHeight(root.right);

		        diameter = Math.max(diameter, leftHeight + rightHeight);

		        return Math.max(leftHeight, rightHeight) + 1;
		    }

		    public int diameterOfBinaryTree(TreeNode root) {
		        diameter = 0;
		        int height = calculateHeight(root);
		        return diameter;
		    }
		}

	Complexity Analysis
	Time Complexity: O(N^2) In this approach, for each node, we calculate the height of its left and right subtrees, which takes O(N) time. Since this calculation is done for each of the N nodes in the tree, the total time complexity is O(N * N) = O(N^2)

	Space Complexity: O(H) The space complexity is determined by the maximum depth of the recursion stack, which corresponds to the height of the tree, H. Thus, the space complexity is O(H).

*/
// Definition for a binary tree node.
  public class TreeNode {
      int data;
      TreeNode left;
      TreeNode right;
      TreeNode(int val) { data = val; left = null, right = null }
  }
 
class DiameterOfBinaryTree {
    // Function to find the diameter of a binary tree
    public int diameterOfBinaryTree(TreeNode root) {
        // Initialize the variable to store the diameter of the tree
        int[] diameter = new int[1];
        diameter[0] = 0;
        
        // Call the height function to traverse the tree and calculate diameter
        height(root, diameter);
        
        // Return the calculated diameter
        return diameter[0];
    }

    // Function to calculate the height of the tree and update the diameter
    private int height(TreeNode node, int[] diameter) {
        // Base case: If the node is null, return 0 indicating an empty tree height
        if (node == null) {
            return 0;
        }

        // Recursively calculate the height of left and right subtrees
        int[] lh = new int[1];
        int[] rh = new int[1];
        lh[0] = height(node.left, diameter);
        rh[0] = height(node.right, diameter);

        // Update the diameter with the maximum of current diameter 
        diameter[0] = Math.max(diameter[0], lh[0] + rh[0]);

        // Return the height of the current node's subtree
        return 1 + Math.max(lh[0], rh[0]);
    }
    
    // Main method to test the function
    public static void main(String[] args) {
        // Example usage: Create a tree and find its diameter
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        DiameterOfBinaryTree DiameterOfBinaryTree = new DiameterOfBinaryTree();
        int result = DiameterOfBinaryTree.diameterOfBinaryTree(root);
        System.out.println("Diameter of the binary tree is: " + result);
    }
}
