package leet.dp;
/*
*70. 爬楼梯
简单
相关标签
相关企业
提示
假设你正在爬楼梯。需要 n 阶你才能到达楼顶。

每次你可以爬 1 或 2 个台阶。
你有多少种不同的方法可以爬到楼顶呢？

确定dp数组（dp table）以及下标的含义
* 第i行j列的数
确定递推公式
* dp[i][j] = dp[i-1][j-1] + dp[i-1][j];
dp数组如何初始化
* dp[0][0] = 1 dp[1][0] = 1 dp[1][1] = 1 ， dp[i][0] = 1
确定遍历顺序
* 顺序遍历
举例推导dp数组
*
* 1、dp[i] ：爬到第i层有dp[i]种方法
* 2、dp[i] = dp[i-1] + dp[i-2]
* 3、dp[0] = 1 dp[1] = 1 dp[2] = 2
* 4、从前向后顺序遍历
*
示例 1：

输入：n = 2
输出：2
解释：有两种方法可以爬到楼顶。
1. 1 阶 + 1 阶
2. 2 阶
示例 2：

输入：n = 3
输出：3
解释：有三种方法可以爬到楼顶。
1. 1 阶 + 1 阶 + 1 阶
2. 1 阶 + 2 阶
3. 2 阶 + 1 阶

提示：

1 <= n <= 45

* */
public class leetcode_70 {

    public static void main(String[] args) {
        System.out.println(climbStairs(2));
    }
    public static int climbStairs(int n) {
        int[] dp = new int[n+1];
        if (n <= 1) return n;
        dp[0] = dp[1] = 1 ;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i-1] + dp[i-2] ;
           // System.out.println(dp[i]);
        }
        return dp[n];
    }
}
