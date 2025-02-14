import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine()); // 정수의 개수

        int[] nums = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        int v = Integer.parseInt(br.readLine()); // 찾을 정수
        int count = 0;
        for (int num : nums) {
            if (num == v) count++;
        }

        System.out.println(count);
    }
}