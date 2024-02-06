package leet.dp;
/*
*
* 377. 组合总和 Ⅳ
力扣题目链接(opens new window)

难度：中等

给定一个由正整数组成且不存在重复数字的数组，找出和为给定目标正整数的组合的个数。

示例:

nums = [1, 2, 3]
target = 4
所有可能的组合为： (1, 1, 1, 1) (1, 1, 2) (1, 2, 1) (1, 3) (2, 1, 1) (2, 2) (3, 1)

请注意，顺序不同的序列被视作不同的组合。

因此输出为 7。
* */
public class leetcode_377 {
    public int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int j = 0; j <= target; j++) {
            for (int i = 0; i < nums.length; i++) {
                if (j - nums[i] >= 0)
                    dp[j] += dp[j-nums[i]];
            }
        }
        return dp[target];
    }
}
