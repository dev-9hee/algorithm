import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        for (int i=1; i<=2*n-1; i++) {
            if (i <= n) {
                for (int j = 1; j <= i; j++) {
                    System.out.print("*");
                }
                for (int j = 1; j <= 2 * (n - i); j++) {
                    System.out.print(" ");
                }
                for (int j = 1; j <= i; j++) {
                    System.out.print("*");
                }
                System.out.println();
            } else {
                for (int j = 1; j <= (2 * n) - i; j++) { // 별 4, 3, 2, 1 => 2n-i
                    System.out.print("*");
                }
                for (int j = 1; j <= 2 * (i - n); j++) { // 공백 2, 4, 6, 8 => 2(i-n);
                    System.out.print(" ");
                }
                for (int j = 1; j <= (2 * n) - i; j++) { // 별 4, 3, 2, 1 => 2n-i
                    System.out.print("*");
                }
                System.out.println();
            }
        }

        sc.close();
    }
}