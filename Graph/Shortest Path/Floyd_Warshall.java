/*
   Dijkstra and Bellman gives shortest path from source to all other nodes
   whereas floyd gives shortest path from all nodes to all other nodes.
   
   It is multisource shortest Path algo.

   T.C -> O(V^3)
 */

class Solution {
    public void floydWarshall(int[][] dist) {
        // Code here
        int V = dist[0].length;
        for(int via =0;via<V;via++){
            for(int i=0;i<V;i++){
                for(int j=0;j<V;j++){
                    if (dist[i][via] != 100000000 && dist[via][j] != 100000000) {
                        dist[i][j] = Math.min(dist[i][j], dist[i][via] + dist[via][j]);
                    }
                    
                }
            }
        }
    }
}