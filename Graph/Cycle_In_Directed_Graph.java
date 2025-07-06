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


    The BSF version where we can find if the a given direcetd graph is cyclic 
    or not is by Khan's Algo. 
    Idea -> Khan's Algorithm is BFS version of topological sort.
    And we know topological sort is applied on DAG. If we apply khan's
    Algo in any directed graph and store the ans in a list.
    If list contains all the vertices it is acyclic, if not then 
    there is a cycle. 

    Course schduler 1 and 2 are based in this idea.

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


// BFS
// Time - O(V+E)
class Solutions {
    public static boolean topoSort(int V, int[][] edges) {
        int[] inDegree = new int[V];
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        ArrayDeque<Integer> q = new ArrayDeque<>();
        
        for(int i=0;i<V;i++)
        adj.add(new ArrayList<>());
        
        for(int i=0;i<edges.length;i++)
        adj.get(edges[i][0]).add(edges[i][1]);
        
        for(int i=0;i<adj.size();i++){
            for(int j=0;j<adj.get(i).size();j++){
                inDegree[adj.get(i).get(j)]++;
            }
        }
        
        for(int i=0;i<V;i++){
            if(inDegree[i]==0)
            q.offer(i);
        }
        
        ArrayList<Integer> ans = new ArrayList<>();
        
        while(!q.isEmpty()){
            int node = q.poll();
            ans.add(node);
            
            for(int it : adj.get(node)){
                inDegree[it]--;
                
                if(inDegree[it]==0)
                q.offer(it);
            }
        }

        if(ans.size()==V)
        return true;
       
        return false;
    }
}