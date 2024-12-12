package Matrix;
/*
    按z型的方式打印矩阵
    思路：获取矩阵对角线的两个坐标，并打印对角线上的每个点，通过bool值改变每次打印的方向
 */

public class PrintZMatrix
{
    public static void Matrix(int[][] matrix) {
        if (matrix.length==0 || matrix[0].length==0) {
            throw new RuntimeException("The array is empty");
        }
        int ar=0;
        int ac=0;
        int br=0;
        int bc=0;
        int endR=matrix.length-1;
        int endC=matrix[0].length-1;
        boolean fromup=true;
        //当a点横坐标为matrix.length-1,表示矩阵元素都遍历完
        while (ar<=endR) {
            printMatrix(matrix,ar,ac,br,bc,fromup);
            ar=ac==endC?++ar:ar;
            ac=ac==endC?ac:++ac;
            br=br==endR?br:++br;
            bc=br==endR?++bc:bc;
            //改变打印方向
            fromup=!fromup;
        }
    }
    //遍历对角线之间的点的坐标
    public static void printMatrix(int[][] matrix,int ar,int ac,int br,int bc,boolean fromUp){
        if (fromUp) {
            while (ar<=br) {
                System.out.print(matrix[ar++][ac--]+" ");
            }
        }else
        {
            while (br>=ar) {
                System.out.print(matrix[br--][bc++]+" ");
            }
        }
    }
    public static void main(String[] args) {
        int[][] matrix = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 } };
        Matrix(matrix);
    }
}
