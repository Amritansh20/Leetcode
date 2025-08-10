/*
    This problem should have been easy.
    The only mistake I made was writing if(index>input.size()) base case first. 

    T.C - O(2^n)
 */
import java.util.*;
class Solution {
    public void solve(List<Integer> input, List<List<Integer>> ans , List<Integer> ds, int index, int k){
        if(ds.size()==k){
            ans.add(new ArrayList<>(ds));
            return;
        }

        if(index>=input.size())
        return;

        ds.add(input.get(index));
        solve(input,ans,ds,index+1,k);
        ds.remove(ds.size()-1);
        solve(input,ans,ds,index+1,k);  
    }
    public List<List<Integer>> combine(int n, int k) {
        List<Integer> input = new ArrayList<>();
        for(int i=1;i<=n;i++)
        input.add(i);

        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> ds = new ArrayList<>();
        solve(input,ans,ds,0,k);
        return ans;
    }
}