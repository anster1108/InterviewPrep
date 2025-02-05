/*
	Search in BST
*/
// Definition for a binary tree node.
public class TreeNode {
      int data;
      TreeNode left;
      TreeNode right;
      TreeNode(int val) { data = val; left = null; right = null; }
  }
 

class Search {
    public TreeNode searchBST(TreeNode root, int val) {
        // Traverse the tree until we find the node 
       // with the given value or reach the end
        while (root != null && root.data != val) {
            // Move to the left or right child 
            // depending on the value comparison
            root = (root.data > val) ? root.left : root.right;
        }
       // Return the found node or null if not found
        return root; 
    }

    // Example usage
    public static void main(String[] args) {
        // Creating a simple BST for demonstration
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);

        Search sol = new Search();
        TreeNode result = sol.searchBST(root, 2);
        if (result != null) {
            System.out.println("Node found with value: " + result.data);
        } else {
            System.out.println("Node not found");
        }
    }
}
