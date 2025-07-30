/*
    This is not a hard problem. 
    You have to track a window of size k-> First thought should be Siding window.
    Since you need max element at each step->max heap should come to your mind.

    Why we need a pair ? We need to keep the track of index since we are pushing all elements in heap. 
    We need a check if we hit the size ==k

    Pattern -> fixed size sliding window.

    Approach -> 
    1- Push the element and it's index in max heap.
    2- When we hit the size=k
    3- Check the the max value from the heap and check it's inex lies in the window
    4- If it lies in window add it to ans
    5- else if the index agar piche reh gya hai left ke toh poll those elements. 
    Note -> While polling I am not chceking index>right since it is irrelevant. I can add but it's of no use.

    T.C -> O(nlogn) -> Iterating left to right and pushing to heap takes log n so nlogn
    S.C -> O(n)
 */

import java.util.*;

class Pair{
    int element;
    int index;
    
    Pair(int element, int index){
        this.element=element;
        this.index=index;
    }
}
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        PriorityQueue<Pair> maxHeap = new PriorityQueue<>((a,b)->b.element-a.element);
        List<Integer> ans = new ArrayList<>();
        int left=0,right=0;

        while(right<nums.length){
    
            maxHeap.offer(new Pair(nums[right],right));

            if(right-left+1 ==k){
                while(!maxHeap.isEmpty() && maxHeap.peek().index<left)
                maxHeap.poll();

                ans.add(maxHeap.peek().element);
                left++;
            }
            right++;
        }
        return ans.stream().mapToInt(i->i.intValue()).toArray();
    }
}