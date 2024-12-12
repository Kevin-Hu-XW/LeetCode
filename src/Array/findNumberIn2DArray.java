package Array;

public class findNumberIn2DArray {
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if (matrix.length==0&&matrix[0].length==0)
            return false;
        int row = matrix.length-1;
        int col = matrix[0].length-1;
        int i=0,j=0;
        while (i<=row&&col>=0){
            if (matrix[i][col]==target)
                return true;
            else if (matrix[i][col]>target){
                col--;
            }
            else {
                i++;
            }
        }
        return false;
    }
}
