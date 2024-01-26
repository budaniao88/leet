package leet.oridnaryarr;
/*
*41. 缺失的第一个正数
困难
相关标签
相关企业
提示
给你一个未排序的整数数组 nums ，请你找出其中没有出现的最小的正整数。

请你实现时间复杂度为 O(n) 并且只使用常数级别额外空间的解决方案。
示例 1：

输入：nums = [1,2,0]
输出：3
示例 2：

输入：nums = [3,4,-1,1]
输出：2
示例 3：

输入：nums = [7,8,9,11,12]
输出：1


提示：

1 <= nums.length <= 5 * 105
-231 <= nums[i] <= 231 - 1
* */

public class leetcode_41 {
    public int firstMissingPositive(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            // 此时要将0也转换防止索引越界
            if (nums[i] <= 0){
                nums[i] = nums.length + 1;
            }
        }
        // 打标记
        for (int i = 0; i < nums.length; i++) {
            int n = Math.abs(nums[i]);
            if (n<=nums.length){
                nums[n-1] = -Math.abs(nums[n-1]);
            }
        }
        // 此时返回值为 i + 1
        for (int i = 0; i < nums.length; i++) {
            if (nums[i]>0){
                return i+1;
            }
        }
        return nums.length+1;
    }
}
