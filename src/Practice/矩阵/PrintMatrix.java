package Practice.矩阵;

//转圈打印矩阵
public class PrintMatrix {
    public static int Count=0;
    public static int[] showMatrix(int[][] matrix){
        if (matrix.length==0)
            return new int[0];
        int tr=0;
        int tc=0;
        int dr=matrix.length-1;
        int dc=matrix[0].length-1;
        int []arr=new int[matrix.length*matrix[0].length];

        while (tr<=dr) {
            display(matrix,tr++,tc++,dr--,dc--,arr);
        }
        return arr;
    }
    public static void display(int[][] matrix,int tr,int tc,int dr,int dc, int []arr) {
        //只有一列
        if (tr==dr) {
            for (int i=0;i<dc;i++) {
                arr[Count++]=matrix[0][i];
            }
        }else if (tc==dc) {  //只有一行
            for (int j=0;j<dr;j++) {
                arr[Count++]=matrix[j][0];
            }
        }else{
            int curtr=tr;
            int curtc=tc;
            while (curtc<dc){
                arr[Count++]=matrix[tr][curtc++];
            }
            while (curtr<dr){
                arr[Count++]=matrix[curtr++][dc];
            }
            while (curtc>tc){
                arr[Count++]=matrix[dr][curtc--];
            }
            while (curtr>tr){
                arr[Count++]=matrix[curtr--][tc];
            }
        }

    }
    public static void main(String[] args) {
        int[][] matrix={{1,2,3,4},{5,6,7,8},{9,10,11,12}};
        int [] arr =showMatrix(matrix);

    }
}
