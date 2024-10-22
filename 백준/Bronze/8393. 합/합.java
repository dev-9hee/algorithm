import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // n 입력
        sc.close(); // 스캐너 종료
        
        int sum = 0;
        for (int i=1; i<=n; i++) {
            sum += i;
        }
        
        System.out.println(sum);
    }
}