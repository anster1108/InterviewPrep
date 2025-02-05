/*
	Check for symmetrical BTs
		Given the root of a binary tree, check whether it is a mirror of itself (i.e., symmetric around its center).

	Complexity Analysis
		Time complexity: O(N) This is because there are N number of nodes in the binary tree each node is traversed once to check for symmetry.

		Space complexity : O(h) This is because the maximum depth of the recursion stack is equal to the height of the tree.
*/
class TreeNode {
    int data;
    TreeNode left;
    TreeNode right;
    TreeNode(int val) {
        this.data = val;
        this.left = null;
        this.right = null;
    }
}

class SymmetricalTree {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true; // An empty tree is symmetric
        }
        return symmetry(root.left, root.right);
    }

    private boolean symmetry(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true; // Both nodes are null, so symmetric
        }

        if (left == null || right == null) {
            return false; // One of the nodes is null, so not symmetric
        }

        if (left.data != right.data) {
            return false; // The values of the nodes do not match, so not symmetric
        }

        // Recursively check the children of the nodes
        return symmetry(left.left, right.right) && symmetry(left.right, right.left);
    }

    public static void main(String[] args) {
        SymmetricalTree SymmetricalTree = new SymmetricalTree();

        // Create a sample tree: 1, 2, 2, 3, 4, 4, 3
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(3);

        // Test the symmetric tree
        System.out.println(SymmetricalTree.isSymmetric(root)); // Output: true
    }
}
