/*
	Inorder successor and predecessor in BST
		Given the root node of a binary search tree (BST) and an integer key. Return the Inorder predecessor and successor of the given key from the provided BST.
		If predecessor or successor is missing then return -1.

	Brute Force:
	    List<Integer> succPredBST(TreeNode root, int key) {
	        List<Integer> sortedList = new ArrayList<>();
	        // Perform in-order traversal to get the sorted list of node values
	        inorderTraversal(root, sortedList);
	        
	        int predecessor = -1;
	        int successor = -1;
	        
	        // Find the predecessor and successor in the sorted list
	        for (int i = 0; i < sortedList.size(); i++) {
	            if (sortedList.get(i) < key) {
	                // Update predecessor if the current value is less than the key
	                predecessor = sortedList.get(i);
	            } else if (sortedList.get(i) > key) {
	                // Update successor if the current value is greater than the key
	                successor = sortedList.get(i);
	                break;  // No need to continue once successor is found
	            }
	        }
	        
	        List<Integer> result = new ArrayList<>();
	        result.add(predecessor);
	        result.add(successor);
	        return result;
	    }

	    // Helper function to perform in-order traversal
	    private void inorderTraversal(TreeNode node, List<Integer> sortedList) {
	        if (node == null) {
	            return;
	        }
	        // Traverse the left subtree
	        inorderTraversal(node.left, sortedList);
	        // Add the node's value to the sortedList
	        sortedList.add(node.data);
	        // Traverse the right subtree
	        inorderTraversal(node.right, sortedList);
	    }
	
	Time Complexity : O(N), where N is the number of nodes in the binary search tree. The inorder traversal visits each node once, and the subsequent for loop also iterates over the nodes.

	Space Complexity : O(N), where N is the number of nodes in the binary search tree. The sortedList array stores all the node values, resulting in a linear space complexity.
*/
class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode(int val) {
        this.val = val;
        left = right = null;
    }
}

public class SuccessorAndPredecessor {
    
    // Method to find the inorder predecessor
    public TreeNode findPredecessor(TreeNode root, TreeNode node) {
        TreeNode predecessor = null;

        while (root != null) {
            if (node.val > root.val) {
                // Move to the right subtree and update predecessor
                predecessor = root;
                root = root.right;
            } else {
                // Move to the left subtree
                root = root.left;
            }
        }
        return predecessor;
    }

    // Method to find the inorder successor
    public TreeNode findSuccessor(TreeNode root, TreeNode node) {
        TreeNode successor = null;

        while (root != null) {
            if (node.val < root.val) {
                // Move to the left subtree and update successor
                successor = root;
                root = root.left;
            } else {
                // Move to the right subtree
                root = root.right;
            }
        }
        return successor;
    }

    public static void main(String[] args) {
        // Construct the BST
        TreeNode root = new TreeNode(20);
        root.left = new TreeNode(10);
        root.right = new TreeNode(30);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(15);
        root.right.left = new TreeNode(25);
        root.right.right = new TreeNode(35);

        SuccessorAndPredecessor solution = new SuccessorAndPredecessor();
        TreeNode node = root.left; // Node with value 10

        TreeNode predecessor = solution.findPredecessor(root, node);
        TreeNode successor = solution.findSuccessor(root, node);

        System.out.println("Node: " + node.val);
        System.out.println("Inorder Predecessor: " + (predecessor != null ? predecessor.val : "None"));
        System.out.println("Inorder Successor: " + (successor != null ? successor.val : "None"));
    }
}
