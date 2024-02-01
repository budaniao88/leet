package leet.dp;
/*
* //416. 分割等和子集
//力扣题目链接(opens new window)
//
//题目难易：中等
//
//给定一个只包含正整数的非空数组。是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。
//
//注意: 每个数组中的元素不会超过 100 数组的大小不会超过 200
//
//示例 1:
//
//输入: [1, 5, 11, 5]
//输出: true
//解释: 数组可以分割成 [1, 5, 5] 和 [11].
//示例 2:
//
//输入: [1, 2, 3, 5]
//输出: false
//解释: 数组不能分割成两个元素和相等的子集.
//提示：
//
//1 <= nums.length <= 200
//1 <= nums[i] <= 100
//#算法公开课
* */
public class leetcode_416 {
    public boolean canPartition(int[] nums) {
        if (nums == null || nums.length == 0)
            return false;
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        // 余数为0
        if (sum%2 != 0) return false;
        // 除二为值
        int target = sum/2;
        // 初始化即为默认值0 ， 只需要一半
        int[] dp = new int[target + 1];
        // 遍历背包物品 数组中每一个值为length
        for (int i = 0; i < nums.length; i++) {
            // 遍历背包容量  为什么到nums[i]就结束了
            for (int j = target; j >= nums[i] ; j--) {
                dp[j] = Math.max(dp[j],dp[j-nums[i]]+nums[i]);
            }
            // 剪枝 避免全部循环
            if (dp[target] == target) return true;
        }
        return dp[target] == target;
    }
}
