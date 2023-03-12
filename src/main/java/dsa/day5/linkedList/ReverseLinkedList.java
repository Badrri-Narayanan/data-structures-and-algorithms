package dsa.day5.linkedList;

public class ReverseLinkedList {
	public static void main(String[] args) {
		int[] arr = {1,2,3,4,5};
		
		ListNode head = null, prev = null;
		
		for(int n: arr) {
			ListNode node = new ListNode(n);
			if(head == null) {
				head = node;
				prev = head;
			} else {
				prev.next = node;
				prev = node;
			}
		}
		
		printList(head);
		
		head = reverseList(head);
		
		printList(head);
	}
	
	public static void printList(ListNode head) {
		ListNode temp = head;
		
		while(temp != null) {
			System.out.print(" " + temp.val);
			temp = temp.next;
		}
		
		System.out.println();
	}

	public static ListNode reverseList(ListNode head) {
		ListNode temp = head, prevNode = null, nextNode = head;
		
		while(temp != null) {
			nextNode = temp.next;
			temp.next = prevNode;
			prevNode = temp;
			temp = nextNode;
		}
		
		head = prevNode;
		return head;
    }
}
