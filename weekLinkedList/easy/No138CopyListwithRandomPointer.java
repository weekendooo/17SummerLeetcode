package LinkedListMedium;

class RandomListNode {
	      int label;
	      RandomListNode next, random;
	      RandomListNode(int x) { this.label = x; }
	  };

public class No138CopyListwithRandomPointer {

	public RandomListNode copyRandomList(RandomListNode head) {
        RandomListNode cur, next;
        cur = head;
        while (cur != null) {
            next = cur.next;
            RandomListNode copy = new RandomListNode(cur.label);
            cur.next = copy;
            copy.next = next;
            cur = next;
        }
        
        cur = head;
        while (cur != null) {
            if (cur.random != null) {
                cur.next.random = cur.random.next;
            }
            cur = cur.next.next;
        }
        
        cur = head;
        RandomListNode beforeHead = new RandomListNode(0);
        RandomListNode copy = beforeHead;
        RandomListNode copyNext = beforeHead;
        
        while (cur != null) {
            next = cur.next.next;
            copyNext = cur.next;
            copy.next = copyNext;
            copy = copyNext;
            cur.next = next;
            cur = next;
        }
        return beforeHead.next;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
