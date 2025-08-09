/*
    T.C - O(n! * n)
 */
import java.util.*;
class Solution {
    public void solve(int[] nums, List<List<Integer>> ans, List<Integer> ds, int index, int[] vis){

        if(ds.size()==nums.length){
            ans.add(new ArrayList<>(ds));
            return;
        }

        for(int i=0;i<nums.length;i++){
            if(vis[i]==0){
                vis[i]=1;
                ds.add(nums[i]);
                solve(nums,ans,ds,i+1,vis);
                ds.remove(ds.size()-1);
                vis[i]=0;
            }   
        }
    }
    public List<List<Integer>> permute(int[] nums) {
        int n = nums.length;
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> ds = new ArrayList<>();
        int[] vis = new int[n];
        solve(nums,ans,ds,0,vis);
        return ans;
    }
}