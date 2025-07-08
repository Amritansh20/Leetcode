/*
    1- We reverse the graph
    2-We calculate inDegree
    3- inDegree of terminal nodes (original graph) will become 0. We push them in queue.
    4-We apply Khan's Algo on reversed graph.

        All the nodes whose in degree becomes zero is safe state. Why?
        All paths leading to a node such that after relaxing the inDegree becomes 0
        means there is no other route "TO" that node.

        It works like a multiple direction chain got open.
        If you start doing brute force on multiple path from inDegree 0 to 
        other nodes which leads to multiple nodes. Only consusion.

    One imp point which can help in visualization-
        Nodes which are safe nodes and not directly connected to terminal nodes
        (Imagine this is reversed graph and by terminal nodes are those from original 
        graph)

        Uss node pe pauchne se pahle all nodes which leads to that node unka inDegree 
        already 0 ho chuka hai which ensures all paths leading to that node.

        This is the node which is safe via other node. 


        Time-O(V+E)
        Space - O(V+E) + O(V) + O(V) + O(V)
 */

 import java.util.*;
class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        List<List<Integer>> revAdj = new ArrayList<>();
        ArrayDeque<Integer> q = new ArrayDeque<>();
        int[] inDegree = new int[graph.length];
        
        for(int i=0;i<graph.length;i++)
        revAdj.add(new ArrayList<>());

        for(int i=0;i<graph.length;i++){
            for(int j=0;j<graph[i].length;j++){
                revAdj.get(graph[i][j]).add(i);
                inDegree[i]++;
            }
        }

        for(int i=0;i<graph.length;i++){
            if(inDegree[i]==0)
            q.offer(i);
        }

        List<Integer> ans = new ArrayList<>();

        while(!q.isEmpty()){
            int node = q.poll();
            ans.add(node);

            for(int it : revAdj.get(node)){
                inDegree[it]--;

                if(inDegree[it]==0)
                q.offer(it);
            }
        }
        Collections.sort(ans);
        return ans;
    }
}