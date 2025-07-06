import java.util.*;
class Solution {
    public static void dfs(ArrayList<ArrayList<Integer>> adj, int node, int[] vis, ArrayDeque<Integer> stack){
        vis[node]=1;
        
        for(int it : adj.get(node)){
            if(vis[it]==0){
                dfs(adj,it,vis,stack);
            }
        }
        stack.push(node);
    }
    public static ArrayList<Integer> topoSort(int V, int[][] edges) {
        // code here
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        int[] vis=new int[V];
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        
        for(int i=0;i<V;i++)
        adj.add(new ArrayList<>());
        
        for(int i=0;i<edges.length;i++)
        adj.get(edges[i][0]).add(edges[i][1]);
        
        for(int i=0;i<V;i++){
            if(vis[i]==0){
                dfs(adj,i,vis,stack);
            }
        }
        
        ArrayList<Integer> ans = new ArrayList<>();
        
        while(!stack.isEmpty()){
            ans.add(stack.pop());
        }
        return ans;
    }
}