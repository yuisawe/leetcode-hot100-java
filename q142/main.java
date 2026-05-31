package q142;

public class main {
    
}
//设相遇的地方离起始点距离是a;
//设环的起始点离开始的地方是b;
//

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
}
class Solution {
    public ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while(true){
            if(fast == null || fast.next == null){
                return null;
            }
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast) break;
        }
        ListNode ptr = head;
        while(ptr!=slow){
            ptr = ptr.next;
            slow = slow.next;
        }

        return ptr;
    }
}