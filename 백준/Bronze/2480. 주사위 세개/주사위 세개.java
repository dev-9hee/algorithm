import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // 세 개의 주사위 수
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        
        if (a == b && b == c) { // 1. 3개 다 같은 경우
            System.out.print(10000 + a * 1000);
        } else if (a == b || a == c) { // 2. 2개만 같은 경우
            System.out.print(1000 + a * 100);
        } else if (b == c) {
            System.out.print(1000 + b * 100);
        }else { // 3. 모두 다른 눈이 나오는 경우
            int max = Math.max(Math.max(a, b), c); // 최대값 찾기
            System.out.print(max * 100);
        }
    }
}