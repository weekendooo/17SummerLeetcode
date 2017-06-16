package LinkedListMedium;

public class No328OddEvenLinkedList {

	public ListNode oddEvenList(ListNode head) {
        if (head != null) {
            
            ListNode odd = head, even = head.next, evenHead = head.next;
            
            while (even != null && even.next != null) { // ??
                odd.next = odd.next.next;
                even.next = even.next.next;
                odd = odd.next;
                even = even.next;
            }
            odd.next = evenHead;
        }
        return head;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
