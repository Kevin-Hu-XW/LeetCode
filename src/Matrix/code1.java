package Matrix;



import java.util.LinkedList;
import java.util.List;

public class code1 {
    public List<Integer> spiralOrder(int[][] matrix) {
        if (matrix.length==0||matrix[0].length==0) {
            throw new RuntimeException("the matrix is empty");
        }
        int tr=0;
        int tc=0;
        int dr=matrix.length-1;
        int dc=matrix[0].length-1;
        List<Integer> list=new LinkedList<Integer>();
        while (tr<=dr&&tc<=dc) {
            traverseMatrix(matrix,tr++,tc++,dr--,dc--,list);
        }
        return list;
    }
    public static void traverseMatrix(int[][] matrix,int tr,int tc,int dr,int dc,List<Integer> list) {
        if (tr==dr) {
            for (int i=tc;i<=dc;i++) {
                list.add(matrix[tr][i]);
            }
        }else if (tc==dc) {
            for (int i=tr;i<=dr;i++) {
                list.add(matrix[i][tc]);
            }
        }else
        {   int curR=tr;
            int curC=tc;
            while (curC<dc){
                list.add(matrix[tr][curC++]);
            }
            while (curR<dr) {
                list.add(matrix[curR++][dc]);
            }
            while (curC>tc) {
                list.add(matrix[dr][curC--]);
            }
            while (curR>tr) {
                list.add(matrix[curR--][tc]);
            }
        }
    }
}
