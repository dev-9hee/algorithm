import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        int t = Integer.parseInt(br.readLine()); // 테스트케이스의 수
        
        for (int i=0; i<t; i++) {
            st = new StringTokenizer(br.readLine());
            
            int n = Integer.parseInt(st.nextToken()); // 문서의 개수
            int m = Integer.parseInt(st.nextToken()); // 몇 번째에 놓여 있는지를 나타내는 정수
            
            Queue<int[]> q = new LinkedList<>();
            
            st = new StringTokenizer(br.readLine());
            
            for (int j=0; j<n; j++) {
                int num = Integer.parseInt(st.nextToken());
                q.add(new int[] {j, num});
            }
            
            int cnt = 0;
            while (true) {
                int[] cur = q.poll();
                boolean check = true; // 중요도가 높은 것이 있는지 여부
                
                for (int[] curQ : q) {
                    if (curQ[1] > cur[1]) {
                        check = false;
                        break;
                    }
                }
                
                if (check) {
                    cnt++;
                    if (cur[0] == m) break;
                } else {
                    q.add(cur);
                }
            }
            
            System.out.println(cnt);
        }
        
    }
}