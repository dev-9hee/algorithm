import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        for (int i = 1; i <= (2 * n) - 1; i++) {
            if (i <= n) {
                for (int j = 1; j < i; j++) { // 앞 공백 0, 1, 2, 3, 4 => i-1
                    System.out.print(" ");

                }
                for (int j = 1; j <= 2 * (n - i) + 1; j++) { // 별 9, 7, 5, 3, 1 => 2(n-i)+1
                    System.out.print("*");
                }
                System.out.println();
            } else {
                for (int j = 1; j <= (2 * n) - i - 1; j++) { // 앞 공백 3, 2, 1, 0 => 2n-i-1
                    System.out.print(" ");
                }
                for (int j = 1; j <= 2 * (i - n) + 1; j++) { // 별 3, 5, 7, 9 => 2(i-n)+1
                    System.out.print("*");
                }
                System.out.println();
            }
        }
        sc.close();
    }
}