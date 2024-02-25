package binaryway;

public class leetcode_74 {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rowIndex = binaryFind(matrix,target);
        if(rowIndex < 0){
            return false;
        }
        return binaryFindInRow(matrix[rowIndex],target);
    }
    public int binaryFind(int[][] matrix,int target){
        // 左闭右闭的二分法
        int low = 0 ; int high = matrix.length - 1;
        while(low <= high){
            int mid = (low + high)>>>1;
            if(matrix[mid][0] > target){
                high = mid - 1 ;
            }else {
                low = mid + 1;
            }
        }
        return low - 1;
    }
    public boolean binaryFindInRow(int[] matrix , int target){
        int left = 0 ; int right = matrix.length - 1;
        while(left <= right){
            int mid = (left + right)>>>1;
            if(target > matrix[mid]){
                left = mid + 1 ;
            }else if(target < matrix[mid]){
                right = mid - 1;
            }else{
                return true;
            }
        }
        return false;
    }
}
