import java.util.*;
/*
    Time - O(m*n log(m*n))
    space - O(k)

    This question can come in the form of Kth smallest number 
    is sortest lists. Same approach
 */
class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        int m = matrix.length;
        int n = matrix[0].length;

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                maxHeap.offer(matrix[i][j]);

                if(maxHeap.size()>k)
                maxHeap.poll();
            }
        }
        return maxHeap.poll();
    }
}


/*
    T.C - O(klogm)
    S.C - O(k) 
 */
class Touple{
    int element;
    int listIndex;
    int numIndex;

    Touple(int element, int listIndex, int numIndex){
        this.element=element;
        this.listIndex=listIndex;
        this.numIndex=numIndex;
    }
}
class Solutions {
    public int kthSmallest(int[][] matrix, int k) {
        int m = matrix.length;
        int n = matrix[0].length;
        PriorityQueue<Touple> minHeap = new PriorityQueue<>((a,b)->a.element-b.element);

        for(int i=0;i<m;i++){
            minHeap.offer(new Touple(matrix[i][0],i,0));
        }

        int numsChecked =0;
        while(!minHeap.isEmpty()){
            Touple t = minHeap.poll();
            int element = t.element;
            int listIndex = t.listIndex;
            int numIndex = t.numIndex;

            numsChecked++;

            if(numsChecked==k){
                return element;
            }

            if(numIndex+1 < matrix[listIndex].length){
                minHeap.offer(new Touple(matrix[listIndex][numIndex+1],listIndex,numIndex+1));
            }
        }
        return -1;
    }
}