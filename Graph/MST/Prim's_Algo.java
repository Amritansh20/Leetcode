package MST;

import java.util.*;
class Pair{
    int node;
    int weight;
    
    Pair(int node, int weight){
        this.node=node;
        this.weight=weight;
    }
}
class Solution {
    static int spanningTree(int V, int E, List<List<int[]>> adj) {
        // Code Here.
        int[] vis = new int[V];
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)->a.weight-b.weight);
        pq.offer(new Pair(0,0));
        
        int mst=0;
        while(!pq.isEmpty()){
            Pair p = pq.poll();
            int node = p.node;
            int weight = p.weight;
            
            if(vis[node]==1)
            continue;
            
            vis[node]=1;
            mst += weight;
            
            for(int i=0;i<adj.get(node).size();i++){
                int adjNode = adj.get(node).get(i)[0];
                int adjWeight = adj.get(node).get(i)[1];
                pq.offer(new Pair(adjNode,adjWeight));
            }
        }
        return mst;
        
    }
}