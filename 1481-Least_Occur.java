import java.util.*;
class Solution {
    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        HashMap<Integer,Integer> mpp = new HashMap<>();
        for(int i=0;i<arr.length;i++){
            mpp.put(arr[i],mpp.getOrDefault(arr[i],0)+1);
        }

        List<Integer> list = new ArrayList<>(mpp.values());
        Collections.sort(list);
        int size = mpp.size();
        for(int num : list){
            if(num<k){
                k-=num;
                size--;
            }else if(num==k){
                k-=num;
                size--;
            }else{
                break;
            }
        }
        return size;
    }
}