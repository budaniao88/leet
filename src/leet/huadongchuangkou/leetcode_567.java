package leet.huadongchuangkou;

import java.util.HashMap;

/*
* 给你两个字符串 s1 和 s2 ，写一个函数来判断 s2 是否包含 s1 的排列。如果是，返回 true ；否则，返回 false 。

换句话说，s1 的排列之一是 s2 的 子串 。



示例 1：

输入：s1 = "ab" s2 = "eidbaooo"
输出：true
解释：s2 包含 s1 的排列之一 ("ba").
示例 2：

输入：s1= "ab" s2 = "eidboaoo"
输出：false
* */
public class leetcode_567 {
    // 分析：这种题题目明显是窗口滑动的题目。 给一个s2判断s1中是否有s2。
    public boolean checkInclusion(String s2, String s1) {
        HashMap<Character, Integer> need = new HashMap<>();
        HashMap<Character, Integer> window = new HashMap<>();
        for (char c : s2.toCharArray()) {
            need.put(c, need.getOrDefault(c, 0) + 1);
        }
        int left = 0;
        int right = 0;
        int valid = 0;
        while (right < s1.length()) {
            char c = s1.charAt(right);
            right++;
            if (need.containsKey(c)) {
                window.put(c, window.getOrDefault(c, 0) + 1);
                if (need.get(c).equals(window.get(c))) {
                    valid++;
                }
            }
            while (right - left >= s2.length()) {
                if (valid == need.size())
                    return true;
                char d = s1.charAt(left);
                left++;
                if (need.containsKey(d)) {
                    if (window.get(d).equals(need.get(d)))
                        valid--;

                        window.put(d, window.get(d) - 1);
                }
            }
        }
        return false;
    }
}
