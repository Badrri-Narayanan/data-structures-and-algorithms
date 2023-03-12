package dsa.day5.linkedList;

public class MergeTwoSortedLinkedList {
	public static void main(String[] args) {
		int[] arr1 = {1,2,3,4,5};
		int[] arr2 = {6,7,8,9};
		
		ListNode head1 = null, prev = null;
		
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
		prev = null;
		ListNode head2 = null;
		
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
		
		ReverseLinkedList.printList(head1);
		ReverseLinkedList.printList(head2);
		
		ListNode mergedHead = mergeTwoLists(head1, head2);
		
		ReverseLinkedList.printList(mergedHead);
	}
	
	public static ListNode mergeTwoLists(ListNode head1, ListNode head2) {
        ListNode head = null, temp1 = head1, temp2 = head2, prev = null;
        
        while(temp1 != null && temp2 != null) {
        	ListNode node = new ListNode();
        	if(temp1.val < temp2.val) {
        		if(head == null) {
        			head = temp1;
        			prev = head;
        		} else {
        			node.val = temp1.val;
        			prev.next = node;
        			prev = node;
        		}
        		temp1 = temp1.next;
        	} else {
        		if(head == null) {
        			head = temp2;
        			prev = head;
        		} else {
        			node.val = temp2.val;
        			prev.next = node;
        			prev = node;
        		}
        		temp2 = temp2.next;
        	}
        }
        
        while(temp1 != null) {
        	ListNode node = new ListNode();
        	
        	if(head == null) {
    			head = temp1;
    			prev = head;
    		} else {
    			node.val = temp1.val;
    			prev.next = node;
    			prev = node;
    		}
    		temp1 = temp1.next;
        }
        
        while(temp2 != null) {
        	ListNode node = new ListNode();
        	if(head == null) {
    			head = temp2;
    			prev = head;
    		} else {
    			node.val = temp2.val;
    			prev.next = node;
    			prev = node;
    		}
    		temp2 = temp2.next;
        }
        return head;
    }
}
