import java.util.*;

class Solution {
    Set<Integer> candidates = new HashSet<>(); // 소수 후보들
    
    public int solution(String numbers) {
        // 숫자 조합
        permutation(numbers, 0, new boolean[numbers.length()], 0);
        // 소수 찾기
        int ans = 0;
        for (int num : candidates) {
            if (isPrime(num)) ans++; // isValid()가 true면 소수
        }
        return ans;
    }
    
    // 숫자문자열, 현재수, 방문여부, 현재 자릿수
    void permutation(String numbers, int cur, boolean[] visited, int digit) {
        if (digit == numbers.length()) return;
        
        for (int i=0; i<numbers.length(); i++) {
            if (visited[i]) continue; // 이미 방문
            
            int newValue = cur + (int)((numbers.charAt(i) - '0') * Math.pow(10, digit));
            candidates.add(newValue); // 새로운 숫자 조합을 후보에 추가
            
            visited[i] = true;
            permutation(numbers, newValue, visited, digit + 1);
            visited[i] = false;
        }
    }
    
    // 소수 판별
    boolean isPrime(int n) {
        if (n < 2) return false;
        
        for (int i=2; i*i<=n; i++) {
            if (n % i == 0) return false;
        }
        
        return true;
    }
}