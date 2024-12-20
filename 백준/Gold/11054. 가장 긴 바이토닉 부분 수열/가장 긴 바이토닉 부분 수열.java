import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 수열의 길이
        int n = Integer.parseInt(br.readLine());

        // 수열
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        // 증가하는 부분 수열 (LIS)을 저장할 배열
        int[] dpInc = new int[n];
        // 감소하는 부분 수열 (LDS)을 저장할 배열
        int[] dpDec = new int[n];

        // 증가하는 부분 수열 길이 계산
        for (int i = 0; i < n; i++) {
            dpInc[i] = 1; // 기본값은 자기 자신만 포함하는 길이 1
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j] && dpInc[j] + 1 > dpInc[i]) {
                    dpInc[i] = dpInc[j] + 1;
                }
            }
        }

        // 감소하는 부분 수열 길이 계산
        for (int i = n - 1; i >= 0; i--) {
            dpDec[i] = 1; // 기본값은 자기 자신만 포함하는 길이 1
            for (int j = n - 1; j > i; j--) {
                if (arr[i] > arr[j] && dpDec[j] + 1 > dpDec[i]) {
                    dpDec[i] = dpDec[j] + 1;
                }
            }
        }

        // 가장 긴 바이토닉 수열 길이 계산
        int maxLength = 0;
        for (int i = 0; i < n; i++) {
            maxLength = Math.max(maxLength, dpInc[i] + dpDec[i] - 1); // 중복된 i를 한 번 빼줌
        }

        // 결과 출력
        System.out.println(maxLength);
    }
}