import java.util.*;

class Solution {
    public int solution(String s) {
        String extendedS = s + s;
        int ans = 0; // 리턴할 값
        
        for (int i=0; i<s.length(); i++) { // s의 길이만큼 순회
            // isValid가 true면 유효한 괄호이므로 ans++;
            if (isValid(extendedS.substring(i, s.length()+i))) ans++;
        }
        return ans;
    }
    
    public boolean isValid(String s) { // 유효한 괄호인지 체크
        Deque<Character> stack = new ArrayDeque<>();
        
        for (char current : s.toCharArray()) {
            if (current == '(' || current == '{' || current == '[') {
                stack.push(current); // 여는 괄호면 스택에 넣기
            } else {
                // 닫는 괄호일 때 스택이 비어있다면 짝 여는 괄호가 없는 것
                if (stack.isEmpty()) return false; 
                
                char target = stack.pop();
                if ((target == '(' && current != ')') ||
                   (target == '{' && current != '}') ||
                   (target == '[' && current != ']')) {
                    return false;
                }
            }
        }
        return stack.isEmpty(); // 최종적으로 비어있으면 유효한 괄호
    }
}