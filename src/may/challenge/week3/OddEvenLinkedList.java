package may.challenge.week3;

import may.challenge.utils.ListNode;

public class OddEvenLinkedList {

	public static void main(String[] args) {
		OddEvenLinkedList oddEvenLinkedList = new OddEvenLinkedList();
		ListNode root = new ListNode(1);
		/*root.next = new ListNode(2);
		root.next.next = new ListNode(3);
		root.next.next.next = new ListNode(4);
		root.next.next.next.next = new ListNode(5);
		root.next.next.next.next.next = new ListNode(6);*/

		System.out.println(oddEvenLinkedList.oddEvenList(root));
	}
	// 1 -> 2 -> 3 -> 4 -> 5 -> 6 -> NULL
	// o    e    o    e    o    e     o

	// 1 -> 2 -> 3 -> 4 -> 5 -> NULL
	// o    e    o    e    o     e
	public ListNode oddEvenList(ListNode head) {
		if (head == null)
			return head;
		ListNode odd = head;
		ListNode even = head.next;
		ListNode evenFirst = head.next;
		while (true) {
			if (even == null || even.next == null || odd == null) {
				odd.next = evenFirst;
				break;
			}
			if(odd.next == null ) {
				even.next = null;
				odd.next = evenFirst;
				break;
			}
			if (even != null && even.next != null) {
				odd.next = even.next;
				odd = even.next;
			}
			if (odd != null && odd.next != null) {
				even.next = odd.next;
				even = odd.next;
			}
		}
		return head;
	}
}
