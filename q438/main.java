package q438;

import java.util.ArrayList;
import java.util.List;

public class main {
    public static void main(String[] args) {
            String s = "baa";
            String p = "aa";
            List<Integer> l = new Solution().findAnagrams(s,p);
    }

    
}
class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        
        List<Integer> ans = new ArrayList<Integer>();
        int sLen = s.length();
        int pLen = p.length();
        if(sLen < pLen) return ans;
        int[] cnt = new int[26];
        for(int i =0 ; i< pLen ; i++){
            cnt[p.charAt(i) - 'a'] ++;
            cnt[s.charAt(i) - 'a'] --;
        }
        if(no_diff(cnt)) ans.add(0);
        for(int i = 1 ; i <= sLen - pLen ; i++ ){
            cnt[s.charAt(i-1) - 'a']++;
            cnt[s.charAt(i + pLen - 1) - 'a']--;
            if(no_diff(cnt)) ans.add(i);
        }
        return ans;
    }
    public boolean no_diff(int[] cnt){
        for(int i = 0 ; i < 26 ; i++){
            if(cnt[i]!=0) return false;
        }
        return true;
    }
}