import java.io.*;
import java.util.*;

public class Main {
    // 좌표 정보를 저장하는 클래스
    static class Position {
        int x, y;
        Position(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    
    static int[][] map;                    // 치즈 맵: 0은 공기, 1은 치즈
    static int cheese = 0;                 // 남은 치즈 수
    static final int[] DX = {0, 0, -1, 1}; // 상하좌우 x방향 이동
    static final int[] DY = {-1, 1, 0, 0}; // 상하좌우 y방향 이동
    
    public static void main(String[] args) throws IOException {
        // 입력 설정
        var br = new BufferedReader(new InputStreamReader(System.in));
        var st = new StringTokenizer(br.readLine());
        
        // 맵 크기 입력
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        
        // 치즈 맵 정보 입력
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                if ((map[i][j] = Integer.parseInt(st.nextToken())) == 1) cheese++;
            }
        }
        
        // 결과 출력 및 자원 해제
        System.out.print(simulate(n, m));
        br.close();
    }
    
    // 치즈가 모두 녹을 때까지 시뮬레이션 수행
    static int simulate(int n, int m) {
        int time = 0;
        while (cheese > 0) {
            melt(n, m);  // 치즈 녹이기
            time++;      // 시간 증가
        }
        return time;
    }
    
    // BFS로 외부 공기와 접촉한 치즈 녹이기
    static void melt(int n, int m) {
        var q = new ArrayDeque<Position>();         // BFS 큐
        int[][] air = new int[n][m];               // 외부 공기 접촉 횟수 기록
        var melting = new ArrayList<Position>();    // 녹을 치즈 위치 저장
        
        // 시작점 (0,0)은 항상 외부 공기
        q.offer(new Position(0, 0));
        air[0][0] = 1;
        
        // BFS 탐색
        while (!q.isEmpty()) {
            var cur = q.poll();
            
            // 4방향 탐색
            for (int d = 0; d < 4; d++) {
                int nx = cur.x + DX[d];
                int ny = cur.y + DY[d];
                
                // 맵 범위 벗어나면 스킵
                if (nx < 0 || ny < 0 || nx >= m || ny >= n) continue;
                
                if (map[ny][nx] == 0) {  // 공기인 경우
                    if (air[ny][nx] == 0) {
                        air[ny][nx] = 1;
                        q.offer(new Position(nx, ny));
                    }
                } else if (++air[ny][nx] == 2) {  // 치즈가 2면 이상 접촉 시 녹음
                    melting.add(new Position(nx, ny));
                }
            }
        }
        
        // 조건을 만족하는 치즈 녹이기
        for (var pos : melting) {
            map[pos.y][pos.x] = 0;
        }
        cheese -= melting.size();  // 전체 치즈 수 감소
    }
}