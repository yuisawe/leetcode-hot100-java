package q283;

public class main {
    public static void main(String[] args) {
        int[] nums = {0,1,0,3,12};
        Solution s = new Solution();
        s.moveZeroes(nums);
        System.out.println(nums);
    }
}
class Solution {
    public void moveZeroes(int[] nums) {
        //双指针
        //左指针指向不含0的序列的尾部 ， 右指针指向待判断的数字
        int lp = -1 ; 
        int rp = 0;
        while(rp < nums.length){
            if(nums[rp] != 0) {
                swap(nums, ++lp, rp);
            }
            rp++;
        }

    }
    private void swap(int[] nums , int left , int right){
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }
}