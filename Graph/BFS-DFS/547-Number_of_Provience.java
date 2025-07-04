/*
    This is basic DFS traversal. 

    Idea -> I pick one node which is not visited and apply dfs on it such that all the 
            connecting nodes will be updated in visited array.

            Every time my one dfs calls gets over. It adds the +1 to the count;

            What every dfs call is doing?
            The purpose of every dfs call is to go through all the connecting nodes and 
            mark it visistd. This becomes one of your provineces.

    T.C - Time to build the adj list is n^2
         and We are going to all nodes and edges exactly once.
         
         In a fully connected graph there could be n*(n-1) edges
         but this is undirectd the worst count be n^2

         Traversasl time is O(n+m) where m cound me n^2

    S.C - O(n^2) for the list
 */

 import java.util.*;
class Solution {
    public void dfs(List<List<Integer>> adj, int[] vis, int node){
        vis[node]=1;

        for(int adjNode :adj.get(node)){
            if(vis[adjNode]==0)
            dfs(adj,vis,adjNode);
        }
    }
    public int findCircleNum(int[][] isConnected) {
        List<List<Integer>> adj = new ArrayList<>();
        
        for(int i=0;i<isConnected.length;i++)
        adj.add(new ArrayList<>());

        for(int i=0;i<isConnected.length;i++){
            for(int j=0;j<isConnected[0].length;j++){
                if(isConnected[i][j]==1){
                    adj.get(i).add(j);
                    adj.get(j).add(i);
                }
               
            }
        }

        int count=0;
        int[] vis = new int[isConnected.length];

        for(int i=0;i<isConnected.length;i++){
           if(vis[i]==0){
            dfs(adj,vis,i);
            count++;
           }
        }
        return count;
    }
}