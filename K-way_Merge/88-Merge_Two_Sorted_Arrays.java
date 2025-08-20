import java.util.*;

//Time - O((m+n) log(m+n))
//Space - O(m+n)
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for(int i=0;i<m;i++)
        minHeap.offer(nums1[i]);

        for(int i=0;i<n;i++)
        minHeap.offer(nums2[i]);

        int index=0;
        while(!minHeap.isEmpty()){
            nums1[index++] = minHeap.poll();
        }
    }
}

// There is an another approach which is k-way merge
// Time - O(m+n)
// We will a pointer in the last element(not last index) of both array and a pointer in the last 
// index of nums1.
// Post that we will compare and append

class Solutions {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int p1 = m-1;
        int p2 = n-1;
        int p = (m+n-1);

        while(p1>=0 && p2>=0 && p>=0){
            if(nums1[p1] >= nums2[p2]){
                nums1[p] = nums1[p1];
                p1--;
            }else if(nums1[p1]<nums2[p2]){
                nums1[p] = nums2[p2];
                p2--;
            }
            p--;
        }

        while(p1>=0){
            nums1[p] = nums1[p1];
            p1--;
            p--;
        }

        while(p2>=0){
            nums1[p]=nums2[p2];
            p2--;
            p--;
        }
    }
}