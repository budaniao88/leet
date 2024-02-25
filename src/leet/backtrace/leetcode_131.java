package leet.backtrace;
/*分割回文串*/
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class leetcode_131 {
    List<List<String>> res = new ArrayList<>();
    List<String> path = new LinkedList<>();
    public List<List<String>> partition(String s) {
        backtracking(s,0);
        return res;
    }
    public void backtracking(String s , int starindex){
        if(s.length() <= starindex){
            res.add(new ArrayList<>(path));
            return;
        }
        for(int i = starindex;i<s.length();i++){
            if(isPaliddrome(s,starindex,i)){
                path.add(s.substring(starindex,i+1));
            }else continue;
            backtracking(s,i+1);
            path.remove(path.size()-1);
        }
    }
    public boolean isPaliddrome(String s , int starindex,int end){
        for(int i = starindex, j=end ; i<j ; i++ , j--){
            if(s.charAt(i)!=s.charAt(j)){
                return false;
            }
        }
        return true;
    }
}
