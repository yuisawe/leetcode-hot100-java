package q3;

import java.util.HashSet;
import java.util.Set;

public class main {
    
}
class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.isEmpty()) return 0;
        if(s.length() == 1) return 1;
        int ans = 1;
        Set<Character> set = new HashSet<Character>();
        set.add(s.charAt(0));
        int r = 1;
        for(int i = 0 ; i < s.length();i++){
            if(i!=0) set.remove(s.charAt(i-1));
            while(r<s.length()&&!set.contains(s.charAt(r))){
                set.add(s.charAt(r));
                r++;
            }
            ans = Math.max(ans, r-i);
        }
        return ans;
    }

}