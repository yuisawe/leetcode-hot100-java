package q148;

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
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode cur = head;
        int size = 0;
        while(cur!=null){
            size++;
            cur = cur.next;
        }
        return mergeSort(head, size);
    }
    public ListNode mergeSort(ListNode head,int len){
        if(head == null || head.next == null) return head;
        ListNode secondStart = head;
        ListNode prev = null;
        for(int i = 0 ; i <len / 2 ;i ++){
            prev = secondStart;
            secondStart = secondStart.next;
        }
        prev.next = null;
        head = mergeSort(head, len / 2);
        secondStart = mergeSort(secondStart, len - len / 2);
        return merge(head, len / 2, secondStart, len - len / 2);
    }
    public ListNode merge(ListNode head1 , int len1 , ListNode head2 , int len2){
        if(len1 == 0) return head2;
        if(len2 == 0) return head1;
        ListNode prehead = new ListNode(-1);
        ListNode cur1 = head1 ; 
        ListNode cur2 = head2;
        ListNode prev = prehead;
        while(len1 >0 && len2 > 0){
            if(cur1.val <= cur2.val){
                prev.next = cur1;
                cur1 = cur1.next;
                len1--;
            }else{
                prev.next = cur2;
                cur2 = cur2.next;
                len2--;
            }
            prev = prev.next;
        }
        prev.next = len1 == 0 ? cur2 : cur1;
        return prehead.next;
    }
}