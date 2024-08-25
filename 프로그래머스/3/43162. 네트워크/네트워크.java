class Solution {
    public int solution(int n, int[][] computers) {
        int count = 0; // 네트워크 개수
        boolean[] visited = new boolean[n]; // 방문 표시
        
        for (int i=0; i<n; i++) {
            if (visited[i]) continue; // 이미 방문했다면 뛰어 넘기
            dfs(n, computers, visited, i);
            count++; // 네트워크 수 증가
        }
        return count;
    }
    
    // dfs 구현
    void dfs(int n, int[][] computers, boolean[] visited, int cur) { // cur : 현재 컴퓨터
        visited[cur] = true; // 현재 컴퓨터 방문 표시
        
        for (int i=0; i<n; i++) {
            // 방문하지 않았고 현재 컴퓨터와 연결되어 있다면
            if (!visited[i] && computers[cur][i] == 1) {
                dfs(n, computers, visited, i);
            }
        }
        
    }
}