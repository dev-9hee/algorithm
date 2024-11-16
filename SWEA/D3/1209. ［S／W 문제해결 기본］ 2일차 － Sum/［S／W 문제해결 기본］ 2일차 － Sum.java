import java.util.*;

// Sum 문제
public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// 10개의 테스트 케이스
		for (int testCase = 1; testCase <= 10; testCase++) {
			int[][] ar = new int[100][100]; // 100X100 배열
			int[] sumRow = new int[100]; // 행의 합들
			int[] sumCol = new int[100]; // 열의 합들
			int maxX = 0, maxY = 0; // 대각선의 합들
			
            sc.nextInt(); // 각 테스트 케이스 번호 버리기
            
			// 배열에 값 넣기
			for (int i = 0; i < ar.length; i++) {
				for (int j = 0; j < ar[0].length; j++) {
					ar[i][j] = sc.nextInt();
				}
			}
			
			// 행, 열, 각 대각선의 합 중 최댓값 구하기
			for (int i = 0; i < 100; i++) { // 각 행의 합
				for (int j = 0; j < 100; j++) {
					sumRow[i] += ar[i][j];
				}
			}
			
			for (int i = 0; i < 100; i++) { // 각 열의 합
				for (int j = 0; j < 100; j++) {
					sumCol[i] += ar[j][i];
				}
			}
			
			for (int i = 0; i < 100; i++) { // 대각선의 합
				maxX += ar[i][i];
				maxY += ar[i][100-i-1];
			}
			
			Arrays.sort(sumRow);
			Arrays.sort(sumCol);
			int max = Math.max(sumRow[99], sumCol[99]);
			int max2 = Math.max(maxX, maxY);
			int finalMax = Math.max(max, max2);
			
			System.out.printf("#%d %d\n", testCase, finalMax);
		}
		
		sc.close();
	}
}