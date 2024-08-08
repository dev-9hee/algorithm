import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        Deque<Integer> stack = new ArrayDeque<>();
        
        // 주식 가격 순회
        for (int i=0; i<prices.length; i++) {
            while (!stack.isEmpty()) {
                int j = stack.peek();
                
                if (prices[j] > prices[i]) {
                    answer[j] = i - j;
                    stack.pop();
                }
                else break;
            }
            stack.push(i); // 인덱스 값 스택에 추가
        }
        
        // 끝까지 가격이 안 떨어짐
        while (!stack.isEmpty()) {
            int idx = stack.pop();
            answer[idx] = prices.length - idx - 1;
        }
        
        return answer;
    }
}