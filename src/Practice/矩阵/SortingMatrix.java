package Practice.矩阵;



public class SortingMatrix {
    public static boolean search(int[][] matrix,int target) {
        //判断二维数组是否为空
        if (matrix.length == 0 || matrix[0].length == 0)
            return false;
        int row=matrix.length-1;
        int col=0;
        //从左下脚开始遍历数组
        while (col<=matrix[0].length-1&&row>=0) {
            if (matrix[row][col]==target) {
                return true;
            }
            else if (matrix[row][col]>target) {
                row--;
            }else {
                col++;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        int[][] matrix={{1,4,7,11,15},{2,5,8,12,19},{3,6,9,16,22},{10,13,14,17,24},{18,21,23,26,30}};
        boolean falg=search(matrix,5);
        System.out.println(falg);
    }
}
