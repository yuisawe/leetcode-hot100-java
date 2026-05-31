package q24;

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
    // public ListNode swapPairs(ListNode head) {
    //     if(head == null) return null;
    //     ListNode zero = new ListNode(0 , head);
    //     ListNode cur = head;
    //     ListNode prev = zero;
    //     ListNode next = head.next;
    //     while(cur!= null && next!=null){
    //         prev.next = next;
    //         cur.next = next.next;
    //         next.next = cur;

            
    //         prev = cur;
    //         cur = cur.next;
    //         if(cur==null) break;
    //         next = cur.next == null ? null : cur.next;
    //     }
    //     return zero.next;
    // }
    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next==null) return head;
        ListNode next = head.next;
        head.next = swapPairs(next.next);
        next.next = head;
        return next;
    }
}
