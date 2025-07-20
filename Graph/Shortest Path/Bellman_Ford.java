/*
    Bellman is used to find the shortest distance from source to 
    all nodes or any particular destination.

    It is applicable only in Directed Graph unlike Dijkstra

    Note:
    Here edges are given in any order and that is the exact reason
    we have to relax N-1 times
    
    Cosider:
        dis[from] + weight < dis[to]

        Since the edges are not in any order. It is possible
        that dis[from] is still MAX. 
        If this is the case we cannot move ahead. 
        We will come again later if it is calculated by some other node
        This is the reason we we N-1 iterations

    T.C - O(V*E)
    S.C - O(V)

 */
import java.util.*;
class Solution {
    public int[] bellmanFord(int V, int[][] edges, int src) {
        int[] dis = new int[V];
        Arrays.fill(dis,100000000);
        dis[src] = 0;
        
        for(int i=0;i<V-1;i++){
            for(int j=0;j<edges.length;j++){
                int from =edges[j][0];
                int to = edges[j][1];
                int weight = edges[j][2];
                
                if(dis[from]!=100000000 && dis[from]+weight<dis[to]){
                    dis[to] = dis[from]+weight;
                }
            }
        }
        
        // Negative cycle check
        
        for(int i=0;i<edges.length;i++){
            int from =edges[i][0];
                int to = edges[i][1];
                int weight = edges[i][2];
                
                if(dis[from]!=100000000 && dis[from]+weight<dis[to]){
                   int[] temp = new int[1];
                   temp[0]=-1;
                   return temp;
                }
        }
        return dis;
        
    }
}
