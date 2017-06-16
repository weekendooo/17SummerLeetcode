package LinkedListEasy;

public class No234PalindromeLinkedList {

	public boolean isPalindrome(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        if (fast != null) {
            slow = slow.next; // odd number of nodes;
        }
        
        slow = reverse(slow);
        fast = head;
        
        while (slow != null) {
            if (slow.val != fast.val) return false;
            slow = slow.next;
            fast = fast.next;
        }
        return true;
    }
    
    private ListNode reverse(ListNode node) {
        ListNode pre = null;
        while (node != null) {
            ListNode next = node.next;
            node.next = pre;
            pre = node;
            node = next;
        }
        return pre;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
