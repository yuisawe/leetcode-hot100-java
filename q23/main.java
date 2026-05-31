package q23;

import java.util.ArrayDeque;
import java.util.PriorityQueue;
import java.util.Queue;

public class main {
    
}
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
// class Solution {
//     public ListNode mergeKLists(ListNode[] lists) {
//         if(lists.length == 0) return null;
//         Queue<ListNode> que = new ArrayDeque<>();
//         for(int i = 0 ; i < lists.length ; i++){
//             if (lists[i] != null) {
//                 que.add(lists[i]);
//             }
//         }
//         while(que.size() >= 2){
//             ListNode head1 = que.poll();
//             ListNode head2 = que.poll();
//             que.add(mergeTwoLists(head1, head2));
//         }
//         return que.poll();
//     }
//     public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
//         ListNode prehead = new ListNode(-1);

//         ListNode prev = prehead;
//         while (l1 != null && l2 != null) {
//             if (l1.val <= l2.val) {
//                 prev.next = l1;
//                 l1 = l1.next;
//             } else {
//                 prev.next = l2;
//                 l2 = l2.next;
//             }
//             prev = prev.next;
//         }

//         // 合并后 l1 和 l2 最多只有一个还未被合并完，我们直接将链表末尾指向未合并完的链表即可
//         prev.next = l1 == null ? l2 : l1;

//         return prehead.next;
//     }
// }

class Solution {
    class Node implements Comparable<Node>{
        ListNode ptr;
        @Override
        public int compareTo(Node other){
            return this.ptr.val - other.ptr.val;
        }
        public Node(ListNode ptr){
            this.ptr = ptr;
        }
    }
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<Node> que = new PriorityQueue<>();
        ListNode preHead = new ListNode(-1);
        ListNode cur = preHead;
        for(int i = 0 ;i < lists.length ; i++){
            if(lists[i]!=null) que.add(new Node(lists[i]));
        }
        while(!que.isEmpty()){
            ListNode minNodeHead = que.poll().ptr;
            cur.next = minNodeHead;
            cur = cur.next;
            if(minNodeHead.next!=null) que.add(new Node(minNodeHead.next));
        }
        return preHead.next;
    }
}