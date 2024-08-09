import java.util.*;

class Solution {
    public int solution(String[] maps) {
        int n = maps.length; // 행 수
        int m = maps[0].length(); // 열 수
        char[][] miro = new char[n][m];
        int[] start = new int[2];
        int[] lever = new int[2];
        int[] exit = new int[2];
        
        // start, lever, exit 위치 찾기
        for (int r=0; r<n; r++) {
            miro[r] = maps[r].toCharArray();
            for (int c=0; c<m; c++) {
                if (miro[r][c] == 'S') {
                    start[0] = r;
                    start[1] = c;
                } else if (miro[r][c] == 'L') {
                    lever[0] = r;
                    lever[1] = c;
                } else if (miro[r][c] == 'E') {
                    exit[0] = r;
                    exit[1] = c;
                }
            }
        }
        
        int toLever = bfs(miro, start, lever, n, m);
        if (toLever == -1) return -1;
        
        int toExit = bfs(miro, lever, exit, n, m);
        if (toExit == -1) return -1;
        
        return toLever + toExit;
    }
    
    public int bfs(char[][] miro, int[] start, int[] target, int n, int m) {
        boolean[][] visited = new boolean[n][m];
        Queue<int[]> queue = new ArrayDeque<>();
        
        // 거리벡터
        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};
        
        // bfs초기화
        queue.add(new int[] {start[0], start[1], 0}); // 현재 위치와 거리
        visited[start[0]][start[1]] = true;
        
        // bfs 탐색
        while (!queue.isEmpty()) {
            int[] cur = queue.remove();
            int r = cur[0], c = cur[1], dist = cur[2];
            
            // 네 방향 탐색
            for (int d=0; d<4; d++) {
                int nr = r + dr[d], nc = c + dc[d];
                
                if (0 <= nr && nr < n && 0 <= nc && nc < m && miro[nr][nc] != 'X') {
                    if (!visited[nr][nc]) {
                        if (nr == target[0] && nc == target[1]) return dist+1;
                        
                        visited[nr][nc] = true;
                        queue.add(new int[] {nr, nc, dist+1});
                    }
                }
            }
        }
        return -1;
    }
}