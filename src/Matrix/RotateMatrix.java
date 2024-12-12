package Matrix;
/*
旋转矩阵
 */
public class RotateMatrix
{
    public void rotate(int[][] matrix) {
        if (matrix.length==0) {
            throw new RuntimeException("The Array is empty");
        }
        int tr=0;
        int tc=0;
        int dr=matrix.length-1;
        int dc=matrix[0].length-1;
        while (tr<=dr&&tc<=dc) {
            PrintMatrix(matrix,tr++,tc++,dr--,dc--);
        }
    }
    public void PrintMatrix(int[][] matrix,int tr,int tc,int dr,int dc) {
        int times=dc-tc;
        int tmp;
        for (int i=0;i<times;i++) {
            tmp=matrix[tr][tc+i];
            matrix[tr][tc+i]=matrix[dr-i][tc];
            matrix[dr-i][tc]=matrix[dr][dc-i];
            matrix[dr][dc-i]=matrix[tr+i][dc];
            matrix[tr+i][dc]=tmp;


        }
    }
    public static void main(String[] args) {

    }
}
