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
import java.util.*;
class Solution {
    public int solve(TreeNode root, Map<TreeNode,Integer> dp){
        if(root==null)
        return 0;

        if(dp.containsKey(root))
        return dp.get(root);

        int take = root.val;
        if(root.left!=null){
            take+= solve(root.left.left,dp);
            take+= solve(root.left.right,dp);
        }

        if(root.right!=null){
            take+= solve(root.right.left,dp);
            take+= solve(root.right.right,dp);
        }

        int not_take = solve(root.left,dp) + solve(root.right,dp);
        int res = Math.max(take,not_take);
        dp.put(root,res);
        return res;
    }
    public int rob(TreeNode root) {
        Map<TreeNode,Integer> dp = new HashMap<>();
        return solve(root,dp);
    }
}