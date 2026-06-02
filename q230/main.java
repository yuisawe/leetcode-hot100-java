package q230;

import java.util.Stack;

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
// class Solution {
//     private int ans = -1;
//     private int cnt = 0;
//     private int k;
//     public int kthSmallest(TreeNode root, int k) {
//         this.k = k;
//         inorder(root);
//         return ans;
//     }
//     public void inorder(TreeNode root){
//         if(root == null) return ;
//         inorder(root.left);
//         cnt++;
//         if(cnt == k) ans = root.val;
//         inorder(root.right);
//     }
// }

class Solution {

    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> stk = new Stack<>();
        int cnt = 0;
        while(!stk.isEmpty()||root!=null){
            while(root!=null){
                stk.add(root);
                root = root.left;
            }
            root = stk.pop();
            cnt++;
            if(cnt == k) return root.val;
            root = root.right;
        }
        return -1;
    }

}