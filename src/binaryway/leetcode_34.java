package binaryway;

public class leetcode_34 {
    public int[] searchRange(int[] nums, int target) {
        int leftInedex = binarySearch(nums,target,true);
        int rightIndex = binarySearch(nums,target,false) - 1;
        if(leftInedex <= rightIndex && leftInedex >=0 && rightIndex<=nums.length-1&&target == nums[leftInedex]&&target == nums[rightIndex])
            return new int[]{leftInedex,rightIndex};
        return new int[]{-1,-1};
    }
    public int binarySearch(int[]nums,int target,boolean flag){
        int low = 0 ; int higt = nums.length -1 ; int ans = nums.length;
        while(low<=higt){
            int mid = (low + higt)>>>1;
            if(target < nums[mid]||(flag && target <= nums[mid])){
                higt = mid - 1;
                ans = mid;
            }else{
                low = mid + 1;
            }
        }
        return ans;
    }
}
