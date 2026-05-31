package q2;

public class main {
    public static void main(String[] args) {
        // 测试用例：342 + 465 = 807
        // l1: 2 -> 4 -> 3  (表示 342)
        ListNode l1 = new ListNode(2, new ListNode(4, new ListNode(3)));
        // l2: 5 -> 6 -> 4  (表示 465)
        ListNode l2 = new ListNode(5, new ListNode(6, new ListNode(4)));

        Solution s = new Solution();
        ListNode ans = s.addTwoNumbers(l1, l2);

        // 输出结果应为：7 -> 0 -> 8  (表示 807)
        System.out.print("Result: ");
        while (ans != null) {
            System.out.print(ans.val);
            if (ans.next != null) System.out.print(" -> ");
            ans = ans.next;
        }
        System.out.println();

        // 测试用例2：99 + 1 = 100
        ListNode l3 = new ListNode(9, new ListNode(9));
        ListNode l4 = new ListNode(1);
        ListNode ans2 = s.addTwoNumbers(l3, l4);
        System.out.print("Result2: ");
        while (ans2 != null) {
            System.out.print(ans2.val);
            if (ans2.next != null) System.out.print(" -> ");
            ans2 = ans2.next;
        }
        System.out.println();
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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // 使用 dummy 头节点，避免对头节点的特殊处理
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        int carry = 0;

        // 同时遍历两个链表，只要有一个还没走完或者还有进位就继续
        while (l1 != null || l2 != null || carry != 0) {
            int sum = carry;

            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }

            carry = sum / 10;
            cur.next = new ListNode(sum % 10);  // 先连接新节点
            cur = cur.next;                      // 再移动指针
        }

        return dummy.next;  // 返回真正的头节点
    }
}