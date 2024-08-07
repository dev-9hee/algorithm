import java.util.*;

class Solution {
    public int solution(int[][] maps) {
        int n = maps.length; // 행수
        int m = maps[0].length; // 열수
        boolean[][] visited = new boolean[n][m]; // 방문 여부
        Queue<int[]> queue = new ArrayDeque<>(); // bfs 사용, r / c / dist
        
        // bfs 초기화
        queue.add(new int[]{0, 0, 1}); // 초기 위치 (0, 0), 초기 거리 1
        visited[0][0] = true;
        
        // 상하좌우 거리 벡터
        int[] dr = {-1, 1, 0, 0}; // 행 이동
        int[] dc = {0, 0, -1, 1}; // 열 이동
        
        while (!queue.isEmpty()) {
            int[] cur = queue.remove(); // 현재 위치와 거리
            int r = cur[0], c = cur[1], dist = cur[2];
            
            // 목적지에 도달하면 거리 리턴
            if (r == n-1 && c == m-1) {
                return dist;
            }
            
            // 상하좌우 이동
            for (int d=0; d<4; d++) {
                int nr = r + dr[d], nc = c + dc[d];
                
                if (0 <= nr && nr < n && 0 <= nc && nc < m && maps[nr][nc] == 1 && !visited[nr][nc]) {
                    visited[nr][nc] = true; // 방문표시
                    queue.add(new int[]{nr, nc, dist + 1});
                }
            }
        }
        return -1;
    }
}