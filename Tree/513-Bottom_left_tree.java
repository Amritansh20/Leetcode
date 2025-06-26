/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public static void solve(TreeNode root,int currHeight, int[] ans){ 
        if(root==null)
        return;

        if(currHeight>ans[0]){
            ans[0]=currHeight;
            ans[1] = root.val;
        }

        solve(root.left,currHeight+1,ans);
        solve(root.right,currHeight+1,ans);

    }
    public int findBottomLeftValue(TreeNode root) {
        int ans[] =new int[2];
        solve(root,1,ans);
        return ans[1];
    }
}