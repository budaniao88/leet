package stack;

import java.util.Deque;
import java.util.LinkedList;

public class leetcode_739 {
    public int[] dailyTemperatures(int[] temperatures) {
        int length =temperatures.length;
        int[] ans = new int[length];
        Deque<Integer> stack = new LinkedList<Integer>();
        for(int i = 0; i<length ; i++){
            int temperature = temperatures[i];
            // 当前温度比栈顶元素大时 更新值，初始化时有默认值0
            while(!stack.isEmpty()&&temperature>temperatures[stack.peek()]){
                int prevIndex = stack.pop();
                ans[prevIndex] = i - prevIndex;
            }
            // 否则存索引
            stack.push(i);
        }
        return ans;
    }
}
