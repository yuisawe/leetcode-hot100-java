package q238;
class main{
    public static void main(String[] args) {
        
    }
}
class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] ans = new int[nums.length];
        int[] pre = new int[nums.length];
        int[] next = new int[nums.length];
        pre[0] = 1;
        next[nums.length-1] = 1;
        for(int i = 1 ;i < nums.length ; i++){
            pre[i] = nums[i-1] * pre[i-1];
        }
        for(int i = nums.length-2 ; i>=0;i--){
            next[i] = nums[i+1] * next[i+1];
        }
        for(int i = 0 ; i< nums.length;i++){
            ans[i] = pre[i] * next[i];
        }
        return ans;
    }
}