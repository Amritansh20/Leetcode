import java.util.*;

/*
     Step 1 -> Apply Topo sort in given Graph
     Why we are using Topo Sort here?  
     We can use Dijkstra or Bellman but we know it's a DAG and we
     moved to quicker solution.

     We know what liner ordering Topo sort gives us. 
     By the the I process a node "u" we already have the shortest path
     to all it's route that reaches "u". 
     Now we just have to compare weights with curr dis of "u" to get 
     shortest till "u"

     Step 2-> Take the distance array. Mark the source with 0.
     apply BFS and copare weights. 
     
     Now we are checking before traversing to negbours 
     if(dis[node]!= MAX)

     Why? 
     Because based on our assumpotion of Topo sort the shortest dis 
     of this node must be calculated but if it's not. We know
     this node is not reachable. Might be of some other componenet.
     so, we skip this.
 */
class Pair{
    int node;
    int weight;
    
    Pair(int node, int weight){
        this.node = node;
        this.weight=weight;
    }
}
class Solution {
    public void topoSort(List<List<Pair>> adj, int node, int[] vis, ArrayDeque<Integer> stack){
        vis[node]=1;
        
        for(Pair p : adj.get(node)){
            if(vis[p.node]==0){
                topoSort(adj,p.node,vis,stack);
            }
        }
        stack.push(node);
    }
    public int[] shortestPath(int V, int E, int[][] edges) {
        // Code here
        List<List<Pair>> adj = new ArrayList<>();
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        int[] vis = new int[V];
        int[] dis = new int[V];
        Arrays.fill(dis,Integer.MAX_VALUE);
        dis[0]=0;
        
        for(int i=0;i<V;i++)
        adj.add(new ArrayList<>());
        
        for(int i=0;i<E;i++){
            int from = edges[i][0];
            int to = edges[i][1];
            int weight = edges[i][2];
            adj.get(from).add(new Pair(to,weight));
        }
        
        for(int i=0;i<V;i++){
            if(vis[i]==0)
            topoSort(adj,i,vis,stack);
        }
        
     
            while(!stack.isEmpty()){
            int node = stack.poll();
            
            if(dis[node]!=Integer.MAX_VALUE){ // imp condition
                for(Pair p : adj.get(node)){
                if(dis[node]+p.weight< dis[p.node]){
                    dis[p.node]=dis[node]+p.weight;
                }
            }    
            }
            
        }     
        
       
        
        for(int i=0;i<V;i++){
            if(dis[i]==Integer.MAX_VALUE)
            dis[i]=-1;
        } 
        return dis;
    }
}