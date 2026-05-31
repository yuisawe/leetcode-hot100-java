package q543;

public class main {
    
}
class Solution {
    public int diameterOfBinaryTree(TreeNode root) {
        ans = 0;
        if(root == null) return 0;
        return Math.max(dept(root.left) + dept(root.right),ans);
    }
    private int dept(TreeNode root){
        if(root == null) return 0;
        int l = dept(root.left);
        int r = dept(root.right);
        ans = Math.max(l + r , ans);
        return Math.max(l,r) + 1;
    }
    private int ans;
}