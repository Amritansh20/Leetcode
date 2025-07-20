/*
    Two Pointers

    firstElement = max(list1[i][0],list2[j][0]);
    secondElement = min(list1[i][1],list2[j][1]);
    
    The idea is to track the elements. 
    Make intervals based on you elements and not index. 

    While solving merge interval patters. Deal with
    the element and decide the process.

    Note - both list are sorted and pairwise disjoint. Keep this in mind
    It will help to come up with logic

 */
import java.util.*;
class Solution {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        List<int[]> ans = new ArrayList<>();
        int i=0;
        int j=0;

        while(i<firstList.length && j<secondList.length){
            int start = Math.max(firstList[i][0],secondList[j][0]);
            int end = Math.min(firstList[i][1],secondList[j][1]);

            if(start<=end){
                ans.add(new int[]{start,end});
            }

            if(firstList[i][1]<secondList[j][1]){
                i++;
            }else{
                j++;
            }
        }
        return ans.toArray(new int[ans.size()][]);
    }
}