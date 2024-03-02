package skillful;

public class leetcode_136 {
    public int singleNumber(int[] nums) {
        // 至少没有一次
        int single = 0;
        for(int num : nums){
            single ^= num;
        }
        return single;
    }
}
