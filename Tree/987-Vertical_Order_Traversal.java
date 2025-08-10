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
class Touple{
    int level;
    int line;
    TreeNode node;

    Touple(TreeNode node,int level, int line){
        this.node = node;
        this.level=level;
        this.line=line;
    }
}
class Solution {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        
        if(root==null)
        return ans;

        ArrayDeque<Touple> q = new ArrayDeque<>();
        TreeMap<Integer,TreeMap<Integer,PriorityQueue<Integer>>> map = new TreeMap<>();

        q.offer(new Touple(root,0,0));

        while(!q.isEmpty()){
            Touple touple = q.poll();
            TreeNode node = touple.node;
            int line = touple.line;
            int level = touple.level;

            if(!map.containsKey(line))
            map.put(line,new TreeMap<>());

            if(!map.get(line).containsKey(level))
            map.get(line).put(level, new PriorityQueue<>());

            map.get(line).get(level).add(node.val);

            if(node.left!=null)
            q.offer(new Touple(node.left,level+1,line-1));

            if(node.right!=null)
            q.offer(new Touple(node.right,level+1,line+1));
        }

        for(Map<Integer,PriorityQueue<Integer>> innerMap: map.values()){
            List<Integer> verticalLevel = new ArrayList<>();
            for(PriorityQueue<Integer> pq : innerMap.values()){
                while(!pq.isEmpty()){
                    verticalLevel.add(pq.poll());
                }
            }
            ans.add(verticalLevel);
        }
        return ans;
    }
}