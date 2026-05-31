package q234;

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
    public boolean isPalindrome(ListNode head) {
        ListNode halfEnd = findHalfEnd(head);
        ListNode secondeStart = reverseList(halfEnd.next);
        boolean res = true;
        ListNode curOne = head;
        ListNode curTwo = secondeStart;
        while(res && curTwo!=null){
            if(curOne.val!=curTwo.val) res = false;
            curOne = curOne.next;
            curTwo = curTwo.next;
        }
        halfEnd.next = reverseList(secondeStart);
        return res;
    }
    public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode newhead = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return newhead;
    }
    public ListNode findHalfEnd(ListNode head){
        ListNode one = head;
        ListNode two = head;
        while(two!=null &&two.next!=null&&two.next.next!=null){
            one = one.next;
            two = two.next.next;
        }
        return one;
    }
}