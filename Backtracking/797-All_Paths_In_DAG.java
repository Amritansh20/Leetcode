/*
    In a DAG, number of possible paths from 0-(n-1) is 2^(n-2) (Remember this)
    For each path I am taking L time to construct.

    T.C - O(2^n-2 * L)

 */
import java.util.*;
class Solution {
    public void solve(int[][] graph,List<Integer> ds, List<List<Integer>> ans, int node){
        if(node == graph.length-1){
            ds.add(node);
            ans.add(new ArrayList<>(ds));
            ds.remove(ds.size()-1);
            return;
        }

        for(int i=0;i<graph[node].length;i++){
            ds.add(node);
            solve(graph,ds,ans,graph[node][i]);
            ds.remove(ds.size()-1);
        }
    }
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<Integer> ds = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();

        solve(graph,ds,ans,0);
        return ans;
    }
}