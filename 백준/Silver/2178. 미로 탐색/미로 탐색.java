import java.util.*;
import java.io.*;

public class Main {
    static int[] dx = {-1, 1, 0, 0}; // 좌우 거리벡터
    static int[] dy = {0, 0, -1, 1}; // 상하 거리벡터
    static int n, m; // 행, 열
    static int[][] miro; // 미로 정보
    
    // 좌표 지정용
    static class Point {
        int x, y;
        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        // 기본 구분자 공백(" ")
        // StringTokenizer st = new StringTokenizer(문자열, 구분자);
        
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        miro = new int[n][m];
        
        for (int i=0; i<n; i++) {
            String line = br.readLine();
            for (int j=0; j<m; j++) {
                miro[i][j] = line.charAt(j) - '0'; // char를 int로 변환
            }
        }
        
        bfs(); // bfs 실행
        System.out.println(miro[n-1][m-1]); // 도착점까지의 최단거리 출력
    }
    
    // bfs 알고리즘
    static void bfs() {
        Queue<Point> q = new LinkedList<>(); // LinkedList로 큐 구현, 연결 리스트 구조로 삽입/삭제가 O(1)
        q.offer(new Point(0, 0)); // 시작점 추가, offer : 실패하면 false, add : 실패하면 예외
        
        while (!q.isEmpty()) {
            Point p = q.poll(); // 현재 위치
            
            // 4방향 탐색
            for (int i=0; i<4; i++) {
                int nx = p.x + dx[i]; // 다음 x
                int ny = p.y + dy[i]; // 다음 y
                
                // 범위 체크 및 미방문 체크(1인 경우만 방문)
                if (nx < 0 || ny < 0 || nx >= n || ny >= m || miro[nx][ny] != 1) continue;
                
                miro[nx][ny] = miro[p.x][p.y] + 1; // 거리 갱신
                q.offer(new Point(nx, ny)); // 다른 위치 큐에 추가
            }
        }
    }
}