import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            long num = sc.nextLong();
            boolean isTrue = true;

            for (int j = 2; j <= 1_000_000; j++) {
                if (num % j == 0) {
                    System.out.println("NO");
                    isTrue = false;
                    break;
                }
            }
            if (isTrue) {
                System.out.println("YES");
            }
        }
    }
}