import java.io.*;
import java.util.*;

public class Main {
    // 상수로 방향 배열 정의
    private static final int[] DX = {0, 0, 1, -1};
    private static final int[] DY = {1, -1, 0, 0};
    
    // 필드 변수 선언
    private static int N, M;           // N: 세로 크기, M: 가로 크기
    private static int[][] tomatoes;   // 토마토 상태를 저장하는 배열
    private static int unripeTomatoes; // 익지 않은 토마토의 개수
    
    public static void main(String[] args) throws IOException {
        // 입출력 설정
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        // 크기 입력 받기
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        
        // 토마토 배열 초기화
        tomatoes = new int[N][M];
        Queue<Point> queue = new LinkedList<>();
        
        // 토마토 정보 입력 받기
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                tomatoes[i][j] = Integer.parseInt(st.nextToken());
                if (tomatoes[i][j] == 1) {
                    // 익은 토마토 위치 큐에 저장
                    queue.offer(new Point(i, j));
                } else if (tomatoes[i][j] == 0) {
                    // 익지 않은 토마토 개수 카운트
                    unripeTomatoes++;
                }
            }
        }
        
        // 결과 출력
        System.out.println(bfs(queue));
        br.close();
    }
    
    private static int bfs(Queue<Point> queue) {
        // 처음부터 모든 토마토가 익어있는 경우
        if (unripeTomatoes == 0) return 0;
        
        int days = 0;  // 경과 일수
        
        // BFS 시작
        while (!queue.isEmpty()) {
            // 현재 단계에 있는 모든 토마토 처리
            int size = queue.size();
            
            for (int i = 0; i < size; i++) {
                Point current = queue.poll();
                
                // 4방향 탐색
                for (int dir = 0; dir < 4; dir++) {
                    int nx = current.x + DX[dir];
                    int ny = current.y + DY[dir];
                    
                    // 범위 체크 및 익지 않은 토마토 확인
                    if (isValid(nx, ny) && tomatoes[nx][ny] == 0) {
                        tomatoes[nx][ny] = 1;  // 토마토를 익은 상태로 변경
                        queue.offer(new Point(nx, ny));
                        unripeTomatoes--;  // 익지 않은 토마토 수 감소
                    }
                }
            }
            
            // 날짜 증가
            if (!queue.isEmpty()) days++;
        }
        
        // 모든 토마토가 익지 않았다면 -1 반환
        return unripeTomatoes == 0 ? days : -1;
    }
    
    // 좌표가 유효한지 확인하는 메소드
    private static boolean isValid(int x, int y) {
        return x >= 0 && x < N && y >= 0 && y < M;
    }
    
    // 좌표를 저장하는 내부 클래스
    private static class Point {
        int x, y;
        
        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}