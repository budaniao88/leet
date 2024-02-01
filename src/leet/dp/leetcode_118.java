package leet.dp;

import java.util.ArrayList;
import java.util.List;

/*
*
每次你可以爬 1 或 2 个台阶。
你有多少种不同的方法可以爬到楼顶呢？

确定dp数组（dp table）以及下标的含义
* 第i行j列的数
确定递推公式
* dp[i][j] = dp[i-1][j-1] + dp[i-1][j];
dp数组如何初始化
* dp[0][0] = 1 dp[1][0] = 1 dp[1][1] = 1 ， dp[i][0] = 1
确定遍历顺序
* */
public class leetcode_118 {
    public List<List<Integer>> generate(int numRows) {
        int[][] dp = new int[numRows][];
        for (int i = 0; i < numRows; i++) {
            dp[i] = new int[i + 1];  // 初始化每一行的数组
            dp[i][0] = 1;            // 每一行的第一个元素为1
            dp[i][i] = 1;            // 每一行的最后一个元素为1
            for (int j = 1; j < i; j++) {
                dp[i][j] = dp[i-1][j-1]+dp[i-1][j];
            }
        }
        // 将二维数组转换为列表
        List<List<Integer>> res = new ArrayList<>();
        for (int[] row : dp) {
            List<Integer> listRow = new ArrayList<>();
            for (int num : row) {
                listRow.add(num);
            }
            res.add(listRow);
        }
        return res;
    }
}
