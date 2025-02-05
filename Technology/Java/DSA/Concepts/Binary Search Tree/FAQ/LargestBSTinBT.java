/*
    Largest BST in Binary Tree
    Given a root of Binary Tree, where the nodes have integer values. Return the size of the largest subtree of the binary tree which is also a BST.

    A binary search tree (BST) is a binary tree data structure which has the following properties.
        The left subtree of a node contains only nodes with data less than the node’s data.
        The right subtree of a node contains only nodes with data greater than the node’s data.
        Both the left and right subtrees must also be binary search trees.

    Intuition
        A more efficient method to find the largest Binary Search Tree (BST) subtree within a binary tree involves traversing the tree and simultaneously verifying if each subtree is a BST. By adopting a bottom-up recursive approach, it’s possible to traverse the tree efficiently. For each node, the minimum value, maximum value, size of the BST, and whether it is a BST can be determined based on its children’s information. This approach allows for updating and maintaining the size of the largest BST subtree found during the traversal.

    Approach
        Define a NodeValue class to store the following information about each subtree:
            minNode: Minimum value of the subtree.
            maxNode: Maximum value of the subtree.
            maxSize: Maximum size of the BST encountered so far.
        Implement a helper function largestBSTSubtreeHelper that takes the root as input and recursively gathers information (minNode, maxNode, and maxSize) for each subtree.
            The NodeValue information for the current node is updated based on the left and right subtree properties. Specifically, the left subtree’s maximum node should be less than the current node and the right subtree’s minimum node should be greater than the current node.
            If the current subtree satisfies the BST property, update the size of the node (maxSize) as the sum of maxSize from the left subtree, maxSize from the right subtree, and 1.
            If the current subtree is not a BST, carry forward the current maxSize but set minNode to int min and maxNode to int max.
        Return the maxSize of the largest BST subtree found.

    Is a BST : if (left.maxNode < node.data && node.data < right.minNode)

    Complexity Analysis
        Time Complexity :O(N), where N is the number of nodes in the Binary tree as we traverse through all the nodes in the tree. The information update for each nodes takes constant time hence the overall time complexity is O(N) as the tree is traversed once.

        Space Complexity : O(N) , where N is number of nodes in the Binary Tree as for each node we store additional information using a struct class whose new object is initialised.
*/
/**
 * Definition for a binary tree node.
 */
public class TreeNode {
    int data;
    TreeNode left;
    TreeNode right;
    TreeNode(int val) {
        data = val;
        left = null;
        right = null;
    }
}

class LargestBSTinBT {
    // Helper class to store information about a subtree.
    class NodeValue {
        int minNode, maxNode, maxSize;
        NodeValue(int minNode, int maxNode, int maxSize) {
            this.minNode = minNode;
            this.maxNode = maxNode;
            this.maxSize = maxSize;
        }
    }

    // Helper function to recursively find the largest BST subtree.
    private NodeValue largestBSTSubtreeHelper(TreeNode node) {
        // Base case: if the node is null, return a default NodeValue.
        if (node == null) {
            return new NodeValue(Integer.MAX_VALUE, Integer.MIN_VALUE, 0);
        }

        // Recursively get values from the left and right subtrees.
        NodeValue left = largestBSTSubtreeHelper(node.left);
        NodeValue right = largestBSTSubtreeHelper(node.right);

        // Check if the current node is a valid BST node.
        if (left.maxNode < node.data && node.data < right.minNode) {
            // Current subtree is a valid BST.
            return new NodeValue(
                Math.min(node.data, left.minNode),
                Math.max(node.data, right.maxNode),
                left.maxSize + right.maxSize + 1
            );
        }

        // Current subtree is not a valid BST.
        return new NodeValue(Integer.MIN_VALUE, Integer.MAX_VALUE, Math.max(left.maxSize, right.maxSize));
    }

    public int largestBST(TreeNode root) {
        // Initialize the recursive process and return the size of the largest BST subtree.
        return largestBSTSubtreeHelper(root).maxSize;
    }

    // Main method to demonstrate usage
    public static void main(String[] args) {
        // Example binary tree
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);

        LargestBSTinBT sol = new LargestBSTinBT();
        System.out.println(sol.largestBST(root));  // Output: 3

        // Additional test case
        TreeNode root2 = new TreeNode(10);
        root2.left = new TreeNode(5);
        root2.right = new TreeNode(15);
        root2.left.left = new TreeNode(1);
        root2.left.right = new TreeNode(8);
        root2.right.right = new TreeNode(7);

        System.out.println(sol.largestBST(root2));  // Output: 3 (The subtree 5-1-8 is the largest BST)
    }
}
