import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int[] num = new int[3];
        
        // 숫자 3개 입력 받기
        for (int i=0; i<3; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }
        
        // 배열 오름차순 정렬
        Arrays.sort(num); 
        
        // 정렬한 수 차례로 출력
        for (int n : num) {
            System.out.print(n + " ");
        }
    }
}