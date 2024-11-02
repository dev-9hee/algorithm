import java.util.*;

class Solution {
	public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in); // 입력 받음
        int T = sc.nextInt(); // 테스트 케이스의 수

		for(int testCase = 1; testCase <= T; testCase++) {
			sc.nextInt(); // 테스트 케이스 번호
            int[] scores = new int[101]; // 0~100점까지 나온 점수의 개수 저장
            for (int i=0; i<1000; i++) { // 1000명의 학생 점수 입력
                int score = sc.nextInt();
                scores[score]++; 
            }
            int max=0; // 최빈값 (나온 횟수)
            int maxScore=0; // 최빈값의 점수 저장 변수
            for (int i=0; i<100; i++) { // 0~100까지 돌면서 최빈값을 찾을것임
                if (scores[i] > max) { // 현재 최빈값보다 크다면 
                    max = scores[i]; // 최빈값 갱신
                    maxScore = i; // 최빈값 점수
                } else if (scores[i] == max) { // 현재 최빈값이랑 같다면
                    if (i > maxScore) maxScore=i; // 점수가 더 큰게 저장이 됨
                }
            }
            
            System.out.printf("#%d %d\n", testCase, maxScore);
		}
	}
}