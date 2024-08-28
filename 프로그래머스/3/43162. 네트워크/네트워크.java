import java.util.*;

class Solution {
    public int solution(int n, int[][] computers) {
        int count = 0; // 네트워크 수
        boolean[] visited = new boolean[n];
        
        for (int i=0; i<n; i++) {
            if (visited[i]) continue; // 이미 방문, 패스!!
            dfs(n, computers, visited, i);
            count++; // 네트워크 수 증가
        }
        return count;
    }
    
    // cur : 현재 방문 컴퓨터
    void dfs(int n, int[][] computers, boolean[] visited, int cur) {
        visited[cur] = true; // 방문 처리
        
        for (int i=0; i<n; i++) {
            // 아직 방문하지 않았고 현재 컴퓨터와 연결되어 있다면
            if (!visited[i] && computers[cur][i] == 1) {
                dfs(n, computers, visited, i);
            }
        }
    }
}