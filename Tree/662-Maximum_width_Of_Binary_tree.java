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
class Pair{
    TreeNode node;
    int index;

    Pair(TreeNode node, int index){
        this.node = node;
        this.index=index;
    }
}
class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        ArrayDeque<Pair> q = new ArrayDeque<>();
        q.offer(new Pair(root,0));
        int maxWidth = Integer.MIN_VALUE;

        while(!q.isEmpty()){
            int size = q.size();
            int startIndexPerLevel = q.peek().index;

            for(int i=0;i<size;i++){
                Pair p = q.poll();
                TreeNode node = p.node;
                int index = p.index;

                if(i==size-1)
                maxWidth = Math.max(maxWidth,index-startIndexPerLevel);

                if(node.left!=null)
                q.offer(new Pair(node.left,2*index+1));

                if(node.right!=null)
                q.offer(new Pair(node.right,2*index+2));
            }
        } 
        return maxWidth+1;
    }
}