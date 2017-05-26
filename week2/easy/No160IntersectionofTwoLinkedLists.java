package LinkedListEasy;

class ListNode{
	int val;
	ListNode next;
	ListNode(int x){
		val = x;
		next = null;
	}
}

public class No160IntersectionofTwoLinkedLists {

	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null) return null; // boundary
        
        ListNode curA = headA;
        ListNode curB = headB;
        
        while(curA != curB){
            curA = curA == null? headB : curA.next;
            curB = curB == null? headA : curB.next;
        }
        return curA;
}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
