import java.util.*;

class Solution {
    public int solution(int[][] maps) {
        int n = maps.length; // 행 수
        int m = maps[0].length; // 열 수
        boolean[][] visited = new boolean[n][m]; // 방문 표시
        Queue<int[]> queue = new ArrayDeque<>(); // r, c, dist
        
        // 상하좌우 거리 벡터
        int[] dr = {-1, 1, 0, 0}; // 행 
        int[] dc = {0, 0, -1, 1}; // 열
        
        // bfs 초기화
        queue.add(new int[]{0, 0, 1}); // 시작 위치 (0, 0), 초기 거리 1
        visited[0][0] = true; // 시작 위치 방문 표시
        
        while(!queue.isEmpty()) {
            int[] cur = queue.remove();
            int r = cur[0], c = cur[1], dist = cur[2];
            
            // 목적지 도달
            if (r == n-1 && c == m-1) {
                return dist; // 거리 반환
            }
            
            // 상하좌우 이동
            for (int d=0; d<4; d++) {
                int nr = r + dr[d], nc = c + dc[d];
                
                if (0 <= nr && nr < n && 0 <= nc && nc < m && maps[nr][nc] == 1 && !visited[nr][nc]) {
                    visited[nr][nc] = true;
                    queue.add(new int[] {nr, nc, dist + 1});
                }
            }
        }
        
        return -1;
    }
}