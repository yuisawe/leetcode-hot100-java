package q41;

import java.util.HashMap;
import java.util.Map;

public class main {
    public static void main(String[] args) {
        
    }
}
class Solution {
    public int firstMissingPositive(int[] nums) {
        Map<Integer,Boolean> hm = new HashMap<>();
        for(int num : nums){
            hm.put(num, true);
        }
        for(int i = 1 ; i< Integer.MAX_VALUE ; i++){
            if(hm.getOrDefault(i, false))
                continue;
            return i;
        }
        return Integer.MAX_VALUE;
    }
}