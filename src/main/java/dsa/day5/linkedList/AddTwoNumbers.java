package dsa.day5.linkedList;

public class AddTwoNumbers {
	public static void main(String[] args) {
//		int[] arr1 = {2,4,3}, arr2 = {5,6,4};
//		int[] arr1 = {9,9,9,9,9,9,9}, arr2 = {9,9,9,9};
		int[] arr1 = {3,7}, arr2 = {9,2};
		
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
		
		ListNode resultHead = addTwoNumbers(head1, head2);
		
		ReverseLinkedList.printList(resultHead);
	}
	
	public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = null, prev = null, temp1 = l1, temp2 = l2;
        boolean isCarryforward = false;
        
        while(temp1 != null && temp2 !=null) {
        	ListNode node = new ListNode();
        	int resultVal = isCarryforward ? 1 : 0;
        	isCarryforward = (temp1.val + temp2.val + resultVal) >= 10;
        	resultVal += isCarryforward ? (temp1.val+temp2.val)-10 : temp1.val+temp2.val;
        	node.val = resultVal;
        	
        	if(head == null) {
        		head = node;
        		prev = head;
        	} else {
        		prev.next = node;
        		prev = node;
        	}
        	temp1 = temp1.next;
        	temp2 = temp2.next;
        }
        
        while(temp1 != null) {
        	ListNode node = new ListNode();
        	int resultValue = isCarryforward ? 1 +temp1.val : temp1.val;
        	isCarryforward = resultValue >= 10;
        	node.val = isCarryforward ? resultValue-10 : resultValue;
        	
        	if(head == null) {
        		head = node;
        		prev = head;
        	} else {
        		prev.next = node;
        		prev = node;
        	}
        	
        	temp1 = temp1.next;
        }
        
        while(temp2 != null) {
        	ListNode node = new ListNode();
        	int resultValue = isCarryforward ? 1 + temp2.val : temp2.val;
        	isCarryforward = resultValue >= 10;
        	node.val = isCarryforward ? resultValue-10 : resultValue;
        	
        	if(head == null) {
        		head = node;
        		prev = head;
        	} else {
        		prev.next = node;
        		prev = node;
        	}
        	
        	temp2 = temp2.next;
        }
        
        if(isCarryforward) {
        	ListNode node = new ListNode(1);
        	prev.next = node;
        }
        
        return head;
    }
}
