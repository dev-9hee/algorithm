import java.util.*;

class Solution {
    public int solution(String s) {
        String extendedS = s + s;
        int ans = 0; // x의 개수, 리턴할 값
        
        for (int i=0; i<s.length(); i++) {
            // isValid()가 true면 올바른 괄호이므로 ans++;
            if (isValid(extendedS.substring(i, s.length()+i))) ans++;
        }
        return ans;
    }
    
    public boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>(); // 스택선언
        
        for (char current : s.toCharArray()) {
            if (current == '(' || current == '{' || current == '[') {
                stack.push(current);
            } else {
                if (stack.isEmpty()) return false;
                
                char target = stack.pop();
                if ((target == '(' && current != ')') ||
                   (target == '{' && current != '}') ||
                   (target == '[' && current != ']')) {
                    return false;
                }
            }
        }
        return stack.isEmpty(); // 비어있으면 true => 올바른 괄호
    }
}