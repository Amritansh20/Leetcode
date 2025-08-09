import java.util.*;
class Solution {
    public void solve(int[] nums, List<List<Integer>> ans, List<Integer> ds, int index){
        if(index==nums.length){
            ans.add(new ArrayList<>(ds));
            return;
        }

        ds.add(nums[index]);
        solve(nums,ans,ds,index+1);
        ds.remove(ds.size()-1);
        solve(nums,ans,ds,index+1);
    }
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> ds = new ArrayList<>();
        solve(nums,ans,ds,0);
        return ans;
    }
}