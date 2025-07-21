package MST;
/*
    Time - 
    Traverse edges - O(V+E)
    Sorting - ElogE
    last loop - O(N);

    Disjoint is giving us results in O(4 delta) == O(1);
 */
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Disjoint{
    List<Integer> parent = new ArrayList<>();
    List<Integer> size = new ArrayList<>();

    Disjoint(int n){
        for(int i=0;i<n;i++){
            parent.add(i);
            size.add(1);
        }
    }

    public int findUParent(int node){
        if(node==parent.get(node))
        return node;

        int ulp = findUParent(parent.get(node));
        parent.set(node, ulp);
        return ulp;
    }

    public void unionBySize(int u, int v){
        int ulp_u = findUParent(u);
        int ulp_v = findUParent(v);

        if(ulp_u==ulp_v)
        return;
        
        if (size.get(ulp_u) < size.get(ulp_v)) {
            parent.set(ulp_u, ulp_v);
            size.set(ulp_v, size.get(ulp_v) + size.get(ulp_u));
        } else {
            parent.set(ulp_v, ulp_u);
            size.set(ulp_u, size.get(ulp_u) + size.get(ulp_v));
        }
    }
}

class Edge implements Comparable<Edge>{

    int src;
    int dest;
    int weight;

    Edge(int src, int dest, int weight){
        this.src = src;
        this.dest=dest;
        this.weight=weight;
    }
    @Override
    public int compareTo(Edge currentEdge) {
        return this.weight- currentEdge.weight;
    }
    
}
public class Kruskal {
    public int spanningTree(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj){
        List<Edge> edges = new ArrayList<>();

        for(int i=0;i<V;i++){
            for(int j=0;j<adj.get(i).size();j++){
                int adjNode = adj.get(i).get(j).get(0);
                int weight = adj.get(i).get(j).get(1);
                int node = i;
                Edge edge = new Edge(node, adjNode, weight);
                edges.add(edge);
            }
        }
        Disjoint ds = new Disjoint(V);
        Collections.sort(edges);
        int mst=0;

        for(int i=0;i<edges.size();i++){
            int weight = edges.get(i).weight;
            int u = edges.get(i).src;
            int v =  edges.get(i).dest;

            if(ds.findUParent(u)!= ds.findUParent(v)){
                mst += weight;
                ds.unionBySize(u, v);
            }
        }
        return mst;
    }
}
