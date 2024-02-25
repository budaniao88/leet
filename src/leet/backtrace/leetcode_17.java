package leet.backtrace;

import java.util.ArrayList;
import java.util.List;

public class leetcode_17 {
    List<String> res = new ArrayList<>();
    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0) return  res;
        String[] numString = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        backTracking(digits,numString,0);
        return res;
    }
    StringBuilder sb = new StringBuilder();
    private void backTracking(String digits, String[] nums, int num) {
        if (num == digits.length()) {
            res.add(sb.toString());
            return;
        }
        String str = nums[digits.charAt(num) - '0'];
        for (int i = 0; i < str.length(); i++) {
            sb.append(str.charAt(i));
            backTracking(digits,nums,num+1);
            sb.deleteCharAt(sb.length() - 1 );
        }
    }
}
