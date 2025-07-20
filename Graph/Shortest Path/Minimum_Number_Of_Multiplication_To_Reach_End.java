import java.util.Arrays;
import java.util.PriorityQueue;

class Pair{
    int steps;
    int value;

    Pair(int steps, int value){
        this.steps=steps;
        this.value = value;
    }
}
public class Minimum_Number_Of_Multiplication_To_Reach_End {
    public int minSteps(int start, int end, int[] arr){
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)->a.steps-b.steps);
        int[] dis = new int[10000]; // valid values 0-9999
        Arrays.fill(dis,Integer.MAX_VALUE);
        dis[start]=0;
        pq.offer(new Pair(0,start));

        
        while(!pq.isEmpty()){
            Pair p = pq.poll();
            int steps = p.steps;
            int value = p.value;
            
            if(value == end)
            return steps;

            for(int i=0;i<arr.length;i++){
                if(steps+1 < dis[value*arr[i]]){
                    dis[arr[i]*value] = steps+1;
                    pq.offer(new Pair(steps+1,value*arr[i]));
                }
            }
        }
        return -1;
    }
}
