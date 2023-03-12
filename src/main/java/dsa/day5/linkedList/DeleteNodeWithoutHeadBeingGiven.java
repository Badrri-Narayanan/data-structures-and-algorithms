package dsa.day5.linkedList;

public class DeleteNodeWithoutHeadBeingGiven {
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
		
		ListNode node = head.next.next.next;
		
		deleteNode(node);
		
		ReverseLinkedList.printList(head);
	}
	
	public static void deleteNode(ListNode node) {
        ListNode prev = null;
        
        while(node.next != null) {
        	node.val = node.next.val;
        	prev = node;
        	node = node.next;
        }
        prev.next = null;
    }
}
