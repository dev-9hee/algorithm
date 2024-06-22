import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 학생 5명의 점수 입력 받기
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        int d = sc.nextInt();
        int e = sc.nextInt();

        int[] scores = new int[] {a, b, c, d, e};
        int[] finalScore = new int[scores.length];

        for (int i = 0; i < scores.length; i++) {
            int score = scores[i];
            if (score >= 40) {
                finalScore[i] = score;
            } else {
                finalScore[i] = 40;
            }
        }

        int sum = 0;
        int avg = 0;

        for (int i = 0; i < finalScore.length; i++) {
            sum += finalScore[i];
        }
        avg = sum / finalScore.length;

        System.out.println(avg);
    }
}