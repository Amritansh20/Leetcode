import java.util.*;
/*
    The below solution is brute force. 
    Time - O(n^2) 
    Accepted on Leetcode
 */
class Solution {
    public String toString(int[] arr){
        return String.valueOf(arr[0])+","+String.valueOf(arr[1]);
    }
    public int[] findRightInterval(int[][] intervals) {
        int n = intervals.length;
        Map<String,Integer>  map = new HashMap<>();
    
        for(int i=0;i<intervals.length;i++){
            String interval = toString(intervals[i]);
            map.put(interval,i);
        }
        Arrays.sort(intervals,(a,b)->a[0]-b[0]);

        List<Integer> ans = new ArrayList<>(n);
        for(int i=0;i<n;i++)
        ans.add(-1);


        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(intervals[j][0]>=intervals[i][1]){
                    ans.set(map.get(toString(intervals[i])),map.get(toString(intervals[j])));
                    break;
                }
            }
        }
        return ans.stream().mapToInt(i->i.intValue()).toArray();
    }
}

// Tried using one priorityQueue
// This gave TLE on Leetcode
class Pair{
    int time;
    int index;

    Pair(int time, int index){
        this.time=time;
        this.index = index;
    }
}
class Solutions {
    public int[] findRightInterval(int[][] intervals) {
        int n = intervals.length;
        PriorityQueue<Pair> minHeap = new PriorityQueue<>((a,b)->a.time-b.time);
        for(int i=0;i<n;i++){
            minHeap.offer(new Pair(intervals[i][0],i));
        }

        int[] ans = new int[n];
        Arrays.fill(ans,-1);

        for(int i=0;i<n;i++){
            List<Pair> list = new ArrayList<>();

            while(!minHeap.isEmpty()){
                Pair p = minHeap.poll();

                if(p.time>=intervals[i][1]){
                    ans[i] = p.index;
                    list.add(p);
                    break;
                }
                list.add(p);
            }

            for(Pair k : list)
            minHeap.offer(k);
        }
        return ans;
    }
}


/*
    Solution 1- Brute force - O(n^2); Acccepted
    Solution 2 - One PriorityQueue - O(n^2 logn) TLE
    Solution 3 - Two PriorityQueue - O(nlogn) Accepted

    All Sumbmitted in previous submissions.
 */

class Solutionss {
    public int[] findRightInterval(int[][] intervals) {
        int n = intervals.length;
        PriorityQueue<Pair> endMinHeap = new PriorityQueue<>((a,b)->a.time-b.time);
        PriorityQueue<Pair> startMinHeap = new PriorityQueue<>((a,b)->a.time-b.time);

        for(int i=0;i<n;i++){
            startMinHeap.offer(new Pair(intervals[i][0],i));
            endMinHeap.offer(new Pair(intervals[i][1],i));
        }
        
        int[] ans = new int[n];
        Arrays.fill(ans,-1);
        while(!endMinHeap.isEmpty()){
            Pair endPair = endMinHeap.poll();
            int endTime = endPair.time;
            int index = endPair.index;

            while(!startMinHeap.isEmpty() && startMinHeap.peek().time<endTime){
                startMinHeap.poll();
            }

            if(!startMinHeap.isEmpty()){
                ans[index] = startMinHeap.peek().index;
            }
        }
        return ans;
    }
}