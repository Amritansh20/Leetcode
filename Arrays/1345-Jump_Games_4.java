package Arrays;

// Time - O(n) for both map generation and BFS

import java.util.*;
class Solution {
    public int minJumps(int[] arr) {
        int n = arr.length;
        Map<Integer,List<Integer>> map = new HashMap<>();
        int[] vis = new int[n];
        ArrayDeque<Integer> q = new ArrayDeque<>();

        q.offer(0);
        vis[0]=1;

        int jumps=0;
        for(int i=0;i<arr.length;i++){
        map.putIfAbsent(arr[i],new ArrayList<>());
        map.get(arr[i]).add(i);
        }

        while(!q.isEmpty()){
            int size = q.size();

            for(int i=0;i<size;i++){
                int currIndex = q.poll();

                if(currIndex==n-1)
                return jumps;

                if(currIndex-1>=0 && vis[currIndex-1]==0){
                    q.offer(currIndex-1);
                    vis[currIndex-1]=1;
                }

                if(currIndex+1<n && vis[currIndex+1]==0){
                    q.offer(currIndex+1);
                    vis[currIndex+1]=1;
                }

                if(map.containsKey(arr[currIndex])){
                    List<Integer> list = new ArrayList<>();
                    list = map.get(arr[currIndex]);

                    for(int num : list){
                       if(vis[num]==0){
                        q.offer(num);
                        vis[num]=1;
                       }
                    }
                    map.remove(arr[currIndex]);
                }
            }
            jumps++;

        }
        return jumps;
    }
}