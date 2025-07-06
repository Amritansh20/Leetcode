/*
    A non cyclic graph will alwaays be an bipartite.
    A cyclic graph with even number of nodes will be bipartite.

    A cyclic graph with odd number of nodes can be bipartite. 
 */
import java.util.*;
class Solution {
    public boolean solve(List<List<Integer>> adj, int node, int[] vis, int color){
        vis[node]=color;

        for(int it : adj.get(node)){
           if(vis[it]==-1){
            if(solve(adj,it,vis,1-color)==false)
            return false;
           }else if(vis[it]==color)
           return false;
        }
        return true;
    }
    public boolean isBipartite(int[][] graph) {
        List<List<Integer>> adj = new ArrayList<>();
        
        for(int i=0;i<graph.length;i++)
        adj.add(new ArrayList<>());

        for(int i=0;i<graph.length;i++){
            for(int j=0;j<graph[i].length;j++)
            adj.get(i).add(graph[i][j]);
        }

        int[] vis = new int[graph.length];
        Arrays.fill(vis,-1);
        for(int i=0;i<graph.length;i++){
            if(vis[i]==-1){
                if(solve(adj,i,vis,1)==false)
                return false;
            }
        }
        return true;
    }
}