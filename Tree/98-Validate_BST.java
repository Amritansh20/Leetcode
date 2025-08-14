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
    public boolean solve(TreeNode root, int min, int max){
        if(root==null)
        return true;

        if(root.val<=min || root.val>=max)
        return false;

        boolean left =solve(root.left,min,root.val);
        boolean right=solve(root.right,root.val,max);

        return left && right;
    }
    public boolean isValidBST(TreeNode root) {
        int min = Integer.MIN_VALUE;
        int max = Integer.MAX_VALUE;
        return solve(root,min,max);
    }
}