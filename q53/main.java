package q53;

import java.util.Arrays;
import java.util.Collection;

class main{
    public static void main(String[] args) {
        
    }
}

class Solution {
    public int maxSubArray(int[] nums) {
        // 定义dp[i]是以i结尾的最大和
        int[] dp = new int[nums.length];
        int mymax = nums[0];
        dp[0] = nums[0];
        for(int i = 1 ; i < nums.length ; i++){
            dp[i] = Math.max(nums[i] + dp[i-1], nums[i]);
            mymax = Math.max(mymax, dp[i]);
        }
        return mymax;
    }
}