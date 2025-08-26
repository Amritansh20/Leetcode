import java.util.*;
/*
    Time: O(nlogn)
    Space: O(n)
 */
class Solution {
    public int thirdMax(int[] nums) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for(int i=0;i<nums.length;i++){
            maxHeap.offer(nums[i]);
        }

        int count=1;
        int lastElement = maxHeap.poll();
        int ans = lastElement;

        while(!maxHeap.isEmpty()){
            int element = maxHeap.poll();

            if(element!=lastElement){
                lastElement = element;
                count++;
            }

            if(count==3)
            return element;
        }
        return ans;
    }
}


/*
    Since the size of heap is constant. 
    T.C = O(N)
    S.C = O(1) size is fixed for both set and heap. 
 */
class Solutions{
    public int thirdMax(int[] nums) {
        Set<Integer> set = new HashSet<>();
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for(int num : nums){
            if(set.contains(num))
            continue;

            if(minHeap.size()<3){
                minHeap.offer(num);
                set.add(num);
            }else if(minHeap.size()==3){
                if(num>minHeap.peek()){
                    set.remove(minHeap.poll());
                    minHeap.offer(num);
                    set.add(num);
                }
            }
        }

        if(minHeap.size()==1)
        return minHeap.poll();
        else if(minHeap.size()==2){
            minHeap.poll();
            return minHeap.poll();
        }
        else
        return minHeap.poll();
    }
}