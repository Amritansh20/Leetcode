import java.util.*;

// DFS

/*
    Time Complexity:
    1-Building adj list - O(E) Going to all edges.
    2-DFS - Travelling to each edges and marking nodes visted O(V+E)
    Total - O(V+E)

    Space:
    adj list - O(V+E)
    vis array - O(V)
    stack - O(V)
    ans list - O(V)

    
 */
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


// BFS - Khan's Algorithm

/*
    Time- 
    Making ajd list: We are pricessing each edge - O(E)

    Calculating inDegrees - For each node I am travelling it's adjacent
    node. since it's directed graph total travelling will be equal to
    number of edges. O(E)

    Initializing the Queue -  O(V)

    Processing Queue-
    Each node is enqued atleast once and we are exploring it's edges
    So O(V+E)

    Overall - O(V+E)

    Space- 
    Creating adj list -
    We create V list and each edge is stored exactly once in list
    So, O(V+E)

    Creating inDegree - O(V)

    Queue - At worst all vertices preset - O(V)

    Answer list -  O(V)

    total - O(V+E)+ O(V) + O(V) + O(V)
 */

class Solutions {
    public static ArrayList<Integer> topoSort(int V, int[][] edges) {
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
        return ans;
    }
}