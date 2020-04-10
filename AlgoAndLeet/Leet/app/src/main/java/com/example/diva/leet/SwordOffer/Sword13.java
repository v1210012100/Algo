package com.example.diva.leet.SwordOffer;

public class Sword13 {

    /***
     *  机器人的运动范围
     *  这道题的特点是：保留访问过的地方。   终止条件已经访问过该节点，或者边界问题不符合
     *
     *
     *
     *
     *
     *
     *  ------------------路径问题是： 回溯的时候会清除访问过的地方。
     *
     *
     *  因为它不是路径问题 。 就是简单的深度优先遍历。 加上剪枝。
     * @param m
     * @param n
     * @param k
     * @return
     */
    public int movingCount(int m, int n, int k) {
        visited = new boolean[m][n];
        help(0,0,k,m,n);
        return num;
    }
    boolean visited[][] ;
    int num = 0;
    public void help(int i,int j, int k,int m,int n){
        if(i<0 || j<0 || i == m || j == n || visited[i][j]) return;
        visited[i][j] = true;
        if(isOk(i,j,k)) {
            num++;
            if(i-1>=0 && !visited[i-1][j]) help(i-1,j,k,m,n);
            if(i+1<m && !visited[i+1][j]) help(i+1,j,k,m,n);
            if(j-1>=0 && !visited[i][j-1]) help(i,j-1,k,m,n);
            if(j+1<n && !visited[i][j+1]) help(i,j+1,k,m,n);
        }
    }


    public boolean isOk(int x,int y,int k){
        int sumX =0;
        int sumY = 0;
        while(x>0){
            sumX += x % 10;
            x = x / 10;
        }

        while(y>0){
            sumY += y%10;
            y = y/10;
        }
        if(sumX +sumY<=k){
            return true;
        }else{
            return false;
        }
    }
}
