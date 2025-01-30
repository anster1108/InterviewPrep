/*
	Two sum in BST
		Given the root of a binary search tree and an integer k.Return true if there exist two elements in the BST such that their sum is equal to k otherwise false.

	Brute Force :
		public boolean twoSumBST(TreeNode root, int k) {
	        // Get sorted list of elements from BST
	        List <Integer> sorted_elements = inorderTraversal(root);
	        
	        // Initialize two pointers
	        int left = 0, right = sorted_elements.size() - 1;

	        // Use two pointers to find if there is a pair with sum k
	        while (left <right) {
	            int current_sum = sorted_elements.get(left) + sorted_elements.get(right);
	            if (current_sum == k) {
	                return true;
	            } else if (current_sum <k) {
	                left++;
	            } else {
	                right--;
	            }
	        }

	        return false;
	    }

	    // Helper function to perform inorder traversal and get sorted elements
	    private List <Integer> inorderTraversal(TreeNode node) {
	        List <Integer> elements = new ArrayList <> ();
	        inorderHelper(node, elements);
	        return elements;
	    }

	    // Recursive helper to fill elements during inorder traversal
	    private void inorderHelper(TreeNode node, List <Integer> elements) {
	        if (node == null) return;
	        inorderHelper(node.left, elements);
	        elements.add(node.data);
	        inorderHelper(node.right, elements);
	    }

	Time Complexity: O(N), The time complexity is linear because we are traversing the entire binary search tree once to get the sorted elements, and then we are using two pointers to find the pair that sums to k, which also takes linear time.

	Space Complexity: O(N), The space complexity is linear because we are storing the sorted elements in an array, which takes linear space.
*/
import java.util.Stack;

// Definition for a binary tree node.
class TreeNode {
    int data;
    TreeNode left, right;
    TreeNode(int val) {
        data = val;
        left = null;
        right = null;
    }
}

// BST Iterator to iterate in the inorder and reverse inorder manner
class BSTIterator {
    private Stack<TreeNode> stack;
    private boolean reverse;

    // Constructor to initialize the iterator
    public BSTIterator(TreeNode root, boolean isReverse) {
        stack = new Stack<>();
        reverse = isReverse;
        pushAll(root);
    }

    // Helper function to push all left or right nodes
    private void pushAll(TreeNode node) {
        while (node != null) {
            stack.push(node);
            node = (reverse) ? node.right : node.left;
        }
    }

    // Check if there are more elements in the BST
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    // Get the next element in the inorder or reverse inorder traversal
    public int next() {
        TreeNode node = stack.pop();
        if (!reverse) pushAll(node.right);
        else pushAll(node.left);
        return node.data;
    }
}

class Solution {
    public boolean twoSumBST(TreeNode root, int k) {
        if (root == null) return false;

        // Initialize two iterators
        BSTIterator l = new BSTIterator(root, false); // normal inorder
        BSTIterator r = new BSTIterator(root, true);  // reverse inorder

        int i = l.next();
        int j = r.next();

        while (i < j) {
            if (i + j == k) return true;
            else if (i + j < k) i = l.next();
            else j = r.next();
        }
        return false;
    }

    public static void main(String[] args) {
        // Create the tree
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.right.right = new TreeNode(7);

        // Create solution instance
        Solution solution = new Solution();
        int k = 9;
        
        // Check if there exist two elements in the BST such that their sum is equal to k
        boolean result = solution.twoSumBST(root, k);
        System.out.println(result ? "True" : "False");
    }
}
