import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = i + 1; // 배열은 0부터 시작하기 떄문에 arr[0]에 1을 넣기 위해 1을 더해줌
        }

        for (int i = 0; i < m; i++) { // M개의 줄
            st = new StringTokenizer(br.readLine());
            int left = Integer.parseInt(st.nextToken()) - 1; // 배열 0부터 시작
            int right = Integer.parseInt(st.nextToken()) - 1; // 배열 0부터 시작

            while (left < right) {
                int temp = arr[left];
                arr[left++] = arr[right];
                arr[right--] = temp;
            }
        }
        
        for (int baguni : arr)
            System.out.print(baguni + " ");
    }
}