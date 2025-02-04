import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        for (int i=1; i<=n; i++) {
            for (int j=1; j<i; j++) { // 앞 공백 0, 1, 2, 3, 4 => i-1
                System.out.print(" ");

            }
            for (int j=1; j<=2*(n-i)+1; j++) { // 별 9, 7, 5, 3, 1 => 2(n-i)+1
                System.out.print("*");
            }
            System.out.println();
        }

        sc.close();
    }
}