import java.util.*;
import java.io.*;

class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int T = Integer.parseInt(br.readLine()); // 테스트 케이스의 수
        
        for (int testCase=1; testCase<=T; testCase++) {
            br.readLine(); // 테스트 케이스 번호는 버림
            
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] scores = new int[101]; // 0~100점까지 나온 점수의 개수 저장
            
            // 1000명의 학생 점수 입력
            for (int i=0; i<1000; i++) { // 1000명의 학생
                scores[Integer.parseInt(st.nextToken())]++;
            }
            
            int max = 0;     // 최빈값 (나온 횟수)
            int maxScore = 0;  // 최빈값의 점수 저장 변수
            
            // 0~100까지 돌면서 최빈값을 찾음
            for (int i=0; i<100; i++) {
                if (scores[i] > max) {
                    max = scores[i];
                    maxScore = i;
                } else if (scores[i] == max) { // 최빈값이랑 같다면 
                    if (i > maxScore) maxScore = i; // 점수가 더 큰게 저장이 됨
                }
            }
            sb.append("#").append(testCase).append(" ").append(maxScore).append("\n");
        }
        System.out.print(sb);
        br.close();
    }
}