package dsa.day6.linkedList;

import java.util.HashSet;
import java.util.Set;

import dsa.day5.linkedList.ListNode;
import dsa.day5.linkedList.ReverseLinkedList;

public class LinkedListCycle2 {
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
		
		ReverseLinkedList.printList(head);
	}
	
	public ListNode detectCycle(ListNode head) {
		ListNode repeatingNode = null, curr = head;
		Set<ListNode> hash = new HashSet<>();
		
		while(curr != null) {
			if(!hash.add(curr)) {
				repeatingNode = curr;
				break;
			}
            curr = curr.next;
		}
        
		return repeatingNode;
    }
}
