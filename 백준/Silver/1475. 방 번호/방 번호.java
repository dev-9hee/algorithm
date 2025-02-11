import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        
        int[] count = new int[10]; // 0~9 숫자 등장 횟수 저장
        for (char c : s.toCharArray()) {
            count[c - '0']++;
        }

        // 6과 9를 같은 그룹으로 묶고, 필요한 세트 계산
        int sixNine = (count[6] + count[9] + 1) / 2; // 올림 연산
        count[6] = count[9] = sixNine;

        // 최댓값 찾기
        int max = 0;
        for (int i = 0; i < 9; i++) { // 9번 인덱스는 이미 처리됨
            max = Math.max(max, count[i]);
        }

        System.out.print(max);
        
        br.close();
    }
}
