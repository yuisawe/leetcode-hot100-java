package q11;

public class main {
    
}
class Solution {
    public int maxArea(int[] height) {
        //移动左右指针中，指的高度更小的那个，
        // 因为如果移动更大的那个，面积不会增大，
        // 所以答案就是当前面积与移动较小指针后的最大面积中的较大者
        int l = 0 ;
        int r = height.length - 1;
        int maxArea = 0;
        while(l < r){
            int area = (r - l) * Math.min(height[r] , height[l]);
            if(height[l] < height[r]){
                l++;
            }else{
                r--;
            }
            maxArea = Math.max(maxArea, area);
        }
        return maxArea;
    }
}