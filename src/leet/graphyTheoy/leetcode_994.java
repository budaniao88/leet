package leet.graphyTheoy;

import java.util.LinkedList;
import java.util.Queue;

/*
* 994. 腐烂的橘子
*
在给定的 m x n 网格 grid 中，每个单元格可以有以下三个值之一：

值 0 代表空单元格；
值 1 代表新鲜橘子；
值 2 代表腐烂的橘子。
每分钟，腐烂的橘子 周围 4 个方向上相邻 的新鲜橘子都会腐烂。

返回 直到单元格中没有新鲜橘子为止所必须经过的最小分钟数。如果不可能，返回 -1 。

示例 1：

输入：grid = [[2,1,1],[1,1,0],[0,1,1]]
输出：4
示例 2：

输入：grid = [[2,1,1],[0,1,1],[1,0,1]]
输出：-1
解释：左下角的橘子（第 2 行， 第 0 列）永远不会腐烂，因为腐烂只会发生在 4 个方向上。
示例 3：

输入：grid = [[0,2]]
输出：0
解释：因为 0 分钟时已经没有新鲜橘子了，所以答案就是 0 。


提示：

m == grid.length
n == grid[i].length
1 <= m, n <= 10
grid[i][j] 仅为 0、1 或 2
* */
public class leetcode_994 {
    public int orangesRotting(int[][] grid) {
        if (grid == null || grid.length==0) return -1;
        int rows = grid.length;
        int cols = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        int freshOrange = 0;
        // 初始化队列并统计新鲜橘子的数量
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 2){
                    queue.offer(new int[]{i,j});
                } else if (grid[i][j]==1) {
                    freshOrange++;
                }
            }
        }
        if (freshOrange == 0) return 0;
        int minutes = 0;
        int[][] directions = {{-1,0},{1,0},{0,-1},{0,1}};
        while (!queue.isEmpty()){
            // 确定腐烂橘子数量
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                // 弹出队列首部
                int[] point = queue.poll();

                for (int[] dir : directions) {
                    int x = point[0] + dir[0];
                    int y = point[1] + dir[1];
                    if (x>=0&& y>=0 && x<rows&&y<cols && grid[x][y] == 1){
                        grid[x][y] = 2;
                        freshOrange --;
                        queue.offer(new int[]{x,y});
                    }
                }
            }
            minutes++;
        }
        return freshOrange ==0? minutes -1 :-1;
    }
}
