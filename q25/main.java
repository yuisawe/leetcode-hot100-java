package q25;

import java.util.ArrayList;
import java.util.List;

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
    public ListNode reverseKGroup(ListNode head, int k) {
        if (k == 1) return head;
        List<ListNode> heads = new ArrayList<>();
        List<ListNode> tails = new ArrayList<>();

        while (head != null) {
            // 找到当前组的尾节点（第 k 个）
            ListNode tail = head;
            int count = 1;
            while (count < k && tail != null) {
                tail = tail.next;
                count++;
            }
            if (tail == null) {
                // 不足 k 个，保持原样
                heads.add(head);
                break;
            }
            ListNode nextGroup = tail.next; // ★ 先保存下一组的起点
            reverse(head, tail);
            heads.add(tail);    // 翻转后 tail 变成新头
            tails.add(head);    // 翻转后 head 变成新尾
            head = nextGroup;   // ★ 用保存的值，而非被改写的 tail.next
        }

        int hlen = heads.size();
        int tlen = tails.size();
        if (hlen == tlen) {
            for (int i = 0; i < hlen - 1; i++) {
                tails.get(i).next = heads.get(i + 1);
            }
            tails.get(hlen - 1).next = null;
        } else {
            for (int i = 0; i < tlen; i++) {
                tails.get(i).next = heads.get(i + 1);
            }
        }
        return heads.get(0);
    }

    public void reverse(ListNode head, ListNode tail) {
        ListNode prev = tail.next; // 翻转后 head 应该指向的位置
        ListNode cur = head;
        while (prev != tail) {
            ListNode next = cur.next; // ★ 先保存原来的 next
            cur.next = prev;          // 再改写指针
            prev = cur;
            cur = next;               // 用保存的值前进
        }
    }
}