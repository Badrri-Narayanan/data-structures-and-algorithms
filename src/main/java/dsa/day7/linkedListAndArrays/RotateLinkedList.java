package dsa.day7.linkedListAndArrays;

import dsa.day5.linkedList.ListNode;
import dsa.day5.linkedList.ReverseLinkedList;

public class RotateLinkedList {
	public static void main(String[] args) {
		int[] arr = {1,2,3};
		int k = 200000;
		
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
		
		head = rotateRight(head, k);
		
		ReverseLinkedList.printList(head);
	}
	
	public static ListNode rotateRight(ListNode head, int k) {		
		int length = getLength(head);
		
		if(length <= 1)
			return head;
		
        int i = 0, reminder = k % length;
        
        while(i < reminder) {
        	head = rotateListToRight(head);
        	i++;
        }
        
        return head;
    }

	private static int getLength(ListNode head) {
		int length = 0;
		
		while(head != null) {
			head = head.next;
			length++;
		}
		
		return length;
	}

	private static ListNode rotateListToRight(ListNode head) {
		ListNode temp = head, curr = head;
		
		while(curr.next != null && curr.next.next != null) {
			curr = curr.next;
		}
		
		if(curr.next != null) {
			head = curr.next;
			curr.next = null;
			head.next = temp;
		}

		return head;
	}
}
