import java.util.*;

// T.C - ElogV
class Pair{
    int node;
    int distance;

    Pair(int distance, int node){
        this.distance=distance;
        this.node=node;
    }
}
class Pairs{
    int node;
    int weight;

    Pairs(int node, int weight){
        this.node=node;
        this.weight=weight;
    }
}
public class DijkstraAglo {
    public int[] dijkstra(List<List<Pairs>> adj, int V){
        PriorityQueue<Pair> pq = new PriorityQueue<>((x,y)->x.distance-y.distance);
        pq.offer(new Pair(0,0));
        int[] dis = new int[V];
        Arrays.fill(dis,Integer.MAX_VALUE);
        dis[0]=0;

        while(!pq.isEmpty()){
            Pair p = pq.poll();
            int node = p.node;
            int distance=p.distance;

            for(int i=0;i<adj.get(node).size();i++){
                int adjNode = adj.get(node).get(i).node;
                int weight = adj.get(node).get(i).weight;

                if(distance+weight<dis[adjNode]){
                    dis[adjNode]=distance+weight;
                    pq.offer(new Pair(distance+weight,adjNode));
                }
            }
        }
        return dis;
    }    
}
