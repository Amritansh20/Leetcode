// Extension of course Schdeluer 1- Minor change in return statement.
import java.util.*;

class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
          List<List<Integer>> adj = new ArrayList<>();
        int[] inDegree = new int[numCourses];
        ArrayDeque<Integer> q = new ArrayDeque<>();

        for(int i=0;i<numCourses;i++)
        adj.add(new ArrayList<>());

        for(int i=0;i<prerequisites.length;i++){
            int from = prerequisites[i][1];
            int to = prerequisites[i][0];
            adj.get(from).add(to);

            inDegree[to]++;
        }

        for(int i=0;i<numCourses;i++){
            if(inDegree[i]==0)
            q.offer(i);
        }

        List<Integer> ans = new ArrayList<>();
        while(!q.isEmpty()){
            int node = q.poll();
            ans.add(node);

            for(int it : adj.get(node)){
                inDegree[it]--;

                if(inDegree[it]==0)
                q.offer(it);
            }
        }
        
        if(ans.size()==numCourses)
        return ans.stream().mapToInt(i->i.intValue()).toArray();
        else 
        return new int[0];
    }
}