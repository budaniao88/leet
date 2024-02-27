package stack;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class leetcode_20 {
    public boolean isValid(String s) {
        Map<Character,Character> map = new HashMap<>();
        Deque<Character> stack = new LinkedList<>();
        map.put(')', '(');
        map.put(']', '[');
        map.put('}', '{');
        for(Character c : s.toCharArray()){
            // 为右括号则比较
            if(map.containsKey(c)) {
                if(stack.isEmpty() || stack.peek() != map.get(c)){
                    return false;
                }
                stack.pop();
            }
            // 为左括号则添加
            else {
                stack.push(c);
            }
        }
        return stack.isEmpty();
    }
}
