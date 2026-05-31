package q48;

public class main {
    
}
class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        int top = 0, bottom = n-1, left = 0, right = n-1;
        while(top < bottom && left < right) {
            for(int i = 0; i < right - left; i++) {
                int tmp = matrix[top][left + i];
                matrix[top][left + i] = matrix[bottom - i][left];
                matrix[bottom - i][left] = matrix[bottom][right - i];
                matrix[bottom][right - i] = matrix[top + i][right];
                matrix[top + i][right] = tmp;
            }
            top++;
            bottom--;
            left++;
            right--;
        }
    }
}