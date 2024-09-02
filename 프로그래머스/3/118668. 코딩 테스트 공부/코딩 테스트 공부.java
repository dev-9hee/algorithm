class Solution {
    public int solution(int alp, int cop, int[][] problems) {
        int answer = 0;
        int alp_target = 0;
        int cop_target = 0;
        
        for (int i=0; i<problems.length; i++) {
            alp_target = Math.max(problems[i][0], alp_target); // 알고력 최종 목표값
            cop_target = Math.max(problems[i][1], cop_target); // 코딩력 최종 목표값
        }
        
        if (alp >= alp_target && cop >= cop_target) {
            return 0;    
        }
        
        // 처음 설정된 알고력이 최종 목표값보다 높을 경우
        if (alp >= alp_target) {
            alp = alp_target;
        }
        
        // 처음 설정된 코딩력이 최종 목표값보다 높을 경우
        if (cop >= cop_target) {
            cop = cop_target;
        }
        
        int[][] dp = new int[alp_target+2][cop_target+2]; // 최종 목표값 +2 만큼 크기의 dp 배열 생성
        for (int i=alp; i<=alp_target; i++) {
            for (int j=cop; j<=cop_target; j++) {
                dp[i][j] = Integer.MAX_VALUE;
            }
        }
        
        dp[alp][cop] = 0;
        for (int i=alp; i<=alp_target; i++) {
            for (int j=cop; j<=cop_target; j++) {
            
                // 공부하기
                dp[i+1][j] = Math.min(dp[i+1][j], dp[i][j]+1);
                dp[i][j+1] = Math.min(dp[i][j+1], dp[i][j]+1);
                
                for (int m=0; m<problems.length; m++) {
					
                    // 현재 알고력과 코딩력이 문제를 해결할 수 있는 조건을 넘었을 경우
                    if (i >= problems[m][0] && j >= problems[m][1]) {
						
                        // 알고력과 코딩력이 목표치를 넘었을 경우
                        if (i+problems[m][2] > alp_target && j+problems[m][3] > cop_target) {
                            dp[alp_target][cop_target] = Math.min(dp[alp_target][cop_target], dp[i][j] + problems[m][4]);
                        } // 알고력이 목표치를 넘겼을 경우
                        else if (i+problems[m][2] > alp_target) {
                            dp[alp_target][j+problems[m][3]] = Math.min(dp[alp_target][j+problems[m][3]], dp[i][j]+problems[m][4]);
                        } // 코딩력이 목표치를 넘겼을 경우
                        else if (j+problems[m][3] > cop_target) {
                            dp[i+problems[m][2]][cop_target] = Math.min(dp[i+problems[m][2]][cop_target],dp[i][j]+problems[m][4]);
                        } // 목표치에 도달하지 못 한 경우
                        else if (i+problems[m][2] <= alp_target && j+problems[m][3] <= cop_target){
                            dp[i+problems[m][2]][j+problems[m][3]] = Math.min(dp[i+problems[m][2]][j+problems[m][3]],dp[i][j]+problems[m][4]); 
                        }
                    }
                }
            }
	    }
        answer = dp[alp_target][cop_target];
        return answer;
    }
}