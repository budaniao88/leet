package leet.matrix;
/*
*73. 矩阵置零
中等
相关标签
相关企业
提示
给定一个 m x n 的矩阵，如果一个元素为 0 ，则将其所在行和列的所有元素都设为 0 。请使用 原地 算法。



示例 1：


输入：matrix = [[1,1,1],[1,0,1],[1,1,1]]
输出：[[1,0,1],[0,0,0],[1,0,1]]
示例 2：


输入：matrix = [[0,1,2,0],[3,4,5,2],[1,3,1,5]]
输出：[[0,0,0,0],[0,4,5,0],[0,3,1,0]]


提示：

m == matrix.length
n == matrix[0].length
1 <= m, n <= 200
-231 <= matrix[i][j] <= 231 - 1
*
* */
public class leetcode_73 {
    public void setZeroes(int[][] matrix) {
        int m = matrix.length ;
        int n = matrix[0].length;
        boolean flagCol = false;
        boolean flagRow = false;
        for (int i = 0; i < m ; i++) {
            if (matrix[i][0]==0){
                flagCol = true;
            }
        }
        for (int j = 0; j < n ; j++) {
            if (matrix[0][j]==0){
                flagRow = true;
            }
        }
        // 用第一行和第一列标记位置
        for (int i = 1; i < m ; i++) {
            for (int j = 1; j < n ; j++) {
                if (matrix[i][j]==0){
                    matrix[i][0]=matrix[0][j]=0;
                }
            }
        }
        // 根据标记位置 填入0
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][0]==0||matrix[0][j]==0){
                    matrix[i][j] = 0 ;
                }
            }
        }
        if (flagCol){
            for (int i = 0; i < m; i++) {
                matrix[i][0] = 0 ;
            }
        }
        if (flagRow){
            for (int i = 0; i < n; i++) {
                matrix[0][i] = 0;
            }
        }
    }
}
