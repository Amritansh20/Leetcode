import java.util.*;
class Pair{
    int row;
    int col;

    Pair(int row,int col){
        this.row=row;
        this.col=col;
    }
}
class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int m = image.length;
        int n= image[0].length;

        ArrayDeque<Pair> q = new ArrayDeque<>();
        int starting_color = image[sr][sc];

        if (starting_color == color) 
        return image;

        image[sr][sc]=color;
        q.offer(new Pair(sr,sc));
        
        int[] delR = {0,1,0,-1};
        int[] delC = {1,0,-1,0};

        while(!q.isEmpty()){
            Pair p = q.poll();
            int r = p.row;
            int c = p.col;

            for(int i=0;i<4;i++){
                int newR=delR[i]+r;
                int newC=delC[i]+c;

                if(newR>=0 && newC>=0 && newR<m && newC<n && image[newR][newC]==starting_color){
                    image[newR][newC]=color;
                    q.offer(new Pair(newR,newC));
                }
            }
        }
        return image;
    }
}