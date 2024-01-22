package leet.huadongchuangkou;


import java.util.HashMap;

/*

76. 最小覆盖子串
困难
相关标签
相关企业
提示
给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。



注意：

对于 t 中重复字符，我们寻找的子字符串中该字符数量必须不少于 t 中该字符数量。
如果 s 中存在这样的子串，我们保证它是唯一的答案。


示例 1：

输入：s = "ADOBECODEBANC", t = "ABC"
输出："BANC"
解释：最小覆盖子串 "BANC" 包含来自字符串 t 的 'A'、'B' 和 'C'。
示例 2：

输入：s = "a", t = "a"
输出："a"
解释：整个字符串 s 是最小覆盖子串。
示例 3:

输入: s = "a", t = "aa"
输出: ""
解释: t 中两个字符 'a' 均应包含在 s 的子串中，
因此没有符合条件的子字符串，返回空字符串。


提示：

m == s.length
n == t.length
1 <= m, n <= 105
s 和 t 由英文字母组成
*/
public class leetcode_76 {
    public String minWindow(String s, String p) {
        HashMap<Character,Integer> need = new HashMap<>();
        HashMap<Character,Integer> window = new HashMap<>();
        for (char c : p.toCharArray()){
            need.put(c, need.getOrDefault(c,0)+1);
        }
        int left = 0 ;
        int right = 0;
        int valid = 0;
        int start = 0;
        int len = Integer.MAX_VALUE;
        // 先行逻辑：一直右扩充窗口使得包含目标串
        while (right < s.length()){
            char c = s.charAt(right);
            right ++;
            if (need.containsKey(c)){
                window.put(c,window.getOrDefault(c,0)+1);
                if (window.get(c).equals(need.get(c))) valid++;
            }

            while (valid == need.size()){
                if(right - left < len){
                    start = left;
                    len = right - left;
                }
                char d = s.charAt(left);
                left ++;
                // 执行左收缩逻辑的时候 判断是否valid要减一
                if (need.containsKey(d)){
                    // 不能用== 进行判断 ， == 比较的是地址值
                    if (window.get(d).equals(need.get(d))){
                        valid -- ;
                    }
                    window.put(d,window.get(d)-1);
                }
            }
        }
        return len == Integer.MAX_VALUE ? "" : s.substring(start,start+len);
    }
}
