import java.util.*;
class Pair{
    int count;
    int index;

    Pair(int count, int index){
        this.count=count;
        this.index=index;
    }
}
class Solution {
    public int findCount(int[] arr){
        int low=0;
        int high = arr.length-1;

        while(low<=high){
            int mid = low + (high-low)/2;

            if(arr[mid]==1)
            low=mid+1;
            else
            high=mid-1;
        }
        return low;
    }
    public int[] kWeakestRows(int[][] mat, int k) {
        PriorityQueue<Pair> maxHeap = new PriorityQueue<>((a,b)->a.count==b.count?b.index-a.index:b.count-a.count);

        for(int i=0;i<mat.length;i++){
            int count = findCount(mat[i]);

            if(maxHeap.size()<k){
                maxHeap.offer(new Pair(count,i));
            }else if(count<maxHeap.peek().count){
                maxHeap.poll();
                maxHeap.offer(new Pair(count,i));
            }
        }

        int[] ans = new int[k];
        int j=k-1;

        while(!maxHeap.isEmpty()){
            ans[j--] = maxHeap.poll().index;
        }
        return ans;
    }
}