package may.challenge.week1;

import may.challenge.utils.TreeNode;

public class BinaryCousin {

	public static void main(String[] args) {
		TreeNode node = new TreeNode();
		node.val = 1;
		node.left = new TreeNode();
		node.right = new TreeNode();
		node.left.val = 2;
		node.right.val = 3;
		node.left.left = new TreeNode();
		node.left.right = new TreeNode();
		node.left.left = null;
		node.left.right.val = 4;
		node.right.left = new TreeNode();
		node.right.right = new TreeNode();
		node.right.left = null;
		node.right.right.val =5;
		BinaryCousin binaryCousin = new BinaryCousin();
		System.out.println(binaryCousin.isCousins(node, 5, 4));
		
	}
	
	public int getHeight(TreeNode root, int data, int height) {
		if(root == null) {
			return 0;
		}
		if(root.val == data) {
			return height;
		}
		int leftHeight = getHeight(root.left, data, height+1);
		if(leftHeight > 0 ) {
			return leftHeight;
		}
		int rightHeight = getHeight(root.right, data, height+1);
		if(rightHeight > 0 ) {
			return rightHeight;
		}
		return -1;
	}
	
	public boolean isSibling(TreeNode root, int x, int y) {
		if (root == null) {
			return false;
		}
		if(root.left ==null) {
			return isSibling(root.right, x, y);
		}
		if(root.right ==null) {
			return isSibling(root.left, x, y);
		}
		return ((root.left.val == x && root.right.val == y) || (root.left.val == y && root.right.val == x)
				|| isSibling(root.left, x, y) || isSibling(root.right, x, y));
	}
    public boolean isCousins(TreeNode root, int x, int y) {
		if (root == null) {
			return false;
		}
		if( x == y) {
			return false;
		}
		return ((getHeight(root, x, 1) == getHeight(root, y, 1)) && !isSibling(root, x, y));
        
    }
}
