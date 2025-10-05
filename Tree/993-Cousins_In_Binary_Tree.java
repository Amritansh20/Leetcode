import java.util.*;
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
    public boolean isCousins(TreeNode root, int x, int y) {
        ArrayDeque<TreeNode> q = new ArrayDeque<>();
        q.offer(root);
        

        while(!q.isEmpty()){
            int size = q.size();
            boolean foundX = false;
            boolean foundY = false;
            for(int i=0;i<size;i++){
                TreeNode node = q.poll();

                if(node.left!=null && node.right!=null){
                    if(node.left.val==x && node.right.val==y)
                    return false;

                    if(node.left.val==y && node.right.val==x)
                    return false;
                }

                if(node.left!=null){
                    q.offer(node.left);
                    if(node.left.val ==x)
                    foundX=true;

                    if(node.left.val ==y)
                    foundY=true;
                }

                if(node.right!=null){
                    q.offer(node.right);
                    if(node.right.val ==x)
                    foundX=true;

                    if(node.right.val ==y)
                    foundY=true;
                }
            }

            if(foundX && foundY)
            return true;
            else{
                foundX=false;
                foundY=false;
            }
        }
        return false;
    }
}