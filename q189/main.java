package q189;
class main{
    public static void main(String[] args) {
        int[] nums={-1,-100,3,99}; 
        new Solution().rotate(nums, 2);
    }
}
class Solution {
    public void rotate(int[] nums, int k) {
        // int[] arr = new int[nums.length];
        // for(int i = 0 ; i < nums.length ;i ++){
        //     arr[(i+k) % nums.length] = nums[i];
        // }
        // for(int i = 0 ;i < nums.length;i++){
        //     nums[i] = arr[i];
        // }
        int n = nums.length;
        int cnt = 0;
        int start = 0;
        int startNum = nums[start];
        while(cnt < n){
            int target = (start + k) % n;
            int temp = nums[target];
            nums[target] = startNum;
            startNum = temp;
            start = target;
            cnt++;
        }
    }
}