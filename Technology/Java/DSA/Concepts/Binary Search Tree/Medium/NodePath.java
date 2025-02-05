/*
    Find Node Path of the given value
*/

class NodePath{
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

    public static void main(String[] args) {
        // Create a sample binary search tree.
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);

        NodePath sol = new NodePath();
        List<Integer> ar = sol.Path(root, 2);
        System.out.println("Path of the given node is: ");
        for(var x : ar){
            System.out.println(x);
        }
    }
}