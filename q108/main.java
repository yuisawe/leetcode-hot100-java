package q108;

public class main {
    
}
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
class Solution {
    private int[] nums;
    public TreeNode sortedArrayToBST(int[] nums) {
        this.nums = nums;
        // 每次选取数组的中间节点作为根节点
        if(nums.length == 0) return null;
        int mid = (0 + nums.length - 1) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = insert(0,mid-1);
        root.right = insert(mid + 1 , nums.length-1);
        return root;
    }
    private TreeNode insert(int start , int end){
        if(start > end || start < 0 || end >= nums.length) return null;
        int mid = (start + end) / 2 ;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = insert(start, mid-1);
        root.right = insert(mid+1, end);
        return root;
    }

}