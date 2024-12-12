package Matrix;


/*
    给你一个正整数 n ，生成一个包含 1 到 n2 所有元素，
    且元素按顺时针顺序螺旋排列的 n x n 正方形矩阵 matrix 。
 */
public class SpiralMatrix {
    public static int Count=1;
    public int[][] generateMatrix(int n) {
        if (n==1){
            int[][] a={{1}};
            return a;
        }
        int[][] matrix=new int[n][n];
        int tr=0;
        int tc=0;
        int dr=n-1;
        int dc=n-1;
        while (tr<=dr&&tc<=dc) {
            generate(matrix,tr++,tc++,dr--,dc--);
        }
        Count=1;
        return matrix;
    }
    public static void generate(int[][] matrix,int tr,int tc,int dr,int dc){
        if (tr==dr){
            for (int i=tc;i<=dc;i++){
                matrix[tr][i]=Count++;
            }
        }else if (tc==dc) {
            for (int i=tr;i<=dr;i++) {
                matrix[tc][i]=Count++;
            }
        }else{
            //进行遍历的下标
            int curR=tr;
            int curC=tc;
            while (curC<dc) {
                matrix[tr][curC++]=Count++;
            }
            while (curR<dr) {
                matrix[curR++][dc]=Count++;
            }
            while (curC>tc) {
                matrix[dr][curC--]=Count++;
            }
            while (curR>tr) {
                matrix[curR--][tc]=Count++;
            }
        }
    }

    public static void main(String[] args) {

    }
}
