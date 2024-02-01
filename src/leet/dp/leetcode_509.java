package leet.dp;
/*
* 509. 斐波那契数

斐波那契数 （通常用 F(n) 表示）形成的序列称为 斐波那契数列 。该数列由 0 和 1 开始，后面的每一项数字都是前面两项数字的和。也就是：

F(0) = 0，F(1) = 1
F(n) = F(n - 1) + F(n - 2)，其中 n > 1
给定 n ，请计算 F(n) 。

示例 1：

输入：n = 2
输出：1
解释：F(2) = F(1) + F(0) = 1 + 0 = 1
示例 2：

输入：n = 3
输出：2
解释：F(3) = F(2) + F(1) = 1 + 1 = 2
示例 3：

输入：n = 4
输出：3
解释：F(4) = F(3) + F(2) = 2 + 1 = 3

提示：
dp[i] : 第i个斐波那契数
dp[i] =dp[i-1] + dp[i-2]
dp数组如何初始化 dp[0] = 1 dp[1] =1
* 遍历顺序 从前向后
* 打印dp数组：验证数组
*

0 <= n <= 30
* */
public class leetcode_509 {
    public static void main(String[] args) {
        int k = fib(2);
        System.out.println(k);
    }
    public static int fib(int n) {
        int[] dp = new int[n+1];
        // if要写在前面
        if (n <= 1) return n;
        dp[0] = dp[1] = 1 ;
        for (int i = 2 ; i < n; i++) {
            dp[i] = dp[i-1] + dp[i-2];
            System.out.println(dp[i]);
        }
        return dp[n-1];
    }
}
