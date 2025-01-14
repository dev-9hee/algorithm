import java.io.*;
import java.util.*;

public class Main {
    static int M, N;  // M: 가로길이, N: 세로길이
    static int[][] field;  // 배추밭
    static boolean[][] visited;  // 방문 체크
    static int[] dx = {0, 0, 1, -1};  // 상하좌우 x좌표
    static int[] dy = {1, -1, 0, 0};  // 상하좌우 y좌표
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();  // 결과를 한번에 출력하기 위한 StringBuilder
        
        int T = Integer.parseInt(br.readLine());  // 테스트 케이스 수
        
        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());  // 배추의 개수
            
            // 배열 초기화
            field = new int[M][N];
            visited = new boolean[M][N];
            
            // 배추 위치 입력
            while (K-- > 0) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                field[x][y] = 1;
            }
            
            int wormCount = countWorms();
            sb.append(wormCount).append('\n');
        }
        
        System.out.print(sb);
        br.close();
    }
    
    // BFS를 사용하여 필요한 지렁이 수를 계산
    private static int countWorms() {
        int count = 0;
        Queue<int[]> queue = new LinkedList<>();
        
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (field[i][j] == 1 && !visited[i][j]) {
                    bfs(i, j, queue);
                    count++;
                }
            }
        }
        return count;
    }
    
    // BFS 구현
    private static void bfs(int startX, int startY, Queue<int[]> queue) {
        queue.offer(new int[]{startX, startY});
        visited[startX][startY] = true;
        
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            
            for (int i = 0; i < 4; i++) {
                int nx = current[0] + dx[i];
                int ny = current[1] + dy[i];
                
                if (isValid(nx, ny) && field[nx][ny] == 1 && !visited[nx][ny]) {
                    queue.offer(new int[]{nx, ny});
                    visited[nx][ny] = true;
                }
            }
        }
    }
    
    // 좌표가 유효한지 확인
    private static boolean isValid(int x, int y) {
        return x >= 0 && x < M && y >= 0 && y < N;
    }
}