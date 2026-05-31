package q15;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class main {
    
}
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        for(int i = 0 ; i < nums.length ; i++){
            while(i>0&&i<nums.length&&nums[i]==nums[i-1]) i++;
            if(i>=nums.length-2) break;
            int tofind = 0 - nums[i];
            int pl = i + 1; int pr = nums.length - 1;
            while(pl < pr){
                if(nums[pl] + nums[pr] == tofind){
                    res.add(Arrays.asList(nums[i], nums[pl], nums[pr]));
                    while(pl < pr && nums[pl] == nums[pl+1]) pl++;
                    while(pl < pr && nums[pr] == nums[pr-1]) pr--;
                    pl++;
                    pr--;
                } else if(nums[pl] + nums[pr] < tofind) {
                    pl++;
                } else {
                    pr--;
                }
            }

        }
        return res;
    }
}