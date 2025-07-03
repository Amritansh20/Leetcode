/*
    Two pass Greedy ->
        1- prefix is calculating partial corrent ans same as suffix.
        Together they give me my final answer.

        While calculating the prefix I go ahad and check if the previous rating is greater
        or not? If yes then increase the count

        rating = {1,3,2,1}
        prefix = {1,2,1,1}

        Look closely, does last two rating satisfy the condition?
        Shouldn't student with rating 2 get more candy than student with rating 1
        No, because here we are just considering the element left to current element
        and move forward.

        rating = {1,3,2,1}
        prefix = {1,2,1,1}
        suffix = {1,3,2,1}
        
        rating = {1,3,2,1}
        final =  {1,3,2,1}
        
        Choosing the maximum from both gives you correct answer now?

        T.C = O(n)
        S.C = O(n)

 */
class Solution {
    public int candy(int[] ratings) {
        int n = ratings.length;
        
        int[] prefix = new int[n];
        Arrays.fill(prefix,1);
        
        int[] suffix = new int[n];
        Arrays.fill(suffix,1);

        for(int i=1;i<n;i++){
            if(ratings[i]>ratings[i-1])
            prefix[i]=1+prefix[i-1];
        }

        for(int i=n-2;i>=0;i--){
            if(ratings[i]>ratings[i+1])
            suffix[i]=1+suffix[i+1];
        }

        int ans=0;

        for(int i=0;i<n;i++)
        ans += Math.max(prefix[i],suffix[i]);

        return ans;
    }
}