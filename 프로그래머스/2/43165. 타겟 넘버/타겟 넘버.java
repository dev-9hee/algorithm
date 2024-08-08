class Solution {
    public int solution(int[] numbers, int target) {
        // bfs 리턴
        return bfs(numbers, 0, target, 0);
    }
    
    public int bfs(int[] numbers, int idx, int target, int cur) {
        // base-case
        if (idx == numbers.length) {
            return (cur == target) ? 1 : 0;
        }
        
        // 재귀 호출
        int sum = 0;
        sum += bfs(numbers, idx + 1, target, cur + numbers[idx]);
        sum += bfs(numbers, idx + 1, target, cur - numbers[idx]);
        
        return sum;
    }
}