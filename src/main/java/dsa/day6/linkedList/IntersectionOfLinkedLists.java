package dsa.day6.linkedList;

import dsa.day5.linkedList.ListNode;
import dsa.day5.linkedList.ReverseLinkedList;

public class IntersectionOfLinkedLists {
	public static void main(String[] args) {
//		int[] arr1 = {4,1,8,4,5}, arr2 = {5,6,1,8,4,5};
		
		int[] arr1 = {1,9,1,2,4}, arr2 = {3,2,4};
		
		ListNode head1 = null, prev = null, head2 = null;
		
		for(int n: arr1) {
			ListNode node = new ListNode(n);
			if(head1 == null) {
				head1 = node;
				prev = head1;
			} else {
				prev.next = node;
				prev = node;
			}
		}
		
		for(int n: arr2) {
			ListNode node = new ListNode(n);
			if(head2 == null) {
				head2 = node;
				prev = head2;
			} else {
				prev.next = node;
				prev = node;
			}
		}
		
		ListNode intersection = getIntersectionNode(head1, head2);
		
		ReverseLinkedList.printList(intersection);
	}
	
	public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		ListNode intersection=null, tempA=headA, tempB=headB;
        
        int lengthA = 0, lengthB = 0;
        
        while(tempA!=null || tempB!=null) {
        	if(tempA!=null) {
        		lengthA++;
        		tempA = tempA.next;
        	}
        	
        	if(tempB!=null) {
        		lengthB++;
        		tempB = tempB.next;
        	}
        }
        tempA=headA;
        tempB=headB;
        
        if(lengthA > lengthB) {
        	int i = 0;
        	while(i < lengthA-lengthB) {
        		tempA = tempA.next;
        		i++;
        	}
        } else {
        	int i=0;
        	while(i < lengthB-lengthA) {
        		tempB = tempB.next;
        		i++;
        	}
        }
        
        while(tempA!=null && tempB!=null) {
        	if(tempA.val == tempB.val && tempA == tempB) {
        		if(intersection == null) {
        			intersection = tempA;
        		}
        	} else {
        		if(intersection != null) {
        			intersection = null;
        		}
        	}
        	tempA = tempA.next;
        	tempB = tempB.next;
        }
        
        return intersection;
    }
}
