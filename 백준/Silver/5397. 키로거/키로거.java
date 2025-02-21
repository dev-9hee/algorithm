import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        // 각 테스트 케이스 처리
        for (int i = 0; i < t; i++) {
            String keyLog = br.readLine(); // 키로그 입력
            System.out.println(getPassword(keyLog));
        }
    }

    // 키로그를 분석하여 원래 비밀번호를 반환
    static String getPassword(String keyLog) {
        Deque<Character> left = new ArrayDeque<>(); // 커서 왼쪽의 문자들을 저장
        Deque<Character> right = new ArrayDeque<>(); // 커서 오른쪽의 문자들을 저장

        // 키로그의 각 문자 처리
        for (char c : keyLog.toCharArray()) {
            switch (c) {
                case '<': // 커서를 왼쪽으로 이동
                    // 왼쪽 덱의 마지막 요소를 오른쪽 덱의 첫 위치로 이동
                    if (!left.isEmpty()) right.addFirst(left.pollLast());
                    break;

                case '>': // 커서를 오른쪽으로 이동
                    // 오른쪽 덱의 첫 요소를 왼쪽 덱의 마지막 위치로 이동
                    if (!right.isEmpty()) left.addLast(right.pollFirst());
                    break;

                case '-': // 백스페이스 (왼쪽 문자 삭제)
                    // 커서 바로 왼쪽 문자 제거
                    if (!left.isEmpty()) left.pollLast();
                    break;

                default: // 일반 문자 입력
                    // 커서 위치(왼쪽 덱의 마지막)에 문자 추가
                    left.addLast(c);
                    break;

            }
        }

        StringBuilder sb = new StringBuilder();

        // 왼쪽 덱의 문자들을 순서대로 결과에 추가
        // ArrayDeque는 Iterator가 요소를 추가된 순서대로 반환
        for (Character c : left) {
            sb.append(c);
        }

        // 오른쪽 덱의 문자들을 순서대로 결과에 추가
        for (Character c : right) {
            sb.append(c);
        }

        // 원래 비밀번호 반환
        return sb.toString();
    }
}