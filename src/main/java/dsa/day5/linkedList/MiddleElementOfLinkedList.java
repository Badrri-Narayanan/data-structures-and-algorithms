package dsa.day5.linkedList;

public class MiddleElementOfLinkedList {
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
		
		ListNode mid = middleNode(head);
		
		ReverseLinkedList.printList(mid);
	}
	
	public static ListNode middleNode(ListNode head) {
        int length = 0;
        
        ListNode temp = head;
        
        while(temp != null) {
            length++;
            temp = temp.next;
        }
        
        if(length == 2)
            return head.next;
        
        int mid = length/2, i = 0;
        temp = head;
        while(i<mid) {
            temp = temp.next;
            i++;
        }
        
        return temp;
    }
}
