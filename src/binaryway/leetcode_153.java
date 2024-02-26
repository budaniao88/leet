package binaryway;

public class leetcode_153 {
    public int findMin(int[] nums) {
        int left = 0 ;
        int right = nums.length -1 ;
        if(right==0) return nums[0];
        while(left < right){
            int mid = (left + right)>>>1;
            // 左边是有序数组
            if(nums[mid]<nums[right]){
                right = mid;
            }else if(nums[mid]>nums[right]){
                left = mid+1;
            }
        }
        return nums[right];
    }
}
