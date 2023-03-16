package dsa.day6.linkedList;

import dsa.day5.linkedList.ListNode;

public class PalindromeLinkedListBetterSolution {
	public static void main(String[] args) {
//		int[] arr = {1,2,3,4,5};
		int[] arr = {1,2,3,2,1};
		
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

	private static boolean isPalindrome(ListNode head) {
		boolean isPalindrome = true;
		
		ListNode slow = head, fast = head;
		
		while(fast.next != null && fast.next.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		ListNode head2 = slow.next;

		head2 = reverseList(head2);
		slow.next = head2;
		ListNode temp1 = head, temp2 = slow.next;
		
		while(temp2 != null) {
			if(temp1.val != temp2.val) {
				isPalindrome = false;
				break;
			}
			temp1 = temp1.next;
			temp2 = temp2.next;
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
}
