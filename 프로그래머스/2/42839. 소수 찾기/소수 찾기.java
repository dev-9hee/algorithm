import java.util.*;

class Solution {
    Set<Integer> candidates = new HashSet<>();
    
    public int solution(String numbers) {
        // 순열조합, 숫자 조합
        per(numbers, 0, new boolean[numbers.length()], 0);
        
        // 소수 찾기
        int ans = 0;
        for (int num : candidates) {
            if(isPrime(num)) ans++; // 소수면 개수 증가
        }
        return ans;
    }
    
    // 숫자 문자열, 현재 숫자, 방문여부, 현재 자릿수
    void per(String numbers, int cur, boolean[] visited, int digit) {
        if (digit == numbers.length()) return;
        
        for (int i=0; i<numbers.length(); i++) {
            if(visited[i]) continue; // 이미 방문
            
            int newValue = cur + (int)((numbers.charAt(i) - '0') * Math.pow(10, digit));
            candidates.add(newValue); // hashset에 추가
            
            visited[i] = true;
            per(numbers, newValue, visited, digit + 1);
            visited[i] = false;
        }
    }
    
    boolean isPrime(int num) {
        if (num < 2) return false;
        
        for (int i=2; i*i<=num; i++) {
            if (num % i == 0) return false;
        }
        
        return true;
    }
}