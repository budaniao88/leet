package leet.matrix;
/*
*
* 54. 螺旋矩阵
提示
给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。

示例 1：


输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
输出：[1,2,3,6,9,8,7,4,5]
示例 2：

输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
输出：[1,2,3,4,8,12,11,10,9,5,6,7]

提示：

m == matrix.length
n == matrix[i].length
1 <= m, n <= 10
-100 <= matrix[i][j] <= 100
* */

import java.util.ArrayList;
import java.util.List;

public class leetcode_54 {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<Integer>();
        if(matrix == null) return res;
        int rowBegin = 0; // 行索引
        int rowEnd = matrix.length - 1;
        int colBegin = 0;
        int colEnd = matrix[0].length - 1;
        while (rowBegin <= rowEnd && colBegin <= colEnd){
            for (int i = colBegin; i <= colEnd ; i++) {
                res.add(matrix[rowBegin][i]);
            }
            rowBegin++;
            for (int i = rowBegin ; i <= rowEnd ; i++) {
                res.add(matrix[i][colEnd]);
            }
            colEnd--;
            if (rowBegin<=rowEnd){
                for (int i = colEnd; i >= colBegin ; i--) {
                    res.add(matrix[rowEnd][i]);
                }
            }
            rowEnd --;
            if (colBegin<=colEnd){
                for (int i = rowEnd; i >= rowBegin ; i--) {
                    res.add(matrix[i][colBegin]);
                }
            }
            colBegin++;
        }
        return res;
    }
}
