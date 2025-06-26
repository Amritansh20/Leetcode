import java.util.*;

//  Definition for a binary tree node.
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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        
        if(root==null)
        return ans;
        
        ArrayDeque<TreeNode> q = new ArrayDeque<>();
        q.offer(root);
        boolean leftToRight =true;

        while(q.isEmpty()!=true){
            int size = q.size();
            List<Integer> level = new ArrayList<>(size);

            for(int i=0;i<size;i++){
                TreeNode node = q.peek();
                q.poll();

                if(leftToRight==true)
                level.add(node.val);
                else
                level.add(0,node.val);

                if(node.left!=null)
                q.offer(node.left);
                if(node.right!=null)
                q.offer(node.right);
            }
            if(leftToRight==true)
            leftToRight = false;
            else{
                leftToRight=true;
            }
            ans.add(level);
        }
        return ans;
    }
}