package q560;

import java.util.HashMap;
import java.util.Map;

public class main {
    public static void main(String[] args) {
        
    }
}

// class Solution {
//     public int subarraySum(int[] nums, int k) {
//         // 定义dp[i] 是以第i个数字结尾的子数组的个数
//         int[] pre = new int[nums.length];
//         int[] ans = new int[nums.length];
//         pre[0] = nums[0];
//         for(int i = 1; i< nums.length ; i++){
//             pre[i] = pre[i-1] + nums[i];
//         }
//         // s[j] - s[i] = k 找有多少对这样的i， j
//         //遍历到j时，找有多少个这样的i使得s[i] = s[j] - k;
//         // 维护一个hash表，里面存的就是cnt[s[j] - k];
//         Map<Integer , Integer> map = new HashMap<>();
//         map.put(0, 1);
//         for(int i = 0 ; i < nums.length;i++){
//             map.put(pre[i], 1);
//             if(map.containsKey(pre[i] - k)){
//                 ans[i] = map.get(pre[i] - k);
//             }else{
//                 ans[i] = 0;
//             }
//         }
//         int res = 0;
//         for(int num :ans){
//             res += num ;
//         }

//         return res;
//     }
// }
class Solution {
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int pre = 0, res = 0;
        for (int num : nums) {
            pre += num;
            res += map.getOrDefault(pre - k, 0);
            map.put(pre, map.getOrDefault(pre, 0) + 1);
        }
        return res;
    }
}