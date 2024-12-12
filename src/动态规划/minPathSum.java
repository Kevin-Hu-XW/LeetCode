package 动态规划;
/*
    给定一个包含非负整数的m*n网格grid ，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
 */
public class minPathSum {
    public int minPathSum(int[][] grid) {


        return 0;
    }
    //暴力递归
    public int process1(int[][] grid,int i,int j){
        //特殊位置
        if (i==grid.length-1&&j==grid[0].length-1){
            return grid[i][j];
        }
        if (i==grid.length-1&&j!=grid[0].length-1){
            return grid[i][j]+process1(grid,i,j+1);
        }
        if (i!=grid.length-1&&j==grid[0].length-1){
            return grid[i][j]+process1(grid,i+1,j);
        }
        //普遍位置
        int right = process1(grid,i,j+1); //右边位置到右下角的最小路径和
        int down = process1(grid,i+1,j);  //下边位置到右下角的最小路径和
        return grid[i][j]+Math.min(right,down);
    }

    //动态规划
    public int process2(int[][] grid,int i,int j){
        for (i = 0;i<grid.length-1;i++){
            for (j=0;j<grid[0].length-1;j++){
                if (i==0&&j==0){
                    continue;
                }
                else if (i==0){
                    grid[i][j] = grid[i][j]+grid[i][j-1];
                }
                else if (j==0){
                    grid[i][j] = grid[i][j]+grid[i-1][j];
                }
                else {
                    grid[i][j] = Math.min(grid[i-1][j],grid[i][j-1])+grid[i][j];
                }

            }
        }
        return grid[grid.length-1][grid[0].length-1];
    }

}
