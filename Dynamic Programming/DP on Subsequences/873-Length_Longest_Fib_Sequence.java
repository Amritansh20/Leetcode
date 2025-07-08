import java.util.*;
class Solution {
    // Burte Foce. Pretty straight forward.
    // Accepted in Leetcode.
    // I can see we can apply DP on it but couldn't decide the state.
    public int lenLongestFibSubseq(int[] arr) {
        int n = arr.length;
        Map<Integer,Integer> map = new HashMap<>();
        
        for(int i=0;i<arr.length;i++)
        map.put(arr[i],i);

        int maxi=0;

        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                int prev = arr[j];
                int prev_prev= arr[i];
                int len =2;
                while(map.containsKey(prev+prev_prev)){
                    len++;
                    maxi = Math.max(maxi,len);
                    int x = prev+prev_prev;
                    prev_prev = prev;
                    prev=x;
                }
            }
        }
        return maxi;
    }
}

/*
    When you solve this with Dp. It becomes very interesting. 
    I tried doing this with recur+memo. I figured out the 3 parameters but couldn't 
    figured the transition. 


    State: 
        dp[i][j] => The max length of subsequence where last two elements of subsequence 
        are arr[i] and arr[j].
        
    Transition- This is tricky and not frequently seen. 
        So, arr[0], arr[1], . ..... arr[i], .... arr[j], ... arr[n-1]
        I need to go from arr[0] to arr[j-1] and check all the (element + arr[i])==arr[j]
        Everytime I met this condition I update dp[i][j] = 1+ dp[index1][j] 

        For better understanding I will change the names to current, start and end
        your state is dp[curr][end] = 1+ dp[start][end]

        arr[0/start], arr[1] ..... arr[end] .... arr[current]

        Always focus on the smallest state. you need 3 elements to decide your state. 

    Final Suproblem- whatever the max value in dp array + 2. adding 2 because 
    we are starting from 3rd element. We start from 0,1,2 indexs 

    T.C - O(n^2)
    S.C - O(n^2) 

 */
class Solutions {
    public int lenLongestFibSubseq(int[] arr) {
        int n = arr.length;
        int[][] dp = new int[n][n];
        int maxLen=0;

        for(int curr=2;curr<n;curr++){
            int start=0, end=curr-1;

            while(start<end){
            if(arr[start]+arr[end]<arr[curr])
            start++;
            else if(arr[start]+arr[end]>arr[curr])
            end--;
            else{
                dp[end][curr]= 1+dp[start][end];
                maxLen = Math.max(maxLen,dp[end][curr]);
                end--;
                start++;
            }
          }
        } 
        return maxLen==0?0:maxLen+2;  
    }
}