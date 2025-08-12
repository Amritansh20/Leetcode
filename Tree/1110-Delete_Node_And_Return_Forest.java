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
    public void solve(TreeNode parent, TreeNode node, Set<Integer> set, Map<Integer,TreeNode> res, boolean isLeft){
        
        if(node==null)
        return;

        solve(node,node.left,set,res,true);
        solve(node,node.right,set,res,false);

        if(set.contains(node.val)){
            res.remove(node.val);

            if(parent!=null){
                if(isLeft){
                    parent.left=null;
                }else{
                    parent.right=null;
                }
            }

            if(node.left!=null)
            res.put(node.left.val,node.left);

            if(node.right!=null)
            res.put(node.right.val,node.right);
        }
    }
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        Map<Integer,TreeNode> res = new HashMap<>();
        res.put(root.val,root);
        Set<Integer> set = new HashSet<>();
        
        for(int i=0;i<to_delete.length;i++)
        set.add(to_delete[i]);

        solve(null,root,set,res,false);
        List<TreeNode> ans = new ArrayList<>();

        for(TreeNode node : res.values()){
            ans.add(node);
        }
        return ans;
    }
}