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

// Serialize - We are storing the tree in the format of input. level wise
// wih , and # for null. I have used Linked list implementation of Queue
// because it allows null values.

// Deserialize - It's mostly the construction. there is not much logic here.
class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null)
            return "";

        Queue<TreeNode> q = new LinkedList<>();
        StringBuilder str = new StringBuilder();
        q.offer(root);

        while (!q.isEmpty()) {
            TreeNode node = q.poll();

            if (node == null) {
                str.append("#,");
            } else {
                str.append(node.val).append(",");
                q.offer(node.left);
                q.offer(node.right);
            }
        }
        return str.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.length() == 0)
            return null;

        StringBuilder str = new StringBuilder(data);
        ArrayDeque<TreeNode> q = new ArrayDeque<>();
        
        int index = str.indexOf(",");
        String s = str.substring(0,index);
        str.delete(0,index+1);

        TreeNode root = new TreeNode(Integer.valueOf(s));
        q.offer(root);

        while(!q.isEmpty()){
            TreeNode node = q.poll();

            index = str.indexOf(",");
            s = str.substring(0,index);
            str.delete(0,index+1);

            if(!s.equals("#")){
                TreeNode leftChild = new TreeNode(Integer.valueOf(s));
                node.left=leftChild;
                q.offer(leftChild);   
            }

            index = str.indexOf(",");
            s = str.substring(0,index);
            str.delete(0,index+1);

            if(!s.equals("#")){
                TreeNode rightChild = new TreeNode(Integer.valueOf(s));
                node.right=rightChild;
                q.offer(rightChild);   
            }
        }
        return root;
    }
}