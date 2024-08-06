class Solution {
    public int solution(int[] numbers, int target) {
        // dfs 호출
        return dfs(numbers, 0, target, 0);
    }
    
    public int dfs(int[] numbers, int index, int target, int cur) {
        // base case
        if (index == numbers.length) {
            return (cur == target) ? 1 : 0;
        }
        
        // 재귀
        int sum = 0;
        sum += dfs(numbers, index+1, target, cur + numbers[index]);
        sum += dfs(numbers, index+1, target, cur - numbers[index]);
        
        return sum;
    }
}