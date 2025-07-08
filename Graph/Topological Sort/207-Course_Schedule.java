/*
    Hint -> [a,b] - In order to complete a we need to finish b. 
                    This seems like direcetd graph.
    
            We need to check weather we can finish all courses or not?
            Isn't we did something like this when we checked Cycle in Directed graph
            by Khan'a Algo or DFS. 

            If we are able to store all the nodes then it's possbible.
            If not, then there is a cycle. 
            Here we can apply the same idea. 

    T.C - O(V+E)
    S.C - O(V)
*/

import java.util.*;
class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
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

        return ans.size()==numCourses;
    }
}