import java.util.*;

// Time - O(n)
// Space - O(n)
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
class Solutions {
    public void flatten(TreeNode root) {
        if(root==null)
        return;
        
        ArrayDeque<TreeNode> stack = new ArrayDeque<>();
        stack.push(root);

        while(!stack.isEmpty()){
            TreeNode curr = stack.pop();

            if(curr.right!=null)
            stack.push(curr.right);

            if(curr.left!=null)
            stack.push(curr.left);

            curr.right=stack.peek();
            curr.left=null;
        }
    }
}


// Morris order like traversal
//T.C - O(n)
// S.C - O(1)

class Solution {
    public void flatten(TreeNode root) {
        TreeNode current = root;

        while(current!=null){
            

            if(current.left!=null){
                TreeNode lastRight = current.left;

                while(lastRight.right!=null){
                    lastRight = lastRight.right;
                }

                lastRight.right=current.right;
                current.right=current.left;
                current.left=null;
            }
            current=current.right;
        }
    }
}