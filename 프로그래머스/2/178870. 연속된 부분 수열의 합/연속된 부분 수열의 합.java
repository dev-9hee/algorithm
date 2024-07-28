class Solution {
    public int[] solution(int[] sequence, int k) {
        int[] answer = {0, 1000000};
        
        int total = 0; // 현재 부분 배열의 합
        int start = 0; // 현재 부분 배열의 시작 인덱스
        
        for (int end = 0; end < sequence.length; end++) {
            total += sequence[end];
            
            while (total > k) {
                total -= sequence[start];
                start++;
            }
            
            // 길이가 짧은 수열 => 시작인덱스가 작은 수열
            if (total == k && ((end-start) < (answer[1]-answer[0]))) {
                answer[0] = start;
                answer[1] = end;
            }
        }
        return answer;
    }
}