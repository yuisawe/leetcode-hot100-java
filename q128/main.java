package leetcode_hot100.q128;

import java.util.HashSet;
import java.util.Set;

class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length == 0) return 0;
        int maxlen = 1;
        Set<Integer> set = new HashSet<Integer>();
        for(int num :nums){
            set.add(num);
        }
        for(int num :set){
            if(!set.contains(num - 1)){
                int len = 1;
                while(set.contains(num + len)){
                    len++;
                }
                maxlen = Math.max(len , maxlen);
            }
        }




        return maxlen;
        
    }
}