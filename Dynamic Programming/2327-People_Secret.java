import java.util.*;
class Solution {
    static long dp[] = new long[1001];
    static long mod = 1000000007;
    public static long solve(int day, int delay, int target, int forget){
        if(day>target) return 0;
        if(day == target) return 1;

        if(dp[day]!=-1) return dp[day];

        long ans =1;
        for(int i= day+delay;i<day+forget;i++){
            if(i<=target){
                if(i==day+forget-1 && i!= target){
                    ans--;
                }
                ans = ans + solve(i,delay,target,forget);
            }
            ans = (ans%mod);
        }
        return dp[day]=ans;
    }

    public int peopleAwareOfSecret(int n, int delay, int forget) {
        Arrays.fill(dp,-1);
        return (int) solve(1,delay,n,forget);    
    }
}