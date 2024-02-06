package leet.dp;
/*
*139. 单词拆分
中等
相关标签
相关企业
给你一个字符串 s 和一个字符串列表 wordDict 作为字典。如果可以利用字典中出现的一个或多个单词拼接出 s 则返回 true。

注意：不要求字典中出现的单词全部都使用，并且字典中的单词可以重复使用。



示例 1：

输入: s = "leetcode", wordDict = ["leet", "code"]
输出: true
解释: 返回 true 因为 "leetcode" 可以由 "leet" 和 "code" 拼接成。
示例 2：

输入: s = "applepenapple", wordDict = ["apple", "pen"]
输出: true
解释: 返回 true 因为 "applepenapple" 可以由 "apple" "pen" "apple" 拼接成。
     注意，你可以重复使用字典中的单词。
示例 3：

输入: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
输出: false


提示：

1 <= s.length <= 300
1 <= wordDict.length <= 1000
1 <= wordDict[i].length <= 20
s 和 wordDict[i] 仅由小写英文字母组成
wordDict 中的所有字符串 互不相同
*
* */
import java.util.List;

public class leetcode_139 {
    public boolean wordBreak(String s, List<String> wordDict) {
        //  dp[i]:字符串前i个字符是否可以被完全拆分
        // 这里背包：s
        // 物品：字典中的每一个单词
        // 内部正序遍历
        // bool dp[i] =
        boolean[] dp = new boolean[s.length()+1];
        dp[0] = true;
        // 先遍历背包
        for (int i = 1; i <=s.length(); i++) {
            //遍历物品
            for (String word : wordDict) {
                if (word.length() <= i && dp[i-word.length()]){
                    if (s.substring(i-word.length(),i).equals(word)){
                        dp[i] = true;
                        break;
                    }
                }
            }
        }
        return dp[s.length()];
    }
}
