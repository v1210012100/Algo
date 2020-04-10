package com.example.diva.leet.SwordOffer;

public class Sword47 {
    /***
     * 老动态规划了？  所以要申请空间
     * @param grid
     * @return
     */
    public int maxValue(int[][] grid) {
        int[][] moneys = new int[grid.length][grid[0].length];
        moneys[0][0] = grid[0][0];

        for(int i=1;i<grid.length;i++){
            moneys[i][0] = moneys[i-1][0]+grid[i][0];
        }
        for(int j=1;j<grid[0].length;j++){
            moneys[0][j] = moneys[0][j-1]+grid[0][j];
        }
        for(int i=1;i<grid.length;i++){
            for(int j=1;j<grid[0].length;j++){
                moneys[i][j] = Math.max(moneys[i-1][j],moneys[i][j-1])+grid[i][j];
            }
        }
        return moneys[grid.length-1][grid[0].length-1];
    }

    public int help(int[][] grid,int i,int j){
        if(i<0||j<0) return 0;
        if(i==0&&j==0){
            return grid[0][0];
        }
        return Math.max(help(grid,i-1,j),help(grid,i,j-1))+grid[i][j];
    }
}
