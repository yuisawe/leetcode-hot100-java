import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] res = new int[n - k + 1];
        // 单调队列：存放下标，对应数值从队首到队尾递减
        Deque<Integer> deque = new ArrayDeque<>();
        int idx = 0;

        for (int i = 0; i < n; i++) {
            // 1. 移除队尾所有小于等于当前元素的（它们不可能再成为最大值了）
            while (!deque.isEmpty() && nums[deque.peekLast()] <= nums[i]) {
                deque.pollLast();
            }
            // 2. 当前元素入队
            deque.offerLast(i);

            // 3. 检查队首是否还在窗口内
            if (deque.peekFirst() <= i - k) {
                deque.pollFirst();
            }

            // 4. 当窗口形成后，记录最大值（队首就是最大值的下标）
            if (i >= k - 1) {
                res[idx++] = nums[deque.peekFirst()];
            }
        }

        return res;
    }
}

public class main {
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;
        int[] res = sol.maxSlidingWindow(nums, k);
        // 期望: [3, 3, 5, 5, 6, 7]
        for (int num : res) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
