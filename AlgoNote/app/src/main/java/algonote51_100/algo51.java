package algonote51_100;

public class algo51 {
    /***
     * 动态规划
     *         int [][] nums = new int[m][n];   代表 移动 到 第 i ，j 时的最小步数 。
     *         初始化 基础数值 时 。第一行和第一列的计算 比较特殊
     * @param grid
     * @return
     */
    public static  int minPathSum(int[][] grid) {
        int n = grid[0].length;
        int m = grid.length;
        int [][] nums = new int[m][n];
        nums[0][0] = grid[0][0];
        for(int i=1;i<n;i++){
            nums[0][i] = nums[0][i-1]+grid[0][i];
        }
        for(int i=1;i<m;i++){
            nums[i][0] = nums[i][0]+grid[i][0];
        }
        for(int i =1;i<m;i++){
            for(int j =1;j<n;j++){
                System.out.println("  nums " + (i-1) +"  "+j  +"  =  "+nums[i-1][j]);
                System.out.println("  nums " + (i) +"  "+(j-1) + "  =  "+ nums[i][j-1]);
                nums[i][j] = Math.min( nums[i-1][j] , nums[i][j-1] ) + grid[i][j];
            }
        }
        return nums[m-1][n-1];

    }

    public  static  void main(String args[]){
        int [] [] arr = new int[2][2];
        arr[0][0] = 1;
        arr[0][1] = 2;
        arr[1][0] = 1;
        arr[1][1] = 1;
        minPathSum(arr);
    }

}
