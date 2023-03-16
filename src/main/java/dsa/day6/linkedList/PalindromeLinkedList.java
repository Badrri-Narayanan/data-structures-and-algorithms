package dsa.day6.linkedList;

import dsa.day5.linkedList.ListNode;

public class PalindromeLinkedList {
	public static void main(String[] args) {
		int[] arr = {1,2,3,4,5};
//		int[] arr = {1,2,2,1};
		
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
		
		System.out.println("Is Palindrome = " + isPalindrome(head));
	}
	
	public static boolean isPalindrome(ListNode head) {
        boolean isPalindrome = true;
        
        int length = getLength(head);
        
        if(length <= 1)
        	return isPalindrome;
        
        ListNode prev = null, temp2 = head, head2 = null;
        int i=0;
        
        while(i<length/2) {
        	ListNode temp1 = new ListNode(temp2.val);
        	if(head2 == null) {
        		head2 = temp1;
        		prev = head2;
        	} else {
        		prev.next = temp1;
        		prev = temp1;
        	}
        	temp2 = temp2.next;
        	i++;
        }
        prev.next = null;
        
        if(length % 2 != 0) {
        	temp2 = temp2.next;
        }
        head2 = reverseList(head2);
        
        ListNode dupList = head2;
        
        while(temp2 != null) {
        	if(temp2.val != dupList.val) {
        		isPalindrome = false;
        	}
        	temp2 = temp2.next;
        	dupList = dupList.next;
        }
        
        return isPalindrome;
    }

	private static ListNode reverseList(ListNode head) {
		ListNode curr = head, prev = null, next = null;
		
		while(curr != null) {
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}
		
		head = prev;
		
		return head;
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
