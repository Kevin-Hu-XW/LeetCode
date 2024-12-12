package Array;

public class kthSmallest {
    public static int kthSmallest(int[][] matrix, int k) {
        int col = matrix[0].length;
        int temp;
        if(k>=col){
            if(k%col==0){
                temp = k/col;
                return matrix[temp-1][col-1];
            }
            else{
                temp = k/col;
                return matrix[temp][k%col-1];
            }
        }else{
            return matrix[k/col][k%col-1];
        }

    }

    public static void main(String[] args) {
        int[][] matrix = {{5}};
        int temp = kthSmallest(matrix,1);
        System.out.println(temp);
    }
}
