package LeetCode.listnode;

import Model.ListNode;

public class ListNode01 {

	public ListNode removeElements(ListNode head, int val) {
		//头部单独处理
		while (head != null && head.val == val) {
			head = head.next;
		}
		ListNode currentListNode = head;
		while (currentListNode != null && currentListNode.next != null) {
			if (currentListNode.next.val == val) {
				currentListNode.next = currentListNode.next.next;
			} else {
				currentListNode = currentListNode.next;
			}
		}
		return head;
	}
}
