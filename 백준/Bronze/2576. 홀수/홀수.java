import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int min = Integer.MAX_VALUE, sum = 0; // 홀수들 중 최솟값, 홀수들 합
        boolean exists = false; // 홀수 존재 여부
        
        // 7개의 자연수
        for (int i=0; i<7; i++) {
            int num = sc.nextInt();
            if (isOdd(num)) { // 홀수면
                sum += num; // 홀수들 합에 더하고
                if (num < min) min = num; // 최솟값 갱신
                exists = true;
            }
        }
        
        // 홀수가 존재할 때 출력
        if (exists) {
            System.out.println(sum);
            System.out.println(min);
        } else { // 존재하지 않을 때 출력
            System.out.println(-1);
        }
        
        sc.close();
    }
    
    // 홀수 판별 함수
    static boolean isOdd(int num) {
        if (num % 2 != 0) return true; // 홀수면 true
        return false; // 짝수면 false
    }
}