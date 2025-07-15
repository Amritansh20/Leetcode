import java.util.*;

class Pair{
    int node;
    int distance;
    
    Pair(int node, int distance){
        this.node=node;
        this.distance=distance;
    }
}
class Solution {
    // Function to find the shortest path from a source node to all other nodes
    public int[] shortestPath(ArrayList<ArrayList<Integer>> adj, int src) {
        // code here
        ArrayDeque<Pair> q = new ArrayDeque<>();
        q.offer(new Pair(src,0));
        int[] dis = new int[adj.size()];
        Arrays.fill(dis, Integer.MAX_VALUE);
        dis[src]=0;
        while(!q.isEmpty()){
            Pair p = q.poll();
            int node = p.node;
            int distance = p.distance;
            
            for(int it : adj.get(node)){
                if(dis[it]==Integer.MAX_VALUE){
                    dis[it] = 1+distance;
                    q.offer(new Pair(it,dis[it]));
                }else{
                    dis[it]=Math.min(dis[it],1+distance);
                }
            }
        }
        
        for(int i=0;i<adj.size();i++){
            if(dis[i]==Integer.MAX_VALUE)
            dis[i]=-1;
        }
        return dis;
    }
}
