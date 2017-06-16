package LinkedListEasy;

public class No21MergeTwoSortedLists {
	// recursive
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        
        ListNode node;
        if (l1.val < l2.val) {
            node = l1;
            node.next = mergeTwoLists(l1.next, l2);
        }
        else {
            node = l2;
            node.next = mergeTwoLists(l1, l2.next);
        }
        return node;
    }
	
	
	// iterative
	public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        
        ListNode cur = new ListNode(0);
        ListNode beforeHead = cur;
        
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                cur.next = l1;
                cur = cur.next;
                l1 = l1.next;
            }
            else {
                cur.next = l2;
                cur = cur.next;
                l2 = l2.next;
            }
        }
        
        if (l1 != null) {
            cur.next = l1;
            cur = cur.next;
            l1 = l1.next;
        }
        if (l2 != null) {
            cur.next = l2;
            cur = cur.next;
            l2 = l2.next;
        }
        return beforeHead.next;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
