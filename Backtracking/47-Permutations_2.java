/*
    Important point: If you are finding permutations. Keeping a index parameter 
    is does not serve any purpose. We have to iterate the array from 0 everytime
    so vis[] array becomes handy.
    Keeping a index parameter will only complicate things
 */
import java.util.*;
class Solution {
    public void solve(int[] nums, List<List<Integer>> ans, List<Integer> ds, int[] vis){
        if(ds.size()==nums.length){
            ans.add(new ArrayList<>(ds));
            return;
        }
        for(int i=0;i<nums.length;i++){

            if(i>0 && nums[i]==nums[i-1] && vis[i-1]==1)
            continue;

            if(vis[i]==0){
                vis[i]=1;
                ds.add(nums[i]);
                solve(nums,ans,ds,vis);
                ds.remove(ds.size()-1);
                vis[i]=0;
            }
        }
    }
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> ds = new ArrayList<>();
        int vis[] = new int[nums.length];

        solve(nums,ans,ds,vis);
        return ans;
    }
}