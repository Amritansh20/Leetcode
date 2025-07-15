import java.util.*;
// Note the process of path construction.
// Keeping parent array
// T.C - E log V + O(n)
class Pair{
    int node;
    int weight;
    
    Pair(int node, int weight){
        this.node=node;
        this.weight=weight;
    }
}

class Solution {
    public List<Integer> shortestPath(int n, int m, int edges[][]) {
        //  Code Here.
        List<List<Pair>> adj = new ArrayList<>();
        PriorityQueue<Pair> pq = new PriorityQueue<>((x,y)->x.weight-y.weight);
        
        for(int i=0;i<=n;i++)
        adj.add(new ArrayList<>());
        
        for(int i=0;i<m;i++){
            adj.get(edges[i][0]).add(new Pair(edges[i][1],edges[i][2]));
            adj.get(edges[i][1]).add(new Pair(edges[i][0],edges[i][2]));
        }
        
        int[] dis = new int[n+1];
        Arrays.fill(dis,Integer.MAX_VALUE);
        dis[1]=0;
        
        int[] parent = new int[n+1];
        for(int i=0;i<=n;i++)
        parent[i]=i;
        
        pq.offer(new Pair(1,0));
        while(!pq.isEmpty()){
            Pair p = pq.poll();
            int node = p.node;
            int weight = p.weight;
            
            for(int i=0;i<adj.get(node).size();i++){
                Pair pair = adj.get(node).get(i);
                int adjNode = pair.node;
                int adjWeight = pair.weight;
                
                if(weight+adjWeight<dis[adjNode]){
                    dis[adjNode]=adjWeight+weight;
                    parent[adjNode] = node;
                    pq.offer(new Pair(adjNode,adjWeight+weight));
                }
            }
        }

        for(int i=1;i<=n;i++){
            if(dis[i]==Integer.MAX_VALUE)
            dis[i]=-1;
        }
        
        List<Integer> ans = new ArrayList<>();
        int node = n;
        
        while(node!=parent[node]){
            ans.add(node);
            node = parent[node];
        }
        ans.add(1);
        Collections.reverse(ans);
        return dis[n];
    }
}