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
    public static void reversePreOrder(TreeNode root, int level, ArrayList<Integer> list){
        if(root==null)
        return;

        if(list.size()==level)
        list.add(root.val);

        reversePreOrder(root.right,level+1,list);
        reversePreOrder(root.left,level+1,list);
    }
    public List<Integer> rightSideView(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
         reversePreOrder(root,0,list);
         return list;
    }
}