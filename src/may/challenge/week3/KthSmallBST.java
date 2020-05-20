package may.challenge.week3;

import may.challenge.utils.TreeNode;

public class KthSmallBST {
    int count = 0;
    public int kthSmallest(TreeNode root, int k){
        return kthSmallestH(root,k).val;
    }
    public TreeNode kthSmallestH(TreeNode root, int k) {
        if(root == null){
            return null;
        }
        TreeNode left = kthSmallestH(root.left,k);
        if(left != null){
            return left;
        }
        count++;
        if(count == k){
            return root;
        }
        return kthSmallestH(root.right,k);
    }
    public static void main(String[] args) {
		TreeNode root = new TreeNode();
		root.val = 3;
		root.left = new TreeNode();
		root.right = new TreeNode();
		root.left.val = 1;
		root.right.val = 4;
		root.left.right = new TreeNode();
		root.left.right.val = 2;
		
		System.out.println(new KthSmallBST().kthSmallest(root, 2));
	}
}
