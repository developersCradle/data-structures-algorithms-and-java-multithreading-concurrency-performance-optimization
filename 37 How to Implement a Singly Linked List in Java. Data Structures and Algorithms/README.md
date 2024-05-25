## How to Implement a **Singly Linked List** in Java | Data Structures and Algorithms

- Presents LinkedList.

```
public class SinglyLinkedList {
	
	private ListNode head;
	
	private static class ListNode {
		private int data; //Generic type
		private ListNode next;
		
		public ListNode(int data) {
			this.data = data;
			this.next = null;
		}
	}

}
```