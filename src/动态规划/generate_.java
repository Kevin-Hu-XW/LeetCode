package 动态规划;
/*
    给定一个非负整数 numRows，生成杨辉三角的前 numRows 行。
    思路：每个数字等于上一行的左右两个数字之和，可用此性质写出整个杨辉三角。
          即第n行i个数等于第 n-1行的第 i-1个数和第i个数之和。

 */
import java.util.ArrayList;
import java.util.List;
public class generate_ {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> rows = new ArrayList<List<Integer>>();
        for (int i=0;i<numRows;i++){
            List<Integer> row = new ArrayList<>();
            for (int j=0;j<=i;j++){   //*****
                if (j==0||j==i)
                    row.add(1);
                else {
                    row.add(rows.get(i-1).get(j-1)+rows.get(i-1).get(j));
                }
            }
            rows.add(row);
        }
        return rows;
    }
}
