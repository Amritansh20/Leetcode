import java.util.*;
// This will give TLE
// T.C -> addNum - O(nlogn) findMedian -O(1)
class MedianFinder {
    List<Integer> list;
    public MedianFinder() {
        list = new ArrayList<>();
    }
    
    public void addNum(int num) {
        list.add(num);
        Collections.sort(list);
    }
    
    public double findMedian() {
        int n = list.size();
        int mid = n/2;

        if(n%2==1)
        return (double) list.get(mid);
        else{
            return (double) (list.get(mid-1)+list.get(mid))/2.0;
        }        
    }
}

 /*
    My initial solution was with a list. Every time a number came I added it to list
    and sorted the list. 
    T.C - O(nlogn) for adding a number 
            O(1) for getting median. 
    The above solution gave TLE

    Optimal Solution: Using a maxHeap and a minHeap
    Idea: Max heap should contain the lower part of the list and
            Min Heap should contain the higher part of the list.

            The numbers that are coming from a stream are not sorted. 
            We need something so that I can get the middle two elemets on a go
            without sorting the data structure everytime a number came from stream.

            We need to balance both priority queues so that 
            the difference between the size of bot h heaps is not greater than 1.
            Why? Because we are maintaing a sequence of half. That's how we get median
            Why size diff 1 is allowed? In case of odd numbers in stream.

    T.C:
        addNum - (log N)
        findMedian - (1) 
 */
class MedianFinders {
    PriorityQueue<Integer> minHeap;
    PriorityQueue<Integer> maxHeap;
    public MedianFinders() {
        minHeap = new PriorityQueue<>();
        maxHeap = new PriorityQueue<>((a,b)->b-a);
    }
    
    public void addNum(int num) {
        if(maxHeap.isEmpty() || num<maxHeap.peek()){
            maxHeap.offer(num);

            while(maxHeap.size() - minHeap.size()>1){
                minHeap.offer(maxHeap.poll());
            }
        }else{
            minHeap.offer(num);

            while(minHeap.size()-maxHeap.size()>1){
                maxHeap.offer(minHeap.poll());
            }
        }
    }
    
    public double findMedian() {
        if(maxHeap.size()==minHeap.size()){
            return (double) (maxHeap.peek()+minHeap.peek())/2.0;
        }else if(minHeap.size()>maxHeap.size()){
            return (double) minHeap.peek();
        }else{
            return (double) maxHeap.peek();
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */