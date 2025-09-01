/*
    I came up with same solution but the major bug in my approach was I was making the minHeap
    on the basis of ratio.
    But the heap has to be made such that the polling will give the max increase if i add 1 in that class.

    It's very obvious that we need to increase the sum of ratio. so, we need to maximize the each ratio.
    the class in which i add 1 studuend should give the max increase of ratio as compareed to other class.

    T.C - O(nlogn)
    S.C - O(n)
 */
import java.util.*;
class Touple{
    int total;
    int passed;

    Touple(int total, int passed){
        this.total = total;
        this.passed=passed;
    }

    public double getGain(){
        double current = (double) passed/total;
        double next = (double) (passed+1)/(total+1);
        return next-current;
    }

    public double getRatio(){
        return (double) passed/total;
    }
}
class Solution {
    public double maxAverageRatio(int[][] classes, int extraStudents) {
        PriorityQueue<Touple> maxHeap = new PriorityQueue<>((a,b)->Double.compare(b.getGain(),a.getGain()));
        
        for(int i=0;i<classes.length;i++){
            int total = classes[i][1];
            int passed = classes[i][0];
            maxHeap.offer(new Touple(total,passed));
        }

        int size = maxHeap.size();
        
        while(extraStudents-- > 0){
            Touple t = maxHeap.poll();
            t.total  = t.total+1;
            t.passed = t.passed+1;
            
            maxHeap.offer(new Touple(t.total,t.passed));
        }

        double sum=0;
        while(!maxHeap.isEmpty()){
            sum += maxHeap.poll().getRatio();
        }

        return sum/size;
    }
}