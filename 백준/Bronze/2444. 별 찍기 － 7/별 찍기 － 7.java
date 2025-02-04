import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        for (int i=1; i<=2*n-1; i++) {
            if (i <= n) {
                for (int j=1; j<=n-i; j++) { // 앞 공백 4, 3, 2, 1, 0 => n-i
                    System.out.print(" ");

                }
                for (int j=1; j<=2*i-1; j++) { // 별 1, 3, 5, 7, 9 => 2i-1
                    System.out.print("*");
                }
                System.out.println();
            } else {
                for (int j=1; j<=i-n; j++) { // 앞 공백 1, 2, 3, 4 => i-n
                    System.out.print(" ");
                }
                for (int j=1; j<=(4*n)-(2*i)-1; j++) { // 별 7, 5, 3, 1 => 4n-2i-1
                    System.out.print("*");
                }
                System.out.println();
            }
        }

        sc.close();
    }
}