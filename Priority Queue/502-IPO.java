/*
    I got the intutin from Task Schduler Problem. 
   
    Initially what I did was -> Process all affordable projects at once by using inner
    while loop. check previous submitted solution where it failed. Why it was wrong?
    If I get some project which gives more profit later then I will miss out on that
    and I will exhaust k earlier.
    profit = 10,5,20
    capital = 0,0,10

    Try this case and you will understand.

    Later upon more digging I came to know in each round I can pick only one. 
    So upon iteration I found the affordable project did it and left the loop.
    I did it until I exhaust k or no projects are left.

    Time- 
        O(n) - Heap construction
        Iterating at most k times and every time scanning the heap.
        In worst case I have to scan all n elements. O(nlogn)

        Total - O(k. nlogn) 

 */
import java.util.*;
class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        int n = profits.length;
        int[][] projects = new int[n][2];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->b[0]-a[0]);

        for(int  i=0;i<n;i++){
            projects[i][0] = profits[i];
            projects[i][1] = capital[i];
        }

        for(int i=0;i<n;i++)
        pq.offer(projects[i]);

        int totalRaised = w;

        while(k>0 && !pq.isEmpty()){
            List<int[]> ineligible = new ArrayList<>();
            boolean found = false;
            
            while(!pq.isEmpty()){
                int[] project = pq.poll();

                if(totalRaised>=project[1] && k>0){
                    totalRaised += project[0];
                    k--;
                    found = true;
                    break;
                }else{
                    ineligible.add(project);
                }
            }

            for(int[] arr : ineligible)
            pq.offer(arr);

            if(!found)
            break;
        }
        return totalRaised;
    }
}