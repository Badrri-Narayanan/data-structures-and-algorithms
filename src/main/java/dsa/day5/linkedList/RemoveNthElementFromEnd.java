package dsa.day5.linkedList;

public class RemoveNthElementFromEnd {
	public static void main(String[] args) {
//		int[] arr = {1,2,3,4,5};
//		int remove = 2;
		
		int[] arr = {1,2};
		int remove = 2;
		
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
		
		ListNode newHead = removeNthFromEnd(head, remove);
		
		ReverseLinkedList.printList(newHead);
	}
	
	public static ListNode removeNthFromEnd(ListNode head, int n) {
		int length = 0;
		ListNode temp = head, prev = null;
		
		while(temp != null) {
			length++;
			temp = temp.next;
		}
		int removeIndex = length-n, i = 0;
		temp = head;
		while(i<=removeIndex) {
			if(i == removeIndex) {
				if(prev != null)
					prev.next = temp.next;
				else
					head = temp.next;
			}
			prev = temp;
			temp = temp.next;
			i++;
		}
		
        return head;
    }
}
