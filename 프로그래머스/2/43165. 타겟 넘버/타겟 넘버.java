class Solution {
    public int solution(int[] numbers, int target) {
        // dfs 리턴
        return dfs(numbers, 0, target, 0);
    }
    
    public int dfs(int[] numbers, int idx, int target, int cur) {
        // base-case
        if (idx == numbers.length) {
            return (cur == target) ? 1 : 0;
        }
        
        // 재귀 호출
        int sum = 0;
        sum += dfs(numbers, idx + 1, target, cur + numbers[idx]);
        sum += dfs(numbers, idx + 1, target, cur - numbers[idx]);
        
        return sum;
    }
}