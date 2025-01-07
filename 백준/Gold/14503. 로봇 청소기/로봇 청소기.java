import java.util.*;
import java.io.*;

public class Main {
    // 맵의 크기 N×M과 청소한 칸의 개수를 저장하는 변수
    static int n, m, count = 1; // count는 시작 위치를 포함하므로 1로 초기화
    static int[][] map; // 맵 정보를 저장할 2차원 배열
    
    // 방향 벡터 (0: 북, 1: 동, 2: 남, 3: 서)
    static final int[] dx = {-1, 0, 1, 0};  // 행 벡터
    static final int[] dy = {0, 1, 0, -1};  // 열 벡터
    
    public static void main(String[] args) throws IOException {
        // 입력 받음.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        // 맵의 크기 입력
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        
        // 로봇 청소기의 초기 위치(r, c)와 방향(d) 입력
        st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        
        // 맵 정보 입력 (0: 빈 칸, 1: 벽)
        map = new int[n][m];
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        // 청소 시작
        clean(r, c, d);
        System.out.println(count);
        br.close();
    }
    
    // 로봇 청소기의 청소 동작을 수행하는 재귀 메소드
    // 현재 행, 현재 열, 현재 바라보는 방향
    private static void clean(int x, int y, int dir) {
       // 현재 위치를 청소 (-1은 청소된 상태를 의미)
       map[x][y] = -1;
        
       int nx, ny;
       // 현재 위치에서 현재 방향을 기준으로 왼쪽 방향부터 차례대로 탐색
       for(int i = 0; i < 4; i++) {
           // 다음 방향 계산 (현재 방향 + 3) % 4 는 왼쪽 90도 회전과 같음
           dir = (dir+3) % 4;
           // dir = (dir+3) & 3;
            
           // 다음 위치 계산
           nx = x + dx[dir];
           ny = y + dy[dir];
            
           // 다음 위치가 유효하고 청소되지 않은 빈 칸인 경우
           if(isValid(nx, ny) && map[nx][ny] == 0) {
               count++;  // 청소한 칸 수 증가
               clean(nx, ny, dir);  // 다음 위치로 이동하여 청소 진행
               return;
           }
       }
        
       // 네 방향 모두 청소가 되어있거나 벽인 경우, 후진 시도
       int backDir = (dir + 2) & 3;  // 현재 방향의 반대 방향 계산
       nx = x + dx[backDir];
       ny = y + dy[backDir];
        
       // 후진할 수 있는 경우 (벽이 아닌 경우)
       if(isValid(nx, ny) && map[nx][ny] != 1) {
           clean(nx, ny, dir);  // 바라보는 방향 유지한 채로 후진
       }
   }
    
   // 주어진 좌표가 맵 범위 내에 있는지 확인하는 메소드
   private static boolean isValid(int x, int y) {
       return x >= 0 && y >= 0 && x < n && y < m;
   }
}