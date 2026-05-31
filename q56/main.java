package q56;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class main {
    
}
class Solution {
    public int[][] merge(int[][] intervals) {
        List<int[]> list = new ArrayList<>();
        //按照左端点排序这样可以合并的区间一定是连续的
        Arrays.sort(intervals , (arr1 , arr2)->{
            return arr1[0] - arr2[0];
        });
        int start = intervals[0][0];
        int end = intervals[0][1];
        for(int i = 0 ;i < intervals.length;i++){
            int nowstart = intervals[i][0];
            int nowend = intervals[i][1];
            if(nowstart<=end){
                end = Math.max(nowend, end);
                
            }else{
                list.add(new int[]{start,end});
                start = nowstart;
                end = nowend;
            }
            if(i == intervals.length-1){
                    list.add(new int[]{start,end});
            }
            
        }
        return list.toArray(new int[list.size()][]);
        
    }
}