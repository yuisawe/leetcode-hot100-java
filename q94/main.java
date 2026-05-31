package q94;

import java.util.ArrayList;
import java.util.List;

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
    List<Integer> list;
    public List<Integer> inorderTraversal(TreeNode root) {
        list = new ArrayList<>();
        order(root);
        return list;
    }
    public void order(TreeNode root){
        if(root == null) return ;
        order(root.left);
        list.add(root.val);
        order(root.right);
    }
}