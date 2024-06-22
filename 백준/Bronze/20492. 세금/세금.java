import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int winner = sc.nextInt(); // 받은 상금

        int case1 = (int) (winner * 0.78);
        int case2 = (int) (winner * 0.8);
        int case3 = (int) ((winner * 0.2) * 0.78);
        int sum = case2 + case3;

        System.out.println(case1 + " " + sum);
    }
}