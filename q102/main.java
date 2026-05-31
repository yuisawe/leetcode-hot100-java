package q102;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

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
    private List<List<Integer>> list;
    public List<List<Integer>> levelOrder(TreeNode root) {
        list = new ArrayList<List<Integer>>();

        if(root == null) return list;
        Queue<TreeNode> que = new LinkedList<>();
        que.offer(root);
        while(!que.isEmpty()){
            int size = que.size();
            List<Integer> curList = new ArrayList<>();
            for(int i = 0 ;i < size ; i++){
                TreeNode node = que.poll();
                if(node.left!=null) que.add(node.left);
                if(node.right!=null) que.add(node.right);
                curList.add(node.val);
            }
            list.add(curList);
        }
        return list;

    }
}