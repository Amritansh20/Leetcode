/*
 * T.C - O(2^2n)
 * S.C - O(n)
 * 
 */
import java.util.*;

class Solution {
    public boolean isValid(String str){
        if(str.length()==0)
        return false;

        if(str.charAt(0)==')')
        return false;

        ArrayDeque<Character> stack = new ArrayDeque<>();

        for(int i=0;i<str.length();i++){
            if(stack.isEmpty() && str.charAt(i)==')')
            return false;

            if(str.charAt(i)=='(')
            stack.offer('(');
            else
            stack.poll();
        }
        return stack.size()==0;
    }
    public void solve(List<String> ans, StringBuilder ds, int n){
        if(ds.length()==2*n){
            if(isValid(ds.toString())){
                ans.add(ds.toString());
            }
            return;
        }

        ds.append('(');
        solve(ans,ds,n);
        ds.deleteCharAt(ds.length()-1);
        ds.append(')');
        solve(ans,ds,n);
        ds.deleteCharAt(ds.length()-1);
    }
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        StringBuilder ds = new StringBuilder();
        solve(ans,ds,n);
        return ans;
    }
}