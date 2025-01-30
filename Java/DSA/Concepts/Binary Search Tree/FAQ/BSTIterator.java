/*
	BST iterator
		Implement the BSTIterator class that represents an iterator over the in-order traversal of a binary search tree (BST):

		- BSTIterator(TreeNode root) Initializes an object of the BSTIterator class. The root of the BST is given as part of the constructor. The pointer should be initialized to a non-existent number smaller than any element in the BST.
		- boolean hasNext() Returns true if there exists a number in the traversal to the right of the pointer, otherwise returns false.
		- int next() Moves the pointer to the right, then returns the number at the pointer.

	Notice that by initializing the pointer to a non-existent smallest number, the first call to the next() will return the smallest element in the BST.

	Assume that the next() calls will always be valid. That is, there will be at least a next number in the in-order traversal when the next() is called.
	
	Brute Force : 

		class BSTIterator {
			private List<Integer> arr;
			private int index;

			private void inOrderTraversal(TreeNode root){
				if(root == null) return;
				inOrderTraversal(root.left);
				arr.add(root.data);
				inOrderTraversal(root.right);
			}

		    public BSTIterator(TreeNode root) {
		    	values = new ArrayList<>();
		    	inOrderTraversal(root);
		    	index = -1;
		    }

		    public boolean hasNext() {
		        return index + 1 < arr.size();
		    }

		    public int next() {
		        return arr.get(index + 1);
		    }
		    
		}

	Complexity Analysis
		Time Complexity O(N) where n is the number of nodes in the tree for inorder traversal and constant time O(1) for hasNext and next.

		SpaceComplexity O(N) due to the storage of values from the inorder traversal in an array
*/
// Definition for a binary tree node
class TreeNode {
    int data;
    TreeNode left;
    TreeNode right;
    TreeNode(int val) { data = val; left = null; right = null; }
}

class BSTIterator {
    private Stack<TreeNode> stack = new Stack<>();
    
    // Constructor initializes the iterator on the root of the BST
    public BSTIterator(TreeNode root) {
        pushAll(root);
    }

    // Returns true if there is a next element in the iterator
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    // Returns the next smallest element in the BST
    public int next() {
        TreeNode temp = stack.pop();
        pushAll(temp.right);
        return temp.data;
    }

    // Helper function to push all the left nodes onto the stack
    private void pushAll(TreeNode node) {
        while (node != null) {
            stack.push(node);
            node = node.left;
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(7);
        root.left = new TreeNode(3);
        root.right = new TreeNode(15);
        root.right.left = new TreeNode(9);
        root.right.right = new TreeNode(20);

        BSTIterator iterator = new BSTIterator(root);
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }
    }
}
/*
	Complexity Analysis
		Time Complexity O(1)as next() and hasNext() occur is constant time, the element pushed onto the stack during traversal to the leftmost node and during subsequent traversals will take O(H) time for each traversal.

		Space Complexity : O(H), where H is the height of the tree. This is because, in the worst case, the stack can contain all the nodes from the root to the leftmost leaf node
*/