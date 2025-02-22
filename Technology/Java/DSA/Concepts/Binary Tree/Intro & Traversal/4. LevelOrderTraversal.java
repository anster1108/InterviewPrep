/*
	LevelOrderTraversal
		Example :

                1
             /     \
            2       3
          /  \     / 
         4     5  6

        Output : 1
        		 2, 3
        		 4, 5, 6
               
*/
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int data;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int val) { data = val; left = null; right = null; }
 * }
 **/

class TreeNode {
    int data;
    TreeNode left;
    TreeNode right;
    TreeNode(int val) { data = val; left = null; right = null; }
}

class LevelOrderTraversal {
    // Function to perform level-order traversal of a binary tree
    public List<List<Integer>> levelOrder(TreeNode root) {
        // Create a list to store the levels
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) {
            // If the tree is empty, return an empty list
            return ans;
        }
        
        // Create a queue to store nodes for level-order traversal
        Queue<TreeNode> q = new LinkedList<>();
        // Add the root node to the queue
        q.add(root);
        
        while (!q.isEmpty()) {
            // Get the size of the current level
            int size = q.size();
            // Create a list to store nodes at the current level
            List<Integer> level = new ArrayList<>();
            
            for (int i = 0; i < size; i++) {
                // Get the front node from the queue
                TreeNode node = q.poll();
                // Add the node value to the current level list
                level.add(node.data);
                
                // Enqueue the child nodes if they exist
                if (node.left != null) {
                    q.add(node.left);
                }
                if (node.right != null) {
                    q.add(node.right);
                }
            }
            // Add the current level to the answer list
            ans.add(level);
        }
        // Return the level-order traversal of the tree
        return ans;
    }
    
    // Main method to test the level-order traversal
    public static void main(String[] args) {
        // Creating a sample binary tree
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        
        // Create an instance of the LevelOrderTraversal class
        LevelOrderTraversal LevelOrderTraversal = new LevelOrderTraversal();
        // Perform level-order traversal
        List<List<Integer>> result = LevelOrderTraversal.levelOrder(root);
        
        // Printing the level-order traversal result
        System.out.println("Level Order Traversal of Tree:");
        for (List<Integer> level : result) {
            System.out.println(level);
        }
    }
}
/*
    Complexity Analysis :
        Time Complexity: O(N) where N is the number of nodes in the binary tree. Each node of the binary tree is enqueued and dequeued exactly once, hence all nodes need to be processed and visited. Processing each node takes constant time operations which contributes to the overall linear time complexity.

        Space Complexity: O(N) where N is the number of nodes in the binary tree. In the worst case, the queue has to hold all the nodes of the last level of the binary tree; the last level could at most hold N/2 nodes, hence the space complexity of the queue is proportional to O(N). The resultant vector answer also stores the values of the nodes level by level and hence contains all the nodes of the tree contributing to O(N) space as well.
*/