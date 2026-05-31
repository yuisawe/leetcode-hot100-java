package leetcode_hot100.q49;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String , List<String>> map = new HashMap<String , List<String>>();
        for(String str :strs){
            char[] char_arr = str.toCharArray();
            Arrays.sort(char_arr);
            String key = new String(char_arr);
            if(map.get(key)==null){
                List<String> list = new ArrayList<String>();
                list.add(str);
            }else {
                map.get(key).add(str);
            }
        }
        return new ArrayList<List<String>>(map.values());
    }
}
