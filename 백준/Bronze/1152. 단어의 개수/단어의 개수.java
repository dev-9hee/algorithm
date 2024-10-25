import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String text = sc.nextLine().trim(); // 앞뒤 공백 제거
        
        // 빈 문자열 체크
        if(text.isEmpty()) {
            System.out.println(0);
        } else {
            String[] words = text.split("\\s+"); // 연속된 공백을 하나로 처리
            System.out.println(words.length);
        }
        
        sc.close();
    }
}