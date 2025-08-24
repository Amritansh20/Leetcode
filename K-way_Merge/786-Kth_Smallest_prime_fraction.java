/*
    Pattern - K way merge
    Stpes:
    Initialize your minHeap
    
    My confusion: I was iterating the array in order to push into heap.
    (V.V.I)But the point to be notes is that since the array is sorted we have to use the indexes that is 
    getting polled out from heap in each iteration. 

    Time - O(nlogn)
    Space - O(n)


 */
import java.util.*;
 class Pair{
    int x;
    int y;
    double fraction;

    Pair(double fraction,int x, int y){
        this.fraction=fraction;
        this.x=x;
        this.y=y;
    }
}
class Solution {
    public int[] kthSmallestPrimeFraction(int[] arr, int k) {
        PriorityQueue<Pair> minHeap = new PriorityQueue<>((a,b)->Double.compare(a.fraction,b.fraction));
        
        for(int i=1;i<arr.length;i++){
            minHeap.offer(new Pair((double)arr[0]/arr[i],0,i));
        }

        for(int i=0;i<k-1;i++){
            Pair pair = minHeap.poll();
            int numIndex = pair.x;
            int denoIndex = pair.y;

            if(numIndex+1<denoIndex){
                minHeap.offer(new Pair((double)arr[numIndex+1]/arr[denoIndex],numIndex+1,denoIndex));
            }
        }
        int[] ans = new int[2];
        Pair p = minHeap.poll();
        ans[0] = arr[p.x];
        ans[1]=arr[p.y];

        return ans;
    }
}