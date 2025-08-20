/*
    First loop = O(nlogn) n=nums2.length
    Second loop = O(klogn)
    heap will always have elementns <= n

    Space - O(n)
 */
import java.util.*;
class Touple{
    int sum;
    int index1;
    int index2;

    Touple(int sum, int index1, int index2){
        this.sum=sum;
        this.index1=index1;
        this.index2=index2;
    }
}
class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> ans = new ArrayList<>();
        PriorityQueue<Touple> minHeap = new PriorityQueue<>((a,b)->a.sum-b.sum);
        int counter=0;

        for(int i=0;i<nums2.length;i++){
            minHeap.offer(new Touple(nums1[0]+nums2[i],0,i));
        }

        while(!minHeap.isEmpty() && counter<k){
            Touple touple = minHeap.poll();
            int sum = touple.sum;
            int i = touple.index1;
            int j = touple.index2;
            
            ans.add(Arrays.asList(nums1[i],nums2[j]));

            if(i+1<nums1.length){
                minHeap.offer(new Touple(nums1[i+1]+nums2[j],i+1,j));
            } 
            counter++;  
        }
        return ans;
    }
}