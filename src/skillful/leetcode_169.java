package skillful;

public class leetcode_169 {
    public int majorityElement(int[] nums) {
        // 设重数为x vote为投票
        int vote = 0;
        int x = 0;
        for(int num : nums){
            if(vote == 0) x = num;
            vote += num == x ? 1 : -1;
        }
        return x;
    }
}
