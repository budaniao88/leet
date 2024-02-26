package binaryway;

public class leetcode_33 {
    public int search(int[] nums, int target) {
        int n = nums.length;
        int left = 0;
        int right= n -1;
        if(n == 0)return -1;
        if(n== 1)return target==nums[0]?0:-1;
        while(left<=right){
            int mid = (left + right)>>>1;
            if(nums[mid]==target) return mid;
            if(nums[0]<=nums[mid]){
                if(nums[0]<=target && target <nums[mid]){
                    right = mid - 1;
                }else{
                    left = mid + 1;
                }
            }else{
                // 一部分一定有序 另一部分可能有序
                if(nums[mid]<=target&&target <=nums[right]){
                    left = mid + 1;
                }else{
                    right = mid - 1;
                }
            }
        }
        return -1;
    }
}
