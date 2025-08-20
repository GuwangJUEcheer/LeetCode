package Model;

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */
class MyLinkedList {
	int size = 0;
	ListNode tempNode = new ListNode(0);

	public MyLinkedList() {


	}

	public int get(int index) {
		if (index < 0 || index >= size) {
			return -1;
		}
		ListNode currentNode = tempNode;
		while (index-- >= 0) {
			currentNode = currentNode.next;
		}
		return currentNode.val;
	}

	public void addAtHead(int val) {
		ListNode node = new ListNode(val);
		node.next = tempNode.next;
		tempNode.next = node;
		size++;
	}

	public void addAtTail(int val) {
		ListNode node = new ListNode(val);
		ListNode currentNode = tempNode;
		while (currentNode.next != null) {
			currentNode = currentNode.next;
		}
		currentNode.next = node;
		size++;
	}

	public void addAtIndex(int index, int val) {
		if (index < 0 || index > size) {
			return;
		}
		ListNode node = new ListNode(val);
		ListNode curr = tempNode;
		while (index-- > 0) {
			curr = curr.next;
		}
		node.next = curr.next;
		curr.next = node;
		size++;
	}

	public void deleteAtIndex(int index) {
		if (index < 0 || index >= size) {
			return;
		}
		ListNode currentNode = tempNode;
		while (index-- > 0) {
			currentNode = currentNode.next;
		}
		ListNode deleted = currentNode.next;
		currentNode.next = deleted.next;
		deleted.next = null;
		size--;
	}
}


