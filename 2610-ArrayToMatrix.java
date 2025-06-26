import java.util.*;
class Solution {
    public List<List<Integer>> findMatrix(int[] nums) {
        HashMap<Integer,Integer> hm = new HashMap<>();
        int rowNum=0;
        
        for(int i=0;i<nums.length;i++){
            if(hm.containsKey(nums[i])){
                hm.put(nums[i],hm.get(nums[i])+1);
            }else{
                hm.put(nums[i],1);
            }

            rowNum = Math.max(hm.get(nums[i]),rowNum);
        }

        List<List<Integer>> ans = new ArrayList<>();
        for(int i=0;i<rowNum;i++){
            ans.add(new ArrayList<>());
        }
        for(Map.Entry<Integer,Integer> entry : hm.entrySet()){
            int num = entry.getKey();
            int freq = entry.getValue();

            for(int i=0;i<freq;i++){
                ans.get(i).add(num);
            }
        }
        return ans;
    }
}