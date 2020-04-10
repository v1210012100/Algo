package algonote51_100;

/***
 * 图的深度优先遍历
 *
 *  时间复杂度 : O(M\times N)O(M×N)，其中 MM 和 NN 分别为行数和列数。
 *
 * 空间复杂度 : 最坏情况下为 O(M \times N)O(M×N)，此时整个网格均为陆地，深度优先搜索的深度达到 M \times NM×N。
 *
 */
public class algo87 {
    class Solution {

        /***
         * 如果使用深度优先遍历。 遍历的起点是哪些 。不可能每个小岛都遍历次。
         * 这里是 在 以每个小岛 为根节点遍历 时 ，把路径上的节点都置 为0 。
         * 防止重复遍历   同一个小岛。
         *
         *  由于四周都是水 ，只要起点为1 那么必定是存在一个小岛的
         * @param grid
         * @param r
         * @param c
         */
        void dfs(char[][] grid, int r, int c) {
            int nr = grid.length;
            int nc = grid[0].length;

            if (r < 0 || c < 0 || r >= nr || c >= nc || grid[r][c] == '0') {
                return;
            }

            grid[r][c] = '0';
            dfs(grid, r - 1, c);
            dfs(grid, r + 1, c);
            dfs(grid, r, c - 1);
            dfs(grid, r, c + 1);
        }

        public int numIslands(char[][] grid) {
            if (grid == null || grid.length == 0) {
                return 0;
            }

            int nr = grid.length;
            int nc = grid[0].length;
            int num_islands = 0;
            for (int r = 0; r < nr; ++r) {
                for (int c = 0; c < nc; ++c) {
                    if (grid[r][c] == '1') {
                        ++num_islands;
                        dfs(grid, r, c);
                    }
                }
            }

            return num_islands;
        }
    }

}
