/*
    Algorithm Check - Dijkstra
    Here instead of PriorityQueue I am using a Queue? 
    Why? 
    In order to understand this We should know why we use PriorityQueue in Dikstra in 
    first place? Dijksta can be implemented using a Queue and Set with Set being fastest.

    Priority Queue Limits the exploration of costier edges by not offering that path
    in queue.
    And while polling from PriorityQueue If i reach my destination then 
    I am sure that it will be the cheapest path to destination. 
    In order to achieve this we place a condition in the while loop.

    But if there is another path to destination via another node AND the in between node 
    has found its lower cost and now it's expensive. I will not be able to explore
    that path even if this path gives more cheaper cost to destination.

    In order to understand this use test case
   
    n=5, k=2, src =0, dest = 2
    [[0,1,5],[1,2,5],[0,3,2],[3,1,2],[1,4,1],[4,2,1]]

    Apply dijkstra using Priority Queue and then Queue. you can understand the difference.

    Use PriorityQueue when: 
    1-The graph has non-uniform weights
    2-You're minimizing total cost/distance
    3-You need greedy behavior: always expand cheapest next

    Use Queue when:
    1-All edge weights are equal (e.g. 0-1 or uniform)
    2-You want minimum number of hops/edges
    3-You need layered traversal (like levels of stops)
    4-You have K steps/stops constraint
 */
import java.util.*;
class Pair{
    int to;
    int cost;

    Pair(int to, int cost){
        this.to=to;
        this.cost=cost;
    }

}

class Touple{
    int node;
    int price;
    int stops;

    Touple(int node, int price, int stops){
        this.node = node;
        this.price=price;
        this.stops = stops;
    }
}
class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<List<Pair>> adj = new ArrayList<>();
        ArrayDeque<Touple> q = new ArrayDeque<>();
        q.offer(new Touple(src,0,0));

        int[] cost = new int[n];
        Arrays.fill(cost,Integer.MAX_VALUE);
        cost[src]=0;


        for(int i=0;i<n;i++)
        adj.add(new ArrayList<>());

        for(int i=0;i<flights.length;i++){
            int from = flights[i][0];
            int to = flights[i][1];
            int amount = flights[i][2];

            adj.get(from).add(new Pair(to,amount));
        }

        while(!q.isEmpty()){
            Touple t = q.poll();
            int node = t.node;
            int price = t.price;
            int stops = t.stops;

            if(stops>k)
            continue;

            for(int i=0;i<adj.get(node).size();i++){
                int to = adj.get(node).get(i).to;
                int cost_to = adj.get(node).get(i).cost;

                if(cost[to]>price+cost_to && stops<=k){
                    cost[to]=price+cost_to;
                    q.offer(new Touple(to,price+cost_to,stops+1));
                }
            }
        }
        return cost[dst]==Integer.MAX_VALUE? -1 : cost[dst];
    }
}