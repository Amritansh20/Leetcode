
import java.util.*;
class Solution {

    /*
    The Brute force is to go with each element and explore all its subarray and tract all minimums. 
    T.C - O(n^2)

    The better approach is using Monotonic stack
    If for each element(e) I find the next smaller element and previous smaller element 
    Then, we can safely say that the for all the subarrays(n) between next smaller(excluding) and prev 
    smaller(excluding) e is smallest. 
    After we find the subarrays, we multiply it with e. 

    T.C->O(n)
    S.C-> O(n)
 */
    public int[] NSE(int[] arr){
        int n = arr.length;
        int[] nse = new int[n];
        Arrays.fill(nse,n);

        ArrayDeque<Integer> stack = new ArrayDeque<>();

        for(int i=0;i<n;i++){

            while(!stack.isEmpty() && arr[i]<arr[stack.peek()]){
                nse[stack.peek()]=i;
                stack.pop();
            }
            stack.push(i);
        }
        return nse;
    }

    public int[] PSE(int[] arr){
        int n = arr.length;
        int[] pse = new int[n];
        Arrays.fill(pse,-1);

        ArrayDeque<Integer> stack = new ArrayDeque<>();

        for(int i=n-1;i>=0;i--){

            while(!stack.isEmpty() && arr[i]<=arr[stack.peek()]){
                pse[stack.peek()]=i;
                stack.pop();
            }
            stack.push(i);
        }
        return pse;
    }
    public int sumSubarrayMins(int[] arr) {
        int n = arr.length;
        int[] nse = NSE(arr);
        int[] pse = PSE(arr);

        int ans =0;
        int mod = 1_000_000_007;

        for(int i=0;i<n;i++){
            long left = i-pse[i];
            long right = nse[i]-i;

            long contribution = (left*right)%mod;
            contribution = (contribution*arr[i])%mod;

            ans = (int)((ans+contribution)%mod);
        }
        return ans;
    }
}