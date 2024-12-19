import java.util.*;

class Solution {
    static int[][][] dp; // dp[x][y][dir]: 특정 방향(dir)에서 (x, y)에 도달하는 최소 비용
    static int[] dx = {0, -1, 1, 0}; // 상, 좌, 우, 하로 이동
    static int[] dy = {-1, 0, 0, 1};
    static int N;
    static int answer;

    public int solution(int[][] board) {
        N = board.length;
        dp = new int[N][N][4]; // N x N 크기의 보드와 각 방향에 대한 최소 비용을 저장하는 dp 배열
        for (int[][] d : dp) // dp 배열 초기화: 모든 값을 Integer.MAX_VALUE로 설정
            for (int[] dir : d) 
                Arrays.fill(dir, Integer.MAX_VALUE);

        answer = Integer.MAX_VALUE; // 최소 비용을 저장할 변수
        bfs(board); // BFS 실행
        return answer; // 계산된 최소 비용 반환
    }

    private void bfs(int[][] board) {
        Queue<int[]> queue = new LinkedList<>();
        // 초기 위치 (0, 0)에서 시작, 초기 방향은 -1 (아직 방향 없음), 초기 비용은 0
        queue.offer(new int[]{0, 0, -1, 0}); 

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0], y = current[1], prevDir = current[2], cost = current[3];

            // 도착지점에 도달했을 경우, 최소 비용을 갱신
            if (x == N - 1 && y == N - 1) {
                answer = Math.min(answer, cost);
                continue;
            }

            // 4가지 방향으로 이동
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                // 보드 범위를 벗어나거나 장애물(1)일 경우 무시
                if (nx < 0 || nx >= N || ny < 0 || ny >= N || board[nx][ny] == 1) continue;

                // 새로운 비용 계산: 같은 방향으로 이동하면 100원, 방향이 바뀌면 600원
                int newCost = cost + (prevDir == i || prevDir == -1 ? 100 : 600);

                // 새로운 비용이 기존 dp값보다 작을 경우만 갱신 및 큐에 추가
                if (dp[nx][ny][i] > newCost) {
                    dp[nx][ny][i] = newCost;
                    queue.offer(new int[]{nx, ny, i, newCost}); // 새로운 위치, 방향, 비용 큐에 추가
                }
            }
        }
    }
}
