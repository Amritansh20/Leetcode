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
   
    public static int maxSum(TreeNode root, int[] maxValue){
        if(root==null)
        return 0;

        int leftSum = Math.max(0,maxSum(root.left,maxValue));
        int rightSum = Math.max(0,maxSum(root.right,maxValue));
        maxValue[0] = Math.max(maxValue[0],root.val+leftSum+rightSum);
        return root.val+ Math.max(leftSum,rightSum);
    } 
    public int maxPathSum(TreeNode root) {
        int maxValue[] = new int[1];
        maxValue[0] = Integer.MIN_VALUE;
        maxSum(root,maxValue);
        return maxValue[0];
    }
}