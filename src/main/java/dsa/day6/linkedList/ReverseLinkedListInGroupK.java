package dsa.day6.linkedList;

import dsa.day5.linkedList.ListNode;
import dsa.day5.linkedList.ReverseLinkedList;

public class ReverseLinkedListInGroupK {
	public static void main(String[] args) {
		int[] arr = {1,2,3,4,5,6,7,8};
		int k = 3;
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
		
		head = reverseKGroup(head, k);
		
		ReverseLinkedList.printList(head);
	}

	private static ListNode reverseKGroup(ListNode head, int k) {
		if(head == null||head.next == null) return head;
	    
	    int length = getLength(head);
	    
	    ListNode dummyHead = new ListNode(0);
	    dummyHead.next = head;
	    
	    ListNode pre = dummyHead;
	    ListNode cur;
	    ListNode nex;
	    
	    while(length >= k) {
	        cur = pre.next;
	        nex = cur.next;
	        for(int i=1;i<k;i++) {
	            cur.next = nex.next;
	            nex.next = pre.next;
	            pre.next = nex;
	            nex = cur.next;
	        }
	        pre = cur;
	        length -= k;
	    }
	    return dummyHead.next;
	}

	private static int getLength(ListNode head) {
		int length = 0;
		ListNode temp = head;
		
		while(temp != null) {
			temp = temp.next;
			length++;
		}
		
		return length;
	}
}
