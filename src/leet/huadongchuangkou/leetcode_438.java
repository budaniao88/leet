package leet.huadongchuangkou;
/*
* 给定两个字符串 s 和 p，找到 s 中所有 p 的 异位词 的子串，返回这些子串的起始索引。不考虑答案输出的顺序。

异位词 指由相同字母重排列形成的字符串（包括相同的字符串）。

示例 1:

输入: s = "cbaebabacd", p = "abc"
输出: [0,6]
解释:
起始索引等于 0 的子串是 "cba", 它是 "abc" 的异位词。
起始索引等于 6 的子串是 "bac", 它是 "abc" 的异位词。
 示例 2:

输入: s = "abab", p = "ab"
输出: [0,1,2]
解释:
起始索引等于 0 的子串是 "ab", 它是 "ab" 的异位词。
起始索引等于 1 的子串是 "ba", 它是 "ab" 的异位词。
起始索引等于 2 的子串是 "ab", 它是 "ab" 的异位词。


提示:

1 <= s.length, p.length <= 3 * 104
s 和 p 仅包含小写字母*/


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.PrimitiveIterator;

/**
 leetcode_438
 */
public class leetcode_438 {
    public List<Integer> findAnagrams(String s, String p) {
    HashMap<Character,Integer> need = new HashMap<>();
    HashMap<Character,Integer> window = new HashMap<>();
    List<Integer> res = new ArrayList<>();
    for (char c : p.toCharArray()){
        need.put(c,need.getOrDefault(c,0)+1);
    }
    int left = 0;
    int right= 0;
    int valid = 0;
    while (right < s.length()) {
        // 执行右移操作
        char c = s.charAt(right);
        right++;
        // 对窗口内数据进行更新
        if (need.containsKey(c)) {
            window.put(c, window.getOrDefault(c, 0) + 1);
            if (window.get(c).equals(need.get(c))) {
                valid++;
            }
        }
            // 判断是否需要收缩
            while (right - left >= p.length()) {
                // 将起始索引加入res
                if (valid == need.size()) {
                    res.add(left);
                }
                char d = s.charAt(left);

                if (need.containsKey(d)) {
                    if (need.get(d).equals(window.get(d))) {
                        valid--;
                    }
                    window.put(d, window.getOrDefault(d,0) - 1);
                }
                left++;
            }
        }

    return res;
    }
}

