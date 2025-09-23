/*
 * 
 *  T.C - 2^ k
 *  k= number of alphabets
 */
import java.util.*;
class Solution {
    public void solve(String s, List<String> ans, StringBuilder ds, int index){
        if(index==s.length()){
            ans.add(ds.toString());
            return;
        }

        if(Character.isDigit(s.charAt(index))){
            ds.append(s.charAt(index));
            solve(s,ans,ds,index+1);
            ds.deleteCharAt(ds.length()-1);
        }else{
            ds.append(Character.toUpperCase(s.charAt(index)));
            solve(s,ans,ds,index+1);
            ds.deleteCharAt(ds.length()-1);
            ds.append(Character.toLowerCase(s.charAt(index)));
            solve(s,ans,ds,index+1);
            ds.deleteCharAt(ds.length()-1);
        }
    }
    public List<String> letterCasePermutation(String s) {
        List<String> ans = new ArrayList<>();
        
        if(s.length()==0)
        return ans;
        
        StringBuilder ds = new StringBuilder();
        solve(s,ans,ds,0);
        return ans;
    }
}