package MST;

// T.C - ElogV
/*
    If there is a weighted graph with N nodes any number of edges. 
    If we can break that graph such that there are N nodes and 
    exactly N-1 edges and all the nodes are reachable from each node.
    Then this is called a spanning tree.
   
    We can make more than ons spanning tree and the one with minimum 
    weight is called Minimum spanning tree.
 */
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


// In case we need the MST and not only weight of MST

class Touple{
    int node;
    int weight;
    int parent;

    Touple(int node, int weight,int parent){
        this.node=node;
        this.weight=weight;
        this.parent=parent;
    }
}

class Solutions{
    public static List<List<Integer>> spanningTree(int V, int E, List<List<int[]>> adj){
        int[] vis = new int[V];
        PriorityQueue<Touple> pq = new PriorityQueue<>((a,b)->a.weight-b.weight);
        pq.offer(new Touple(0,0,-1));
        List<List<Integer>> ans = new ArrayList<>();
        int mst=0;
        while(!pq.isEmpty()){
            Touple t = pq.poll();
            int node =t.node;
            int weight=t.weight;
            int parent = t.parent;

            if(vis[node]==1)
            continue;

            vis[node]=1;
            mst+=weight;
            
            if(parent!=-1){
            List<Integer> list = new ArrayList<>();
            list.add(parent);
            list.add(node);
            ans.add(new ArrayList<>(list));
            }

            for(int i=0;i<adj.get(node).size();i++){
                int to = adj.get(node).get(i)[0];
                int value = adj.get(node).get(i)[1];
                pq.offer(new Touple(to, value, node));
            }
        }
        return ans;
    }
}

