/*
	Inorder Traversal
		Given root of binary tree, return the Inorder traversal of the binary tree.
		=> go to the leftest chiild node and add it into the list and then backtrack and save parent node and then move to right node of the parent and do the same steps

    Example : 
               1
             /   \
            2     3
                 /  \
                4    6
               /
              5

    Output : 2, 1, 5, 4, 3, 6

	Iterative Format :
		public List<Integer> inorder(TreeNode root) {
	        // Create an empty vector to store inorder traversal values
	        List<Integer> arr = new ArrayList<>();
	        Stack<TreeNode> st = new Stack<>();
	        TreeNode node = root;
	        while(true){
	        	if(node != null){
	        		st.push(node);
	        		node = node.left;
	        	}else{
	        		if (st.isEmpty()) {
	                    break;
	                }
	        		node = st.pop();
	        		ans.add(node.data);
	        		node = node.right;
	        	}
	        }
	        
	        return arr;
	    }
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

class InorderTraversal {
    private void recursiveInorder(TreeNode root, List<Integer> arr) {
        // If the current Tree is NULL (base case for recursion), return
        if (root == null) {
            return;
        }
        // Recursively traverse the left subtree
        recursiveInorder(root.left, arr);
        // Push the current TreeNode's value into the vector
        arr.add(root.data);
        // Recursively traverse the right subtree
        recursiveInorder(root.right, arr);
    }

    // Function to initiate inorder traversal and return the resulting vector
    public List<Integer> inorder(TreeNode root) {
        // Create an empty vector to store inorder traversal values
        List<Integer> arr = new ArrayList<>();
        // Call the inorder traversal function
        recursiveInorder(root, arr);
        // Return the resulting vector containing inorder traversal values
        return arr;
    }

    public static void main(String[] args) {
        // Creating a sample binary tree
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        InorderTraversal sol = new InorderTraversal();
        // Getting inorder traversal
        List<Integer> result = sol.inorder(root);

        // Displaying the inorder traversal result
        System.out.print("Inorder Traversal: ");
        // Output each value in the inorder traversal result
        for (int val : result) {
            System.out.print(val + " ");
        }
        System.out.println();
    }
}
/*
    Complexity Analysis :
        Time Complexity: O(N) where N is the number of nodes in the binary tree, as each node of the binary tree is visited exactly once.

        Space Complexity: O(N) where N is the number of nodes in the binary tree, as an additional space for the array is allocated to store the values of all ‘N’ nodes of the binary tree.
*/