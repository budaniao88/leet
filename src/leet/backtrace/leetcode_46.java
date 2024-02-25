package leet.backtrace;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
/*
*
46. 全排列

给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。


示例 1：

输入：nums = [1,2,3]
输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
示例 2：

输入：nums = [0,1]
输出：[[0,1],[1,0]]
示例 3：

输入：nums = [1]
输出：[[1]]


提示：

1 <= nums.length <= 6
-10 <= nums[i] <= 10
nums 中的所有整数 互不相同
* */

public class leetcode_46 {
    List<List<Integer>> res = new ArrayList<List<Integer>>();
    List<Integer> path = new ArrayList<Integer>();
    boolean[] used ;
    public List<List<Integer>> permute(int[] nums) {

        if(nums.length == 0) return res;
        used = new boolean[nums.length];
        // used 数组用来记录并剪枝
        backtracking(nums,used);
        return res;
        }

    private void backtracking(int[] nums, boolean[] used) {
        if (path.size() == nums.length){
            res.add(new ArrayList<>(path));
            return;
    }
        for (int i = 0; i < nums.length; i++) {
            if (used[i] == true)continue;
            used[i] = true;
            path.add(nums[i]);
            backtracking(nums,used);
            path.remove(path.size()-1);
            used[i] = false;
        }
    }
}
