import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();

        int[] count = new int[10]; // 0~9까지 쓰인 횟수를 넣을 배열
        String s = Integer.toString(a * b * c); // A x B x C -> 문자열

        // 각 숫자 문자 갯수 세기
        for (int i = 0; i < s.length(); i++) {
            count[Character.getNumericValue(s.charAt(i))]++;
        }

        // 결과 출력
        for (int i = 0; i < 10; i++) {
            System.out.println(count[i]);
        }

        sc.close();
    }
}