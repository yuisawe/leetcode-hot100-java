package q240;

public class main {
    
}
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int x = 0;
        int y = n - 1;
        boolean ans = false;
        while(x < m && y >= 0){
            int num = matrix[x][y];
            if(num == target) {
                ans = true;
                break;
            }
            if(num > target){
                y--;
                continue;
            }
            x++;
        }
        return ans;
    }
}