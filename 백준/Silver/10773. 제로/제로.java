import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int k = Integer.parseInt(br.readLine()); // 정수의 개수 K

        Stack<Integer> stack = new Stack<>(); // 정수를 저장할 스택

        for (int i = 0; i < k; i++) {
            int num = Integer.parseInt(br.readLine());

            if (num == 0) { // 입력된 정수가 0이면 최근에 쓴 수를 지움
                stack.pop();
            } else { // 0이 아닌 정수는 스택에 추가
                stack.push(num);
            }
        }

        // 스택에 저장된 모든 정수의 합을 계산
        int sum = 0;
        while (!stack.isEmpty()) { // 스텍이 빌 때까지 반복
            sum += stack.pop();
        }

        System.out.println(sum);
    }
}
