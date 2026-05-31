package q21;

public class main {
    public static void main(String[] args) {
        
    }
}
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list1 == null) return list2;
        if(list2 == null) return list1;
        ListNode cur1 = list1;
        ListNode cur2 = list2;
        ListNode ans ;
        ListNode ansHead ;
        if(cur1.val <= cur2.val) {
            ans = cur1;
            cur1 = cur1.next;
        }else{
            ans = cur2;
            cur2 = cur2.next;
        }
        ansHead = ans;
        while(cur1!=null && cur2!=null){
            if(cur1.val <= cur2.val){
                ans.next = cur1;
                cur1 = cur1.next;
            }else{
                ans.next = cur2;
                cur2 = cur2.next;
            }
            ans = ans.next;
        }
        if(cur1!=null){
            ans.next = cur1;
        }
        if(cur2!=null){
            ans.next = cur2;
        }

        return ansHead;
    }
}