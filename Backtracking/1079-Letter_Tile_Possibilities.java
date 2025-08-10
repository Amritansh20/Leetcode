/*
    This is the hybrid approac where we have to find both permutations and combinations.
    T.C - O(2^n * n!)
 */
import java.util.*;
class Solution {
    public void solve(String tiles, Set<String> set, int[] vis, StringBuilder str, int index){
        if(index>=tiles.length()){
            set.add(str.toString());
            return;
        }

        for(int i=0;i<tiles.length();i++){
            if(vis[i]==0){
                vis[i]=1;
                solve(tiles,set,vis,str,index+1);
                str.append(tiles.charAt(i));
                solve(tiles,set,vis,str,index+1);
                str.deleteCharAt(str.length()-1);
                vis[i]=0;
            }

        }
    }
    public int numTilePossibilities(String tiles) {
        Set<String> set = new HashSet<>();
        int[] vis = new int[tiles.length()];
        StringBuilder str = new StringBuilder();

        solve(tiles,set,vis,str,0);
        return set.size()-1;
    }
}