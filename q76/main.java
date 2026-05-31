package q76;

import java.util.HashSet;
import java.util.Set;

class Solution {
    public String minWindow(String s, String t) {
        int tlen = t.length();
        int slen = s.length();
        if(tlen > slen) return "";
        int[] cnt = new int['z' - 'A' + 1];
        for(int i = 0 ; i < tlen ; i++){
            cnt[t.charAt(i) - 'A'] ++;
            cnt[s.charAt(i) - 'A'] --;
        }
        Set<Integer> set = new HashSet<>();
        for(int i = 0 ; i < tlen ; i++){
                if (cnt[t.charAt(i) - 'A'] > 0) { // 代表还没有覆盖
                    set.add(t.charAt(i) - 'A'); // 队列存还没覆盖的字母
                }
        }
        int start = 0, end = tlen - 1;
        String ans = s+'a';
        while(start <= end && end < slen){
            while (!set.isEmpty()) {
                if (end + 1 < slen) {
                    end++;
                } else {
                    break;
                }
                int c = s.charAt(end) - 'A';
                cnt[c]--;
                if(cnt[c] <=0){
                    set.remove(c);
                }
            }
            if (end >= slen) break;
            String str = s.substring(start, end + 1);
            if (str.length() < ans.length() && set.isEmpty()) ans = str;
            if (!set.isEmpty()) break;
            while (set.isEmpty()) {
                str = s.substring(start, end + 1);
                if (str.length() < ans.length()) ans = str;
                int c = s.charAt(start) - 'A';
                cnt[c]++;
                start++;
                if (cnt[c] > 0) {
                    set.add(c);
                }
                if (start > end) break;
            }
        }
        return ans.equals(s + 'a') ? "" : ans;

    }
}
class main{
    public static void main(String[] args) {
        String s = "ADOBECODEBANC";
        String t = "ABC";
        System.out.println(new Solution().minWindow(s, t));
    }
}