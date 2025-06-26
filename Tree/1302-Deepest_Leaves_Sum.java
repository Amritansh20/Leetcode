
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
    // static int maxHeight = Integer.MIN_VALUE;
    
    public static void inorder(TreeNode root, int currHeight, int[] maxSum){
        if(root==null)
        return;
        
      
        if(currHeight==maxSum[0]){
           maxSum[1] += root.val;
        }else if(currHeight>maxSum[0]){
            maxSum[0]=currHeight;
            maxSum[1]=root.val;
        }
       
        inorder(root.left,currHeight+1,maxSum);
        inorder(root.right,currHeight+1,maxSum);
    }
    public int deepestLeavesSum(TreeNode root) {
        int[] maxSum = new int[2];
        inorder(root,0,maxSum);
        return maxSum[1];
    }
}