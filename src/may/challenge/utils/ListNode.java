package may.challenge.utils;

public class ListNode {
	public int val;
	public ListNode next;

	public ListNode() {
	}

	public ListNode(int val) {
		this.val = val;
	}

	public ListNode(int val, ListNode next) {
		this.val = val;
		this.next = next;
	}
	
	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		ListNode node = this;
		while(node!=null) {
			sb.append(node.val + "-> ") ;
			node = node.next;
		}
		sb.append("NULL") ;
		return sb.toString();
	}
}
