import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        long a = sc.nextLong(); // A
        long b = sc.nextLong(); // B
        
        // A가 B보다 크면 swap
        if (a > b) {
            long temp = a;
            a = b;
            b = temp;
        }
        
        // A와 B가 같은 경우 사이의 수는 0개
        long count = a == b ? 0 : b - a - 1;
        System.out.println(count);
        
         // 사이의 수가 있을 때만 출력
        if (count > 0) {
            for (long i = a + 1; i < b; i++) {
                System.out.print(i + (i < b - 1 ? " " : ""));
            }
        }
        
        sc.close();
    }
}