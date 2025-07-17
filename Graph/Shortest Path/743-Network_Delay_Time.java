// I am using Dijkstra with Queue. 
// Like Cheapest Fligh with k stops this will also fail if I use PQ
import java.util.*;
class Pair{
    int node;
    int time;

    Pair(int node, int time){
        this.node=node;
        this.time=time;
    }
}
class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        List<List<Pair>> adj = new ArrayList<>();
        ArrayDeque<Pair> q = new ArrayDeque<>();
        int[] cost = new int[n+1];
        Arrays.fill(cost,Integer.MAX_VALUE);
        cost[k] = 0;

        for(int i=0;i<=n;i++)
        adj.add(new ArrayList<>());

        for(int i=0;i<times.length;i++){
            int from = times[i][0];
            int to = times[i][1];
            int timeTaken = times[i][2];

            adj.get(from).add(new Pair(to,timeTaken));
        }
        
        q.offer(new Pair(k,0));

        while(!q.isEmpty()){
            Pair p = q.poll();
            int node = p.node;
            int time = p.time;

            for(Pair pair : adj.get(node)){
                int to = pair.node;
                int timeTo = pair.time;

                if(cost[to]> time+timeTo){
                    cost[to] = time+timeTo;
                    q.offer(new Pair(to,time+timeTo));
                }
            }
        }

        int ans = Integer.MIN_VALUE;
        for(int i=1;i<=n;i++)
        ans = Math.max(ans,cost[i]);

        return ans==Integer.MAX_VALUE?-1:ans;
    }
}