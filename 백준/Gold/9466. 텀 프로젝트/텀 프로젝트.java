import java.io.*;
import java.util.*;

public class Main {
    private static int T, N, res;
    private static int[] arr;
    private static boolean[] visited, done;

    public static void dfs(int current) {
        visited[current] = true; // 방문 체크
        int next = arr[current]; // 다음 노드로 이동

        if (!visited[next]) {
            // 다음 노드를 방문하지 않았다면 DFS 계속 진행
            dfs(next);
        } else if (!done[next]) {
            // 방문은 했지만 아직 완료되지 않은 경우 -> 사이클 발생
            for (int i = next; i != current; i = arr[i]) {
                res++; // 사이클 내 노드 카운트
            }
            res++; // 자기 자신도 카운트
        }

        done[current] = true; // 현재 노드 탐색 완료 처리
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            N = Integer.parseInt(br.readLine());
            arr = new int[N + 1];
            visited = new boolean[N + 1];
            done = new boolean[N + 1];
            res = 0;

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= N; i++) arr[i] = Integer.parseInt(st.nextToken());

            for (int i = 1; i <= N; i++) {
                if (!visited[i]) dfs(i); // 아직 방문하지 않은 노드만 DFS 실행
            }

            System.out.println(N - res); // 사이클에 포함되지 않은 학생 수 출력
        }
    }
}