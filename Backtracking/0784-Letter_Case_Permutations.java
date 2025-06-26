import java.util.*;

class Solution {
    List<String> ans = new ArrayList<>();

    void solve(char[] arr, int index){
        if(index == arr.length){
            ans.add(new String(arr));
            return;
        }

        if(Character.isDigit(arr[index])){
            solve(arr,index+1);
        }else{
            arr[index] = Character.toUpperCase(arr[index]);
            solve(arr,index+1);

            arr[index] = Character.toLowerCase(arr[index]);
            solve(arr,index+1);
        }
    }   
    public List<String> letterCasePermutation(String s) {
        solve(s.toCharArray(), 0);
        return ans;
    }
}