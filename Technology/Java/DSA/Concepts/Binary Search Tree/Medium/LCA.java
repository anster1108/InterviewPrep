/*
    LCA in BST
        Given the root node of a binary search tree (BST) and two node values p,q.
        Return the lowest common ancestors(LCA) of the two nodes in BST.

    Brute Force :
        private boolean getPath(TreeNode root, List<Integer> path, int x) {
            // Base case: If the current node is null, return false
            if (root == null) {
                return false;
            }

            // Add the current node's value to the path vector
            path.add(root.data);

            // If the current node's value is equal to the target value 'x', return true
            if (root.data == x) {
                return true;
            }

            // Recursively search for the target value 'x' in the left and right subtrees
            if (getPath(root.left, path, x) || getPath(root.right, path, x)) {
                return true;
            }

            // If the target value 'x' is not found in the current path, backtrack
            path.remove(path.size() - 1);
            return false;
        }

        public ArrayList<Integer> Path(TreeNode root, int x){
            ArrayList<Integer> ar = new ArrayList<>();
            if(root == null) return ar;
            getPath(root, ar, x);
            return ar;
        }

        public TreeNode lca(TreeNode root, int p, int q) {
            List<Integer> path1 = new ArrayList<>();
            List<Integer> path2 = new ArrayList<>();

            // Find paths from the root to the given nodes
            if (!getPath(root, path1, p) || !getPath(root, path2, q)) {
                return null;
            }

            // Find the last common element in the paths
            int i = 0;
            while (i < path1.size() && i < path2.size() && path1.get(i).equals(path2.get(i))) {
                i++;
            }

            // The last common element is the LCA
            return new TreeNode(path1.get(i - 1));
        }

        public static void main(String[] args) {
            // Construct the BST
            TreeNode root = new TreeNode(3);
            root.left = new TreeNode(5);
            root.right = new TreeNode(1);
            root.left.left = new TreeNode(6);
            root.left.right = new TreeNode(2);
            root.right.left = new TreeNode(0);
            root.right.right = new TreeNode(8);
            root.left.right.left = new TreeNode(7);
            root.left.right.right = new TreeNode(4);

            LCA sol = new LCA();
            TreeNode ans = sol.lca(root, 5, 1);
            if (ans != null) {
                System.out.println("LCA(5, 1) = " + ans.data);
            } else {
                System.out.println("LCA(5, 1) is not present in the tree");
            }

            // Find the LCA of nodes with values 5 and 4
            ans = sol.lca(root, 5, 4);
            if (ans != null) {
                System.out.println("LCA(5, 4) = " + ans.data);
            } else {
                System.out.println("LCA(5, 4) is not present in the tree");
            }
        }
*/
class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode(int val) {
        this.val = val;
        left = right = null;
    }
}

public class LCA {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null; // Base case: empty tree
        }

        // If both p and q are smaller than root, LCA is in the left subtree
        if (p.val < root.val && q.val < root.val) {
            return lowestCommonAncestor(root.left, p, q);
        }

        // If both p and q are greater than root, LCA is in the right subtree
        if (p.val > root.val && q.val > root.val) {
            return lowestCommonAncestor(root.right, p, q);
        }

        // If one value is on the left and the other on the right, root is the LCA
        return root;
    }

    public static void main(String[] args) {
        // Construct the BST
        TreeNode root = new TreeNode(6);
        root.left = new TreeNode(2);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(4);
        root.left.right.left = new TreeNode(3);
        root.left.right.right = new TreeNode(5);
        root.right.left = new TreeNode(7);
        root.right.right = new TreeNode(9);

        LCABST solution = new LCABST();
        TreeNode p = root.left; // Node with value 2
        TreeNode q = root.right; // Node with value 8

        TreeNode lca = solution.lowestCommonAncestor(root, p, q);
        System.out.println("LCA of " + p.val + " and " + q.val + " is: " + lca.val); // Output: 6
    }
}
