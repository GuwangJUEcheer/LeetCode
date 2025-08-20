package LeetCode.listnode;

import Model.ListNode;

public class ListNode02 {

	/**
	 * Definition for singly-linked list.
	 * public class ListNode {
	 * int val;
	 * ListNode next;
	 * ListNode() {}
	 * ListNode(int val) { this.val = val; }
	 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
	 * }
	 */
	public ListNode reverseList(ListNode head) {
		//开始是pre节点代表改变后的终结点
		ListNode pre = null;
		//当前遍历节点
		ListNode currentNode = head;
		//终止条件是currentNode指向终结点
		while (currentNode != null) {
			//当前节点的下一个节点
			ListNode temp = currentNode.next;
			currentNode.next = pre;
			pre = currentNode;
			currentNode = temp;
		}
		return head;
	}

	//1-2-3
	public ListNode swapPairs(ListNode head) {
		ListNode dummyNode = new ListNode(0);
		dummyNode.next = head;
		//操作起始指针位置
		ListNode current = dummyNode;
		while (current.next != null && current.next.next != null) {
			ListNode temp = current.next;
			ListNode temp1 = current.next.next.next;
			current.next = current.next.next;
			current.next.next = temp;
			current.next.next.next = temp1;
			//移动两位 准备交换
			current = current.next.next;
		}
		return dummyNode.next;
	}

	public ListNode removeNthFromEnd(ListNode head, int n) {
		ListNode dummyNode = new ListNode(0);
		dummyNode.next = head;
		//定义快慢指针
		ListNode fastNode = dummyNode;
		ListNode slowNode = dummyNode;
		//快指针移动n+1步后 快慢指针一起移动 目的是让慢指针指到删除的上一个要素
		n++;
		while (n-- > 0 && fastNode != null) {
			fastNode = fastNode.next;
		}
		while (fastNode != null) {
			fastNode = fastNode.next;
			slowNode = slowNode.next;
		}
		slowNode.next = slowNode.next.next;
		return dummyNode.next;
	}

	/**
	 * 链表的交点
	 *
	 * @param headA
	 * @param headB
	 * @return
	 */
	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		ListNode currentA = headA;
		ListNode currentB = headB;
		int sizeA = 0, sizeB = 0, gap = 0;
		while (currentA != null) {
			sizeA++;
			currentA = currentA.next;
		}
		while (currentB != null) {
			sizeB++;
			currentB = currentB.next;
		}
		currentA = headA;
		currentB = headB;
		if (sizeA > sizeB) {
			gap = sizeA - sizeB;
			while (gap-- > 0) {
				currentA = currentA.next;
			}
		} else {
			gap = sizeB - sizeA;
			while (gap-- > 0) {
				currentB = currentB.next;
			}
		}
		while (currentA != null) {
			if (currentA == currentB) {
				return currentA;
			}
			currentA = currentA.next;
			currentB = currentB.next;
		}
		return null;
	}

	public boolean hasCycle(ListNode head) {
		ListNode fastNode = head.next;
		ListNode slowNode = head;
		while (fastNode != null && fastNode.next != null) {
			fastNode = fastNode.next.next;
			slowNode = slowNode.next;
			if (fastNode == slowNode) {
				return true;
			}
		}
		return false;
	}

	/**
	 * 链表是否有环
	 *
	 * @param head 头节点
	 * @return 入口
	 */
	public ListNode detectCycle(ListNode head) {

		//定义快指针 快指针每次移动两个距离 慢指针每次移动一格
		ListNode slow = head;
		ListNode fast = head;
		//快慢指针相遇的时候满足 环周长加上相遇位置链表入口的长度 等于 环入口到链表开始的长度
		while (fast != null && fast.next != null) {
			fast = fast.next.next;
			slow = slow.next;
			if (fast == slow) {
				//相遇的位置
				ListNode index1 = fast;
				//从开始出发的坐标
				ListNode index2 = head;
				while (index1 != index2) {
					index1 = index1.next;
					index2 = index2.next;
				}
				return index1;
			}
		}
		return null;
	}
}
