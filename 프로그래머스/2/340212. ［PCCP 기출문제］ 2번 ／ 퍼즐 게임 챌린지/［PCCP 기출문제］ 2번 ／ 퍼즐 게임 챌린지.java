import java.util.*;
class Solution {
    public int solution(int[] diffs, int[] times, long limit) {
        //이진 탐색
        int maxValue = Arrays.stream(diffs).max().getAsInt(); //최대값
        int minValue = 1; //최소값
        int level = (maxValue + minValue) / 2; //중간값
        
        // 값이 하나도 없을때까지
        while (minValue <= maxValue) { 
            long time = calTime(diffs, times, level);
            // limit 보다 작으면 레벨을 -1해서 계산 후 크다면 리턴 작으면 최소값 포인트 이동, 크면 최대값 포인트 이동
            if(limit == time) {
                return level;
            } else if(limit > time) {
            	// 레벨 1에 대한 체크 꼭해주기	
                long nextTime = level == 1 ? limit+1 : calTime(diffs, times, level-1);
                //레벨이 높을수록 리밋은 내려간다.
                if(limit < nextTime) {
                    return level;
                } else {
                    maxValue = level-1;
                }
            } else {
                minValue = level+1;
            }
            
            level = (maxValue + minValue) / 2;
        }
        
        return -1;
    }
    
    private long calTime(int[] diffs, int[] times, int level) {
        long time = 0;
        for(int i=0; i<diffs.length; i++) {
            int levDiff = diffs[i] - level;

            if(levDiff <= 0) { //작거나 같으면 문제 난이도가 더 낮으므로 원래 시간만 써 해결
                time += times[i];
            } else {
                //증가값 = (전 시간 + 현재시간) * 틀린횟수 + 현재시간
                int preTime = i == 0 ? 0 : times[i-1]; 
                int nowTime = times[i];
                int addValue = (preTime + nowTime) * levDiff + nowTime;

                time += addValue;
            } 
        }
        
        return time;
    }
}