import java.util.*;

public class Main {
    
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in); 
        
        // 윷짝들의 상태를 나타내는 결과 입력 (3줄)
        for (int i=0; i<3; i++) {
            int[] result = new int[4]; // 윷짝 상태를 저장할 배열
            int count = 0;
            
            for (int j=0; j<4; j++) {
                result[j] = sc.nextInt();
            }
            
            // 배 개수 카운트
            for (int num : result) {
                if (num == 0) count++;
            }
            
            if (count == 1) System.out.println("A");
            if (count == 2) System.out.println("B");
            if (count == 3) System.out.println("C");
            if (count == 4) System.out.println("D");
            if (count == 0) System.out.println("E");
        }
    }
}