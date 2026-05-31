package q19;

import java.util.Stack;

public class main {
    
}
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode zero = new ListNode(0 , head);
        ListNode ptr1 = zero;
        ListNode ptr2 = zero;
        for(int i = 0 ; i< n ; i++){
            ptr1 = ptr1.next;
        }
        while(ptr1.next!=null){
            ptr1 = ptr1.next ;
            ptr2 = ptr2.next;
        }
        ptr2.next = ptr2.next.next;
        return zero.next;
    }
}