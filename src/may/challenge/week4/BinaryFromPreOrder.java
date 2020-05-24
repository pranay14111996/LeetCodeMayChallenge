package may.challenge.week4;

import may.challenge.utils.TreeNode;

public class BinaryFromPreOrder {

	int[] preOrder = null;
	public static void main(String[] args) {
		//int[] arr = {8,5,1,7,10,12};
		int[] arr = {5,4,3,2,1};
		//			  0 1 2 3  4  5
		//length = 6 
		TreeNode root = new BinaryFromPreOrder().bstFromPreorder(arr);
		System.out.println( root );
	}
	
    public TreeNode bstFromPreorder(int[] preOrder) {
    	this.preOrder = preOrder;
    	if(null == preOrder || preOrder.length == 0) {
    		return null;
    	}
        return bstHelper(0,preOrder.length);
    }

	private TreeNode bstHelper(int idx, int endIdx) {
		if(idx == endIdx) {
			return null;
		}
		TreeNode root = new TreeNode(preOrder[idx]);

		// find right child index
		int rightIdx = idx+1 ;
		for( ; rightIdx < endIdx; rightIdx++) {
			if(preOrder[rightIdx] > preOrder[idx]) {
				break;
			}
		}
		root.left = bstHelper(idx+1,rightIdx);
		root.right = bstHelper(rightIdx, endIdx);
		return root;
	}
}
