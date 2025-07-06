import java.util.*;;


/*
    Why we are unmarking path vis?
    Beacause there are multiple way to reach that node. If we don't unmark it, the other won't
    be explored. 
    
    Why we can't apply the logic of undirected graph?
    3->{4,7}
    4->{5}
    7->{5}
    5->{6}

    Draw this directed graph. It is not cyclic but the logic of undirected grapgh will give this as cyclic output.

 */
class Solution {
    public static boolean solve(ArrayList<ArrayList<Integer>> adj, int node, int[] vis, int[] pathVis){
        vis[node]=1;
        pathVis[node]=1;
        
        for(int it : adj.get(node)){
            if(vis[it]==0){
                if(solve(adj,it,vis,pathVis))
                return true;
            }else if(pathVis[it]==1){
                return true;
            }
        }
        pathVis[node]=0;
        return false;
    }
    public boolean isCyclic(int V, int[][] edges) {
        int[] vis = new int[V];
        int[] pathVis = new int[V];
        
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        
        for(int i=0;i<V;i++)
        adj.add(new ArrayList<>());
        
        for(int i=0;i<edges.length;i++)
        adj.get(edges[i][0]).add(edges[i][1]);
        
        for(int i=0;i<V;i++){
            if(vis[i]==0){
                if(solve(adj,i,vis,pathVis))
                return true;
            }
        }
        return false;
    }
}