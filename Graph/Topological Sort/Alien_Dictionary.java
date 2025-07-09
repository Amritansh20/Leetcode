import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;


/*
    Time-
    For building adj list- 
    Constructing from 0 - (n-2)
    and comparing two string say Length = L
    O(N*L)

    Counting inDegree - 
    O(K*E) For K nodes and going to each edge once

    Khan's Algo - O(K+E)

    Space - 
    O(N*L) for adj list
    O(K) for inDegree
    O(k) for ans string
 */
class Solution{
    public List<Integer> topoSort(List<List<Integer>> adj, int K){
        int[] inDegree = new int[K];
        ArrayDeque<Integer> q = new ArrayDeque<>();

        for(int i=0;i<adj.size();i++){
            for(int it : adj.get(i))
            inDegree[it]++;
        }

        for(int i=0;i<K;i++){
            if(inDegree[i]==0)
            q.offer(i);
        }

        List<Integer> ans = new ArrayList<>();
        while(!q.isEmpty()){
            int node = q.poll();
            ans.add(node);

            for(int it : adj.get(node)){
                inDegree[it]--;

                if(inDegree[it]==0)
                q.offer(it);
            }
        }
        return ans;
    }
    public String findOrder(String[] dict, int N, int K){
        List<List<Integer>> adj = new ArrayList<>();
        
        for(int i=0;i<K;i++)
        adj.add(new ArrayList<>());

        for(int i=0;i<dict.length-1;i++){
            String str1 = dict[i];
            String str2 = dict[i+1];
            int len = Math.min(str1.length(),str2.length());

            for(int j=0;j<len;j++){
                if(str1.charAt(j)-'a' != str2.charAt(j)-'a'){
                adj.get(str1.charAt(j)-'a').add(str2.charAt(j)-'a');
                break;
                }
               
            }
        }

        List<Integer> toposort = topoSort(adj,K);
        String ans = "";

        for(int i=0;i<toposort.size();i++){
            char ch = (char) (toposort.get(i)+'a');
            ans += ch;
        }
        return ans;
    }
}
public class Alien_Dictionary {
    public static void main(String[] args) {
        int N = 5, K = 4;
        String[] dict = {"baa", "abcd", "abca", "cab", "cad"};
        Solution obj = new Solution();
        String ans = obj.findOrder(dict, N, K);

        for (int i = 0; i < ans.length(); i++) {
            System.out.print(ans.charAt(i) + " ");
        }
        System.out.println("");
    }    
}
