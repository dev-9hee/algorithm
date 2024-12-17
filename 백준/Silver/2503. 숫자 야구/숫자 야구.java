import java.io.*;
import java.util.*;

public class Main {
    static int N; // 질문 횟수
    static String[] guessNum; // 질문 숫자
    static int[] strike, ball; // 스트라이크, 볼
    static int candidateCount = 0; // 정답 후보 개수 (답)
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        N = Integer.parseInt(br.readLine());
        guessNum = new String[N];
        strike = new int[N];
        ball = new int[N];
        
        // 질문, 답 입력
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            guessNum[i] = st.nextToken();
            strike[i] = Integer.parseInt(st.nextToken());
            ball[i] = Integer.parseInt(st.nextToken());          
        }
        
        // 가능한 숫자 (123 ~ 987) 탐색
        for (int num = 123; num <= 987; num++) {
            String candidate = String.valueOf(num);
            
            // 후보 숫자 유효성 검사 (0 포함 또는 중복 숫자 제거)
            if (!isValidNumber(candidate)) continue;
            
            // 모든 질문 조건을 만족하는지 확인
            if (isPossible(candidate)) {
                candidateCount++;
            }
        }
        System.out.println(candidateCount);
    }
    
    // 후보 숫자 유효성 검사 (0 포함 또는 중복 숫자 제거)
    static boolean isValidNumber(String num) {
        return num.charAt(0) != '0' && num.charAt(1) != '0' && num.charAt(2) != '0' // 0이 포함되면 안됨
            && num.charAt(0) != num.charAt(1) && num.charAt(0) != num.charAt(2) && num.charAt(1) != num.charAt(2); // 중복 숫자 금지
    }
    
    // 주어진 후보 숫자가 모든 질문의 조건을 만족하는지 검사
    static boolean isPossible(String candidate) {
        for (int i = 0; i < N; i++) {
            if (!checkStrikeAndBall(candidate, guessNum[i], strike[i], ball[i])) {
                return false;
            }
        }
        return true;
    }
    
    // 스트라이크와 볼 개수를 검사
    static boolean checkStrikeAndBall(String candidate, String target, int expectedStrike, int expectedBall) {
        int strikeCount = 0, ballCount = 0;
        
        for (int i = 0; i < 3; i++) {
            if (candidate.charAt(i) == target.charAt(i)) {
                strikeCount++; // 스트라이크 확인
            } else if (target.contains(String.valueOf(candidate.charAt(i)))) {
                ballCount++; // 볼 확인
            }
        }
        
        return strikeCount == expectedStrike && ballCount == expectedBall;
    }
}