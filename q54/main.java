package q54;

import java.util.ArrayList;
import java.util.List;

public class main {
    
}
class Solution {
    
    public List<Integer> spiralOrder(int[][] matrix) {
        int[] dirs_x = {0,1,0,-1};
        int[] dirs_y = {1 , 0, -1,0};
        int m = matrix.length;
        int n= matrix[0].length;
        boolean[][] choosed = new boolean[m][n];
        choosed[0][0] = true;
        int dir = 0;
        List<Integer> ans = new ArrayList<>();
        int cnt = 1;int x = 0 ; int y = 0;
        ans.add(matrix[0][0]);
        while(cnt < m * n){
            int newx = x + dirs_x[dir];
            int newy = y + dirs_y[dir];
            if(newx<0||newx>=m||newy<0||newy>=n||choosed[newx][newy]){
                dir = (dir + 1) % 4;
                newx = x + dirs_x[dir];
                newy = y + dirs_y[dir];                
            }
            ans.add(matrix[newx][newy]);
            cnt++;
            x= newx;
            y = newy;
            choosed[x][y] = true;
        }


        return ans;
    }
}