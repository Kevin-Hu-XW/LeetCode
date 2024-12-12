package Matrix;

public class SortingMatrixSearch {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length==0)
            return false;
        int row=matrix.length-1;
        int col=0;
        while (row>-1&&col<matrix[0].length) {
            if (matrix[row][col]==target) {
                return true;
            }else if (matrix[row][col]>target) {
                row--;
            }
            else{
                col++;
            }
        }
        return false;
    }

    public static void main(String[] args) {

    }
}
