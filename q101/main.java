package q101;
public class main {

    
}
class Solution {
    public boolean isSymmetric(TreeNode root) {
        return root==null || isSymmetric(root.left,root.right);
    }
    public boolean isSymmetric(TreeNode root1 , TreeNode root2) {
        if(root1 == null) return root2 == null;
        if(root2 == null) return root1 == null;
        return root1.val == root2.val && isSymmetric(root1.left, root2.right)
        && isSymmetric(root1.right, root2.left);

    }
}