// Floyd Warshall Algo.
// T.C -> (n^3)
import java.util.*;
class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int[][] dist = new int[n][n];
        for(int[] arr : dist)
        Arrays.fill(arr,Integer.MAX_VALUE);

        for(int i=0;i<edges.length;i++){
            int from = edges[i][0];
            int to = edges[i][1];
            int weight = edges[i][2];

            dist[to][from] = weight;
            dist[from][to]=weight;
        }

        for(int i=0;i<n;i++)
        dist[i][i]=0;

        for(int via =0;via<n;via++){
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    if(dist[i][via]!=Integer.MAX_VALUE && dist[via][j]!=Integer.MAX_VALUE){
                        dist[i][j] = Math.min(dist[i][j],dist[i][via]+dist[via][j]);
                    }
                }
            }
        }

        int cityCount=n;
        int city=-1;

        for(int i=0;i<n;i++){
            int cnt=0;

            for(int j=0;j<n;j++){
                if(dist[i][j]<=distanceThreshold)
                cnt++;
            }

            if(cnt<=cityCount){
                cityCount=cnt;
                city=i;
            }
        }
        return city;
    }   
}