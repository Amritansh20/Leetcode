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

/*
    The last solution we had has T.C of O(nlogn)
    Well, The T.C in this solution seems to be O(n*k) but it's not if we look very deeply.

    Let's understand the approach first:
    We know the size of our window.
    We took the help of a deque where we are storing the index of element which could a a possible
    maximum of the current window or ahead.

    Everytime we slide we clean out deque.
    For cleaning we are removing all the elements form the deque which is smaller than
    current element. So, that maximum is always at the first.

    Note: we are not discriminating when we are adding indexes to out deque. We are only filtering while
    cleaning up.

    T.C- Well it seems O(n*k) but it's actually O(n)
    Total slides - O(n-k)

    If there is input in asending order then removal from deque happens only once at each step.
    If there is input in desending order then we all the elements(index) will be added as a part of 
    sliding window loop but no clean up will ever take place. The removal from deque will happen only 
    those(sigle element) we afll out of window. This will again happen in sliding window loop.

    So, T.C - O(n)


 */
class Solutions {
    public void cleanUp(Deque<Integer> deque, int i, int[] nums){
        while(!deque.isEmpty() && nums[i]>= nums[deque.getLast()])
        deque.removeLast();
    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        Deque<Integer> deque = new ArrayDeque<>();
        int[] ans = new int[n-k+1];
        
        if(n==1)
        return nums;

        for(int i=0;i<k;i++){
            cleanUp(deque,i,nums);
            deque.addLast(i);
        }

        ans[0] = nums[deque.getFirst()];

        for(int i=k;i<n;i++){
            cleanUp(deque,i,nums);

            if(!deque.isEmpty() && deque.getFirst() < i-k+1)
            deque.removeFirst();

            deque.addLast(i);
            ans[i-k+1] = nums[deque.getFirst()];
        }
        return ans;

    }
}