
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
    public static int[] solve(TreeNode root, int parent, int gParent, int[] sum){
        if(root==null)
        return new int[] {0};

        if(gParent%2==0){
            sum[0]+= root.val;
        }

        gParent = parent;
        parent=root.val;

        solve(root.left,parent,gParent,sum);
        solve(root.right,parent,gParent,sum);
        return sum;
    }
    public int sumEvenGrandparent(TreeNode root) {
        int sum[] = new int[1];
        solve(root,-1,-1, sum);
        return sum[0];
    }
}