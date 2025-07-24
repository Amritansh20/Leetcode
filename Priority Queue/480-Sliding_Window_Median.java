/*
    This solution is basic Sliding window of fixed window size which will give TLE.
    T.C -> O(n klogk)

    Couldn't come up with optimized solution. 
    Icame up with the part where i know I have to use two heaps(similar to finding
    median in data stream), but here how to remove the previous elements I got stuck. 
    I learnt the concept of delayed deletion using a map.

    Time Complexity - O(nlog k)
 */

 import java.util.*;
class Solution {
    public double[] medianSlidingWindow(int[] nums, int k) {
        int left=0;
        int right=0;
        List<Double> ans = new ArrayList<>();
        List<Integer> list = new ArrayList<>();

        while(right<nums.length){
            list.add(nums[right]);

            if(list.size()==k){
                Collections.sort(list);
                if(k%2==1)
                ans.add((double) list.get(k/2));
                else{
                    double median = ((long)list.get(k/2) + (long)list.get((k/2)-1))/2.0;
                    ans.add(median);
                }
                list.remove(Integer.valueOf(nums[left]));
                left++;
            }
            right++;
        }   
        return ans.stream().mapToDouble(i->i.doubleValue()).toArray();
    }
}


class Solutions {
    private PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    private PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
    private Map<Integer,Integer> delayed = new HashMap<>();
    private int leftSize =0; // max heap size
    private int rightSize =0; // min Heap size 
    
    public double[] medianSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        List<Double> ans = new ArrayList<>();
        for(int i=0;i<n;i++){
            add(nums[i]);

            if(i>=k)
            remove(nums[i-k]);

            if(i>=k-1)
            ans.add(findMedian(k));
        }    

        double[] res = new double[ans.size()];
        for (int i = 0; i < ans.size(); i++) 
        res[i] = ans.get(i);
        
        return res;
    }

    public void add(int num){
        if(maxHeap.isEmpty() || num <= maxHeap.peek()){
            maxHeap.offer(num);
            leftSize++;
        }else{
            minHeap.offer(num);
            rightSize++;
        }

        balanceHeaps();
    }

    public void remove(int num){
        delayed.put(num, delayed.getOrDefault(num,0)+1);
        if(num<=maxHeap.peek()){
            leftSize--;
            if (num == maxHeap.peek())
            cleanHeaps(maxHeap);
        }else{
            rightSize--;
            if (num == minHeap.peek())
            cleanHeaps(minHeap);
        }
        balanceHeaps();
    }

    public void balanceHeaps(){
        while(leftSize>rightSize+1){
            minHeap.offer(maxHeap.poll());
            leftSize--;
            rightSize++;
        }
        
        while(rightSize>leftSize){
            maxHeap.offer(minHeap.poll());
            rightSize--;
            leftSize++;
        }
        cleanHeaps(maxHeap);
        cleanHeaps(minHeap);
    }

    public void cleanHeaps(PriorityQueue<Integer> heap){
        while(!heap.isEmpty() && delayed.containsKey(heap.peek())){
           int val = heap.poll();
            delayed.put(val,delayed.get(val)-1);

            if(delayed.get(val)==0)
            delayed.remove(val);
        }
    }

    public double findMedian(int k){
       
        if(k%2==1)
        return (double) maxHeap.peek();

        return ((double)maxHeap.peek()+minHeap.peek())/2.0;
    }
}