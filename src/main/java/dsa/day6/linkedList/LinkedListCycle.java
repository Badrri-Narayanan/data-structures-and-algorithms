package dsa.day6.linkedList;

import java.util.HashSet;
import java.util.Set;

import dsa.day5.linkedList.ListNode;

public class LinkedListCycle {
	public static void main(String[] args) {
		int[] arr1 = {1,9,1,2,4};
		
		ListNode head = null, prev = null;
		
		for(int n: arr1) {
			ListNode node = new ListNode(n);
			if(head == null) {
				head = node;
				prev = head;
			} else {
				prev.next = node;
				prev = node;
			}
		}
		
//		prev.next = head.next;
		
		System.out.println("IsCyclic - " + hasCycle(head));
	}
	
	public static boolean hasCycle(ListNode head) {
        boolean isCyclic = false;
        ListNode temp = head;
        Set<ListNode> hash = new HashSet<>();

        while(temp != null) {
        	if(!hash.add(temp)) {
        		isCyclic = true;
        		break;
        	}
        	temp = temp.next;
        }
        
        return isCyclic;
    }
}
