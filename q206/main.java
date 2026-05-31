package q206;

import java.util.ArrayList;
import java.util.List;

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
public class main {
    
}
// class Solution {
//     public ListNode reverseList(ListNode head) {
//         ListNode cur = head;
//         ListNode prev = null;
//         while(cur != null){
//             ListNode next = cur.next;
//             cur.next = prev ;
//             prev = cur;
//             cur = next;
//         }
//         return prev;
//     }
// }
class Solution {
    public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode newhead = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return newhead;
    }
}