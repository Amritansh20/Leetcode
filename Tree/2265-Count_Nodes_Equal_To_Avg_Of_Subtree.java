
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
    public static int[] solve(TreeNode root, int[] ans){
        if(root==null)
        return new int[] {0,0};

        int[] left = solve(root.left,ans);
        int[] right = solve(root.right,ans);

        int number = left[1]+right[1]+1;
        int sum = left[0]+right[0]+root.val;

        int avg = sum/number;
        if(avg==root.val)
        ans[0]++;

        return new int[] {sum,number};
    }
    public int averageOfSubtree(TreeNode root) {
        int ans[] = new int[1];
        solve(root,ans);
        return ans[0];
    }
}