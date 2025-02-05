/*
	Kth Smallest and Largest element in BST
		Given the root node of a binary search tree (BST) and an integer k.
		Return the kth smallest and largest value (1-indexed) of all values of the nodes in the tree.

	Brute Force :
		import java.util.ArrayList;
		import java.util.Collections;
		import java.util.List;

		// Definition for a binary tree node.
		public class TreeNode {
		     int data;
		     TreeNode left;
		     TreeNode right;
		     TreeNode(int val) { data = val; left = null; right = null; }
		}

		class KthSmallestAndLargest {
		    // Helper function to perform an in-order traversal of the BST
		    private void inorderTraversal(TreeNode node, List<Integer> values) {
		        if (node != null) {
		            inorderTraversal(node.left, values);
		            values.add(node.data);
		            inorderTraversal(node.right, values);
		        }
		    }

		    public List<Integer> kLargesSmall(TreeNode root, int k) {
		        // List to store the node values
		        List<Integer> values = new ArrayList<>();
		        // Perform in-order traversal and collect values
		        inorderTraversal(root, values);
		        
		        // Sort the values
		        Collections.sort(values);
		        
		        // Find the kth smallest and kth largest values
		        int kth_smallest = values.get(k - 1);
		        int kth_largest = values.get(values.size() - k);
		        
		        List<Integer> result = new ArrayList<>();
		        result.add(kth_smallest);
		        result.add(kth_largest);
		        
		        return result;
		    }

		    // Main method to demonstrate the function
		    public static void main(String[] args) {
		        // Constructing the tree: [3, 1, 4, null, 2]
		        TreeNode root = new TreeNode(3);
		        root.left = new TreeNode(1);
		        root.left.right = new TreeNode(2);
		        root.right = new TreeNode(4);
		        
		        KthSmallestAndLargest KthSmallestAndLargest = new KthSmallestAndLargest();
		        int k = 1;
		        List<Integer> result = KthSmallestAndLargest.kLargesSmall(root, k);
		        
		        System.out.println(result); // Output: [1, 4]
		    }
		}

	Time Complexity O(N log N), since the code performs an in-order traversal of the BST (O(N)) and then sorts the values (O(N log N)).

	Space Complexity O(N), since the code stores all the node values in a list, where N is the number of nodes in the BST.
*/
import java.util.ArrayList;
import java.util.List;

// Definition for a binary tree node.
 public class TreeNode {
     int data;
     TreeNode left;
     TreeNode right;
     TreeNode(int val) { data = val; left = null; right = null; }
 }

class KthSmallestAndLargest {
    private int k;
    private int result;

    // Function to find the kth smallest element
    public int kthSmallest(TreeNode root, int k) {
        this.k = k;
        this.result = -1;
        inorder(root);
        return result;
    }

    // Helper function for inorder traversal
    private void inorder(TreeNode node) {
        if (node != null) {
            inorder(node.left);
            if (--k == 0) {
                result = node.data;
                return;
            }
            inorder(node.right);
        }
    }

    // Function to find the kth largest element
    public int kthLargest(TreeNode root, int k) {
        this.k = k;
        this.result = -1;
        reverseInorder(root);
        return result;
    }

    // Helper function for reverse inorder traversal
    private void reverseInorder(TreeNode node) {
        if (node != null) {
            reverseInorder(node.right);
            if (--k == 0) {
                result = node.data;
                return;
            }
            reverseInorder(node.left);
        }
    }

    // Function to return kth smallest and kth largest elements
    public List<Integer> kLargesSmall(TreeNode root, int k) {
        List<Integer> result = new ArrayList<>();
        result.add(kthSmallest(root, k));
        result.add(kthLargest(root, k));
        return result;
    }

    // Main method to demonstrate the function
    public static void main(String[] args) {
        // Constructing the tree: [3, 1, 4, null, 2]
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(1);
        root.left.right = new TreeNode(2);
        root.right = new TreeNode(4);

        KthSmallestAndLargest KthSmallestAndLargest = new KthSmallestAndLargest();
        int k = 1;
        List<Integer> result = KthSmallestAndLargest.kLargesSmall(root, k);

        // Output the result
        System.out.println(result); // Output: [1, 4]
    }
}
