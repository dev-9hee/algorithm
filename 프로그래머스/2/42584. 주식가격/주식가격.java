import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length]; // 가격이 떨어지지 않은 기간
        Deque<Integer> stack = new ArrayDeque<>(); // 스택 사용
        
        // 주식 가격 순회
        for (int i=0; i<prices.length; i++) {
            while (!stack.isEmpty()) { // 스택이 빌 때까지 반복
                int j = stack.peek(); // 단순히 맨 위의 값 반환
                
                if (prices[j] > prices[i]) {
                    answer[j] = i - j;
                    stack.pop();
                }
                else break;
            }
            stack.push(i); // 스택에 인덱스 i 값 추가
        }
        
        // 끝까지 가격이 떨어지지 않는 경우
        while (!stack.isEmpty()) {
            int idx = stack.pop();
            answer[idx] = prices.length - idx -1;
        }
        
        return answer;
    }
}