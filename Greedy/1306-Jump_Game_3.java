//Plain BFS
import java.util.*;
class Solution {
    public boolean canReach(int[] nums, int start) {
        int n = nums.length;
        ArrayDeque<Integer> q = new ArrayDeque<>();
        q.offer(start);
        int[] vis = new int[n];

        while(!q.isEmpty()){
            int currIndex = q.poll();
            
            if(nums[currIndex]==0)
            return true;

            if(currIndex+nums[currIndex]<n && vis[currIndex+nums[currIndex]]==0){
                q.offer(currIndex+nums[currIndex]);
                vis[currIndex+nums[currIndex]]=1;
            }
            
            if(currIndex-nums[currIndex]>=0 && vis[currIndex-nums[currIndex]]==0){
                q.offer(currIndex-nums[currIndex]);
                vis[currIndex-nums[currIndex]]=1;
            }
        }
        return false;
    }
}