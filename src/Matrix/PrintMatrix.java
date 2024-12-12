package Matrix;

import java.util.Stack;
/*
    转圈方式打印矩阵
 */
public class PrintMatrix {
    public static Stack<Integer> stack;
    public static int[] spiralOrder(int[][] matrix) {
        if (matrix.length==0) {
            return new int[0];
        }
        int tr=0;
        int tc=0;
        int dr=matrix.length-1;
        int dc=matrix[0].length-1;
        stack=new Stack<Integer>();
        int[] arr=new int[matrix.length*matrix[0].length];
        while (tr<=dr&&tc<=dc) {
            displaymatrix(matrix,tr++,tc++,dr--,dc--);
        }
        for (int i=arr.length-1;i>=0;i--){
            if (!stack.isEmpty()){
                arr[i]=stack.pop();
            }

        }
        return arr;
    }

    public static void displaymatrix(int[][] matrix,int tr,int tc,int dr,int dc){
        if (tr==dr) {
            for (int i=tc;i<=dc;i++) {
                stack.push(matrix[tr][i]);
            }
        }else  if (tc==dc) {
            for (int i=tr;i<=dr;i++) {

                stack.push(matrix[i][tc]);
            }
        }else {
            int curC=tc;
            int curR=tr;
            while (curC<dc) {
                stack.push(matrix[tr][curC++]);

            }
            while (curR<dr) {
                stack.push(matrix[curR++][dc]);

            }
            while (curC>tc) {
                stack.push(matrix[dr][curC--]);

            }
            while (curR>tr) {
                stack.push(matrix[curR--][tc]);
            }
        }

    }

    public static void main(String[] args) {
        int[][] matrix={{1,2,3,4},{5,6,7,8},{9,10,11,12}};
        int[] arr=spiralOrder(matrix);
        for (int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
    }
}
