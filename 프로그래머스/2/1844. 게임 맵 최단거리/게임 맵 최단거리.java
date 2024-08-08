import java.util.*;

class Solution {
    public int solution(int[][] maps) {
        int n = maps.length; // 행 수
        int m = maps[0].length; // 열 수
        boolean[][] visited = new boolean[n][m]; // 방문 표시
        Queue<int[]> queue = new ArrayDeque<>(); // r, c, dist
        
        // 상하좌우 거리벡터
        int[] dr = {-1, 1, 0, 0}; // 행 변화량
        int[] dc = {0, 0, -1, 1}; // 열 변화량
        
        // bfs 초기값
        queue.add(new int[]{0, 0, 1}); // 시작 위치 (0,0), 거리 1 (자신 포함)
        visited[0][0] = true; // 시작 위치 방문 표시
        
        // bfs 탐색
        while (!queue.isEmpty()) {
            int[] cur = queue.remove();
            int r = cur[0], c = cur[1], dist = cur[2];
            
            // 목적지 도착
            if (r == n-1 && c == m-1) {
                return dist; // 거리 반환
            }
            
            // 상하좌우로 이동하면서 탐색
            for (int d=0; d<4; d++) {
                int nr = r + dr[d], nc = c + dc[d];
                
                if (0 <= nr && nr < n && 0 <= nc && nc < m && maps[nr][nc] == 1 && !visited[nr][nc]) {
                    visited[nr][nc] = true;
                    queue.add(new int[]{nr, nc, dist + 1});
                }
            }
        }
        return -1;
    } 
}