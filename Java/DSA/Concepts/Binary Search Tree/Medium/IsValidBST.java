/*
	Check if a tree is a BST or not
		Given the root node of a binary tree. Return true if the given binary tree is a binary search tree(BST) else false.
		A valid BST is defined as follows:
			The left subtree of a node contains only nodes with key strictly less than the node's key.
			The right subtree of a node contains only nodes with key strictly greater than the node's key.
			Both the left and right subtrees must also be binary search trees.
*/
import java.util.*;
// Definition for a binary tree node.
public class TreeNode {
  int data;
  TreeNode left;
  TreeNode right;
  TreeNode(int val) { data = val; left = null; right = null; }
}
 

class IsValidBST {
    public boolean isBST(TreeNode root) {
        // Helper function to validate the BST
        return validate(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
    
    private boolean validate(TreeNode node, long min, long max) {
        // Base case: if the node is null, return true
        if (node == null) return true;
        
        // Check if the node's value falls within the valid range
        if (node.data <= min || node.data >= max) return false;
        
        // Recursively validate the left subtree
        // Update the max value to the current node's value
        boolean leftIsValid = validate(node.left, min, node.data);
        
        // Recursively validate the right subtree
        // Update the min value to the current node's value
        boolean rightIsValid = validate(node.right, node.data, max);
        
        // Both subtrees must be valid for the tree to be a BST
        return leftIsValid && rightIsValid;
    }

    // Main method for testing
    public static void main(String[] args) {
        TreeNode root = new TreeNode(7);
        root.left = new TreeNode(5);
        root.right = new TreeNode(10);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(6);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(15);
        
        IsValidBST IsValidBST = new IsValidBST();
        System.out.println(IsValidBST.isBST(root)); // Output: false
    }
}
