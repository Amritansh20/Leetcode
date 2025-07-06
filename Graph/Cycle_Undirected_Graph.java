import java.util.*;
class Solution {

    // DFS
    // time - O(V+E)
    // space - O(m*n)
    public boolean solve(ArrayList<ArrayList<Integer>> adj, int node, int parent,int[] vis){
        vis[node]=1;
        
        for(int adjNode : adj.get(node)){
            if(vis[adjNode]==0){
                if(solve(adj,adjNode,node,vis))
                return true;
            }else if(adjNode != parent){
                return true;
            }
        }
        return false;
    }
    public boolean isCycle(int V, int[][] edges) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        
        for(int i=0;i<V;i++)
        adj.add(new ArrayList<>());
        
        for(int i=0;i<edges.length;i++){
            int u=edges[i][0];
            int v=edges[i][1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        
        int[] vis = new int[V];
        
        for(int i=0;i<V;i++){
            if(vis[i]==0){
                if(solve(adj,i,-1,vis))
                return true;
            }
        }
        
        
        return false;
        
    }
}




// BFS
class Pair{
    int node;
    int parent;
    
    Pair(int node, int parent){
        this.node=node;
        this.parent=parent;
    }
}
class Solutions {
    public boolean isCycle(int V, int[][] edges) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        ArrayDeque<Pair> q = new ArrayDeque<>();
        
        for(int i=0;i<V;i++)
        adj.add(new ArrayList<>());
        
        for(int i=0;i<edges.length;i++){
            int u=edges[i][0];
            int v=edges[i][1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        
        int[] vis = new int[V];
        // The outer loop is for components. 

        for(int i=0;i<V;i++){
            if(vis[i]==0){
             vis[i]=1;
             q.offer(new Pair(i,-1));
            
            while(!q.isEmpty()){
            Pair p = q.poll();
            int node = p.node;
            int parent= p.parent;
            
            for(int adjNode:adj.get(node)){
                if(vis[adjNode]==0){
                    vis[adjNode]=1;
                    q.offer(new Pair(adjNode,node));
                }else if(adjNode != parent){
                    return true;
                }
            }
        }

        }
        }
        return false;
    }
}