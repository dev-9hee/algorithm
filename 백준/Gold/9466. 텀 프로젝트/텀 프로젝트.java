import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static int T, N, res;
    private static int arr[];
    private static boolean visited[], done[];

    public static void dfs(int idx) {
        if(done[idx]) return; // 이전에 이미 검사했다는 뜻이므로 더 이상 들어갈 필요가 없다.
        if(visited[idx]) { // 방문을 했었다 == 사이클 구성원이다
            done[idx] = true; // 이제 다시 볼 일 없으므로 done 체크
            res++; // 사이클 구성원이므로 + 1
        }
        visited[idx] = true; // 방문 체크
        dfs(arr[idx]);
        done[idx] = true; // 사이클이 아닌 애들도 검사 끝났으니까 done 체크
        visited[idx] = false; // 방문 체크한 거 초기화
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        for(int t = 1; t <= T; t++) {
            N = Integer.parseInt(br.readLine()); res = 0;
            arr = new int[N + 1]; done = new boolean[N + 1]; visited = new boolean[N + 1];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int n = 1; n <= N; n++) arr[n] = Integer.parseInt(st.nextToken());

            for(int i = 1; i <= N; i++) {
                if(done[i]) continue; // 이미 검사한 애들은 스킵한다.
                dfs(i);
            }
            System.out.println(N - res); // 사이클에 해당하지 않는 학생 수 출력
        }
    }
}