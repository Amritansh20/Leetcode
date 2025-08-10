/*
    Time Complexity: O(2^n * n)
 */
import java.util.*;
class Solution {
    public void solve(int[] candidates, List<List<Integer>> ans, List<Integer> ds, int target, int index){
        if(target==0){
            ans.add(new ArrayList<>(ds));
            return;
        }

        if(index>=candidates.length)
        return;

        for(int i=index;i<candidates.length;i++){
            if(i>index && candidates[i]==candidates[i-1])
            continue;
            
            if(target>=candidates[i]){
            ds.add(candidates[i]);
            solve(candidates,ans,ds,target-candidates[i],i+1);
            ds.remove(ds.size()-1);
            }
        }
    }
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> ds = new ArrayList<>();
        solve(candidates,ans,ds,target,0);
        return ans;
    }
}