class Solution {
    public boolean canAllRun(int[] batteries, long limit, int n){
        long time = 0;

        for(int power :batteries)
        time += Math.min(limit,power);

        return time>= (long)n*limit;
    }
    public long maxRunTime(int n, int[] batteries) {
        if(n>batteries.length)
        return 0;

        long sum = 0;
        
        for(int num : batteries)
        sum += num;
        
        long low = 1;
        long high = sum;
        long ans = 0;

        while(low<=high){
            long mid = low+(high-low)/2;

            if(canAllRun(batteries,mid,n)){
                ans = mid;
                low = mid+1;
            }else{
                high=mid-1;
            }
        } 
        return ans;
    }
}