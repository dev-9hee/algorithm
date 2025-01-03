import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] num = new int[5]; // 5개의 자연수를 저장할 배열
        int sum = 0;
        
        for (int i=0; i<5; i++) {
            num[i] = sc.nextInt();
            sum += num[i];
        }
        
        Arrays.sort(num); // 배열 정렬
        
        System.out.println(sum/5); // 평균
        System.out.println(num[2]); // 중앙값
        
        sc.close(); // 스캐너 닫기
    }
}