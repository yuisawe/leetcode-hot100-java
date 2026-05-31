package q42;

public class main {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
        s.trap(height);
    }
}
class Solution {
    public int trap(int[] height) {
        // 位置i处的节水量等于min(l[i],r[i]) - h[i]
        // 如果上述值小于等于0，代表该处接不了水
        int[] l = new int[height.length];
        int[] r = new int[height.length];
        int[] total = new int[height.length];
        l[0] = height[0];
        r[height.length-1] = height[height.length-1];
        for(int i = 1 ; i < height.length;i++){
            l[i] = Math.max(l[i-1] , height[i]);
        }

        for(int i = height.length - 2 ; i >=0 ;i--){
            r[i] = Math.max(r[i+1] , height[i]);
        }

        for (int i = 0; i < total.length; i++) {
            total[i] = (Math.min(l[i],r[i]) - height[i]) <=0 ? 0 : Math.min(l[i],r[i]) - height[i];
        }
        int sum = 0;
        for (int i = 0; i < total.length; i++) {
            sum += total[i];
        }
        // 0 0 1 0 1 2 1 0 0 1 0 0
        return sum;
    }
}