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
    public void solve(TreeNode root, List<Integer> ds, List<String> ans){
        if(root==null)
        return;

        if(root.left==null && root.right==null){
            ds.add(root.val);
            StringBuilder str = new StringBuilder();
            for(int i=0;i<ds.size();i++){
                str.append(ds.get(i));
                if(i<ds.size()-1)
                str.append("->");
            }
            ans.add(str.toString());
            ds.remove(ds.size()-1);
            return;
        }

        ds.add(root.val);
        if(root.left!=null)
        solve(root.left,ds,ans);

        if(root.right!=null)
        solve(root.right,ds,ans);
       
        ds.remove(ds.size()-1);  
    }
    public List<String> binaryTreePaths(TreeNode root) {
        List<Integer> ds = new ArrayList<>();
        List<String> ans = new ArrayList<>();
        solve(root,ds,ans);
        return ans;
    }
}