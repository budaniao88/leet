package leet.oridnaryarr;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/*
*56. 合并区间
已解答
中等
相关标签
相关企业
  以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。
* 请你合并所有重叠的区间，并返回 一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间 。
*
*
示例 1：
输入：intervals = [[1,3],[2,6],[8,10],[15,18]]
输出：[[1,6],[8,10],[15,18]]
解释：区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
示例 2：

输入：intervals = [[1,4],[4,5]]
输出：[[1,5]]
解释：区间 [1,4] 和 [4,5] 可被视为重叠区间。


提示：

1 <= intervals.length <= 104
intervals[i].length == 2
0 <= starti <= endi <= 104
* */
public class leetcode_56 {
    public int[][] merge(int[][] intervals) {
        List<int[]> res = new LinkedList<>();
        Arrays.sort(intervals,(x,y)->Integer.compare(x[0],y[0]));
        // 此时已经排序完
        int start = intervals[0][0];
        int rightmostRightBonds = intervals[0][1];
        for (int i = 1; i < intervals.length ; i++) {
            //如果右小于左 添加老元素
            if (intervals[i][0] > rightmostRightBonds){
                res.add(new int[]{start,rightmostRightBonds});
                // 更新元素
                start = intervals[i][0];
                rightmostRightBonds = intervals[i][1];
            }else{
                // 如果右大于左 ， 更新右端元素 且 不添加
                rightmostRightBonds = Math.max(rightmostRightBonds,intervals[i][1]);
            }
        }
        res.add(new int[]{start,rightmostRightBonds});
        // res.toArray(new int[res.size()][]) 的作用是创建一个恰好与列表 res 大小相匹配的二维数组，
        // 并将 res 中的所有区间拷贝到这个新数组中，然后返回它。
        return res.toArray(new int[0][]);
    }
}
