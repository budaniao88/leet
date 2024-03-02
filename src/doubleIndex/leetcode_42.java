package doubleIndex;

public class leetcode_42 {
    public int trap(int[] height) {
        int sum = 0;
        int left = 0;
        int right = height.length - 1;
        int leftMax = 0;
        int rightMax = 0;
        while(left < right){
            leftMax = Math.max(leftMax,height[left]);
            rightMax = Math.max(rightMax,height[right]);
            if(height[left]<height[right]){
                sum = sum + leftMax - height[left];
                ++left;
            }else{
                sum = sum + rightMax - height[right];
                --right;
            }
        }
        return sum;
    }
}
