package LinkedListEasy;

public class No83RemoveDuplicatesfromSortedList {

	public ListNode deleteDuplicates(ListNode head) {
        ListNode cur = head;
        while (cur != null) {
            if (cur.next == null) break;
            if (cur.val == cur.next.val) {
                cur.next = cur.next.next;
            }
            else {
                cur = cur.next;
            }
        }
        return head;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
