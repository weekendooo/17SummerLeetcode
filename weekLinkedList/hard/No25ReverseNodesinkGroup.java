package LinkedListHard;

//   1 - 2 - 3 - 4 - 5 - 6   k = 3
//   3 - 2 - 1 - 6 - 5 - 4

public class No25ReverseNodesinkGroup {

	public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null || k < 2) return head;
        ListNode beforeHead = new ListNode(0);
        beforeHead.next = head;
        ListNode prev = beforeHead;
        ListNode tail = beforeHead;
        ListNode temp;
        int count;
        
        while (true) {
            count = k;
            while (count > 0 && tail != null) {
                tail = tail.next;
                count--;
            }
            if (tail == null) break;
            
            head = prev.next;              // 把temp往tail后面插，再按顺序前移一位
            
            while (prev.next != tail) {    //   0  -  1  -  2  -  3  -  4  -  5  -  6
                temp = prev.next;          //  pre   temp        tail
                prev.next = temp.next;     //   0  -  2  -  3  -  1  -  4  -  5  -  6
                temp.next = tail.next;    //   pre   temp  tail
                tail.next = temp;        //     0  -  3 -  2  -  1  -  4  -  5  -  6
                                         //    pre   tail
            }
            tail = head;                // 下一个循环的prev和tail从1开始，1就是while前的 head ＝ prev.next；
            prev = head;
        }
        return beforeHead.next;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
