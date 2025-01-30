import java.io.*;
import java.util.*;

public class Main {
    // 상하좌우 이동을 위한 배열
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    
    static int[][] map;           // 인구 수를 저장하는 배열
    static boolean[][] visited;    // 방문 체크 배열
    static int N, L, R;           // N: 맵크기, L,R: 인구차이 범위
    static ArrayList<int[]> union; // 연합국가들의 좌표를 저장
    
    public static void main(String[] args) throws IOException {
        // 입력 처리
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        
        // 배열 초기화
        map = new int[N][N];
        
        // 맵 입력받기
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        System.out.println(solve());
    }
    
    // 문제 해결
    static int solve() {
        int days = 0;
        while(true) {
            boolean moved = false;
            visited = new boolean[N][N];
            
            // 모든 좌표에 대해 연합 가능성 체크
            for(int i=0; i<N; i++) {
                for(int j=0; j<N; j++) {
                    if(!visited[i][j]) {
                        union = new ArrayList<>();
                        int sum = bfs(i, j); // BFS로 연합 구성
                        
                        // 연합이 2개 국가 이상이면 인구 이동 실행
                        if(union.size() > 1) {
                            moved = true;
                            int avg = sum / union.size();
                            for(int[] pos : union) {
                                map[pos[0]][pos[1]] = avg;
                            }
                        }
                    }
                }
            }
            
            // 인구 이동이 없으면 종료
            if(!moved) break;
            days++;
        }
        return days;
    }
    
    // BFS로 연합 찾기
    static int bfs(int x, int y) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{x, y});
        visited[x][y] = true;
        union.add(new int[]{x, y});
        int sum = map[x][y];
        
        // BFS 탐색
        while(!q.isEmpty()) {
            int[] cur = q.poll();
            
            // 상하좌우 탐색
            for(int i=0; i<4; i++) {
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];
                
                // 범위 체크 및 미방문 체크
                if(nx >= 0 && nx < N && ny >= 0 && ny < N && !visited[nx][ny]) {
                    // 인구 차이가 L이상 R이하인 경우
                    int diff = Math.abs(map[cur[0]][cur[1]] - map[nx][ny]);
                    if(diff >= L && diff <= R) {
                        visited[nx][ny] = true;
                        q.offer(new int[]{nx, ny});
                        union.add(new int[]{nx, ny});
                        sum += map[nx][ny];
                    }
                }
            }
        }
        return sum;
    }
}