/*
    T.C - 2^(target/mincandidate)

    candidates = [2] target = 2000 
    think of the process. 
 */
import java.util.*;
class Solution {
    public void solve(int[] candidates, List<Integer> ds, List<List<Integer>> ans,int target,int index){
        if(target==0){
            ans.add(new ArrayList<>(ds));
            return;
        }

        if(index>=candidates.length)
        return;

        if(target>=candidates[index]){
            ds.add(candidates[index]);
            solve(candidates,ds,ans,target-candidates[index],index);
            ds.remove(ds.size()-1);
        }
        solve(candidates,ds,ans,target,index+1);
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> ds = new ArrayList<>();
        solve(candidates,ds,ans,target,0);
        return ans;
    }
}