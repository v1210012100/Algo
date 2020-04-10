package com.example.diva.leet.SwordOffer;

public class Sword12 {
    /***
     * 使用回溯哦算法。也就是深度优先遍历
     * 在，该层判断失败后记得清除数据。 防止影响上层判断
     * @return
     */
    public boolean exist(char[][] board, String word) {
        int x = board.length;
        int y = board[0].length;
        boolean[][] visited = new boolean[x][y];
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                if (help(board, word, i, j, visited, 0, x - 1, y - 1)) return true;
            }
        }
        return false;
    }

    public boolean help(char[][] board, String word, int i, int j, boolean[][] visited, int k, int xMax, int yMax) {
        if (i < 0 || j < 0 || i > xMax || j > yMax || board[i][j] != word.charAt(k)) return false;
        if (k == word.length() - 1) return true;
        visited[i][j] = true;

        boolean up = false, down = false, left = false, right = false;
        if (i - 1 >= 0) {
            up = !visited[i - 1][j] && help(board, word, i - 1, j, visited, k + 1, xMax, yMax);
        }
        if (i + 1 <= xMax) {
            down = !visited[i + 1][j] && help(board, word, i + 1, j, visited, k + 1, xMax, yMax);
        }

        if (j - 1 >= 0) {
            left = !visited[i][j - 1] && help(board, word, i, j - 1, visited, k + 1, xMax, yMax);
        }
        if (j + 1 <= yMax) {
            right = !visited[i][j + 1] && help(board, word, i, j + 1, visited, k + 1, xMax, yMax);
        }
        if (up || down || left || right) {
            return true;
        } else {
            visited[i][j] = false;
            return false;
        }

    }

}
