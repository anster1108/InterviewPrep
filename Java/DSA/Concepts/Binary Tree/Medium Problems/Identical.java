/*
	Check if two trees are identical or not

		Given the roots of two binary trees p and q, write a function to check if they are the same or not.

		Two binary trees are considered the same if they are structurally identical, and the nodes have the same value.

	Example : 
		 	   1					 	   1
             /   \						 /   \
            2     3						2     3
                 /  \						 /  \
                4    6						4    6
               /						   /
              5						      5

		Output : True

    Example :
    		   1					 	   1
             /   \						 /   \
            2     3						2     3
                 /  \						 /  \
                5    6						4    6
               /						   /
              4						      5
		
		Output : False

*/	
// Definition of a binary tree node
class TreeNode {
    int data;
    TreeNode left, right;

    TreeNode(int val) {
        this.data = val;
        this.left = null;
        this.right = null;
    }
}

class Identical {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        // If both nodes are null, the trees are the same
        if (p == null && q == null) {
            return true;
        }

        // If one of the nodes is null, the trees are not the same
        if (p == null || q == null) {
            return false;
        }

        // If the values of the nodes are different, the trees are not the same
        if (p.data != q.data) {
            return false;
        }

        // Recursively check the left and right subtrees
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

    public static void main(String[] args) {
        // Example usage
        Identical Identical = new Identical();

        // Creating two sample trees
        TreeNode tree1 = new TreeNode(1);
        tree1.left = new TreeNode(2);
        tree1.right = new TreeNode(3);

        TreeNode tree2 = new TreeNode(1);
        tree2.left = new TreeNode(2);
        tree2.right = new TreeNode(3);

        // Checking if the trees are identical
        boolean result = Identical.isSameTree(tree1, tree2);
        System.out.println("Are the trees identical? " + result);  // Output: true
    }
}
/*
Complexity Analysis
Time Complexity: O(N) Visit each node exactly once during the traversal, where N is the number of nodes in the tree.

Space Complexity: O(h) The space complexity is determined by the recursion stack, which can go as deep as the height of the tree h.
*/
