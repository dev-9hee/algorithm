import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); // 입력 받음
        int N = sc.nextInt(); // N : 과목의 개수
        sc.nextLine(); // 다음 줄

        int[] scores = new int[N];
        int M = 0; // 점수 중 최대값

        // 점수 입력받으면서 최대값 찾기
        for (int i = 0; i < N; i++) {
            scores[i] = sc.nextInt(); // 점수 배열에 넣기

            if (scores[i] > M) {  // 단순히 현재 값이 M보다 크면 갱신
                M = scores[i];
            }
        }

        // 평균 계산
        double sum = 0;
        for (int i = 0; i < N; i++) {
            sum += (double)scores[i] / M * 100;
        }

        System.out.println(sum / N);
        sc.close();
    }
}
