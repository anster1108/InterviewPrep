/*
	Correct BST with two nodes swapped
		Given the root of a binary search tree (BST), where the values of exactly two nodes of the tree were swapped by mistake.Recover the tree without changing its structure.

	Intution :
		If any 2 nodes are swapped then the inoder traversal will be affected,i.e, the traversal will not be sorted.
		So in that case we will take pointers where the previous node is greater than the current node, and will mark both the nodes.

		There can be two case of swaps
		1. Swap can be of adjacent nodes
		2. Swap can not be adjacent nodes

		for #1, we only have one voilation in the inorder traversal, one case where prev > current
		for #2, we will have two voilation in the traversal, then we will mark first(1st voilation where prev > current, prev node), middle(1st violation current node), last (2nd voilation where prev > current, current node)

	Time Complexity : O(N), traverses the binary tree once.

	Space Complexity : O(N), in the worst case, the function call stack can go up to the depth of the tree, which is N nodes in an unbalanced tree.
*/
/**
 * Definition for a binary tree node.
 */
public class TreeNode {
    int data;
    TreeNode left;
    TreeNode right;
    TreeNode(int val) { data = val; left = null; right = null; }
}

class CorrectBSTwithTwoNodesSwapped {
    private TreeNode first = null, middle = null, last = null, prev = null;

    public void recoverTree(TreeNode root) {
        inorder(root); // Perform inorder traversal to identify the misplaced nodes

        // Correct the BST by swapping the misplaced nodes
        if (first != null && last != null) {
            int temp = first.data;
            first.data = last.data;
            last.data = temp;
        } else if (first != null && middle != null) {
            int temp = first.data;
            first.data = middle.data;
            middle.data = temp;
        }
    }

    private void inorder(TreeNode node) {
        if (node == null) return;

        // Traverse the left subtree
        inorder(node.left);

        // Identify the nodes that are out of order
        if (prev != null && prev.data > node.data) {
            if (first == null) {
                first = prev;  // First out-of-order node
                middle = node; // Middle node in case nodes are adjacent
            } else {
                last = node;   // Last out-of-order node
            }
        }

        prev = node; // Update prev node to the current node

        // Traverse the right subtree
        inorder(node.right);
    }

    // Main method to demonstrate the CorrectBSTwithTwoNodesSwapped
    public static void main(String[] args) {
        // Example input tree: [1, 3, null, null, 2]
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(3);
        root.left.right = new TreeNode(2);

        // CorrectBSTwithTwoNodesSwapped instance
        CorrectBSTwithTwoNodesSwapped sol = new CorrectBSTwithTwoNodesSwapped();
        sol.recoverTree(root);

        // Helper function to print inorder traversal of the tree
        inorderPrint(root);
    }

    private static void inorderPrint(TreeNode root) {
        if (root != null) {
            inorderPrint(root.left);
            System.out.print(root.data + " ");
            inorderPrint(root.right);
        }
    }
}
